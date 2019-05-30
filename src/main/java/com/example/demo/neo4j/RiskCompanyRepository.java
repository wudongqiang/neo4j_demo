
package com.example.demo.neo4j;

import com.example.demo.neo4j.node.Company;
import com.example.demo.neo4j.node.RiskCaseRecord;
import com.example.demo.neo4j.relation.RelationPathData;
import org.neo4j.driver.v1.StatementResult;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public interface RiskCompanyRepository extends Neo4jRepository<Object,Long> {


    @Query("match p=(n:Company {companyName:{companyName}})-[:CompanyInvestToCompany|CompanyPartnerCompany|PersonInvestToCompany|PersonPosition|PersonLegal*0..2]-(removeCompany:Company)\n" +
            "        using index n:Company(companyName)\n" +
            "        where n <> removeCompany\n" +
            "        with collect(removeCompany)  as removeCompanies\n" +
            "        match p=(n:Company {companyName:{companyName}})-[r:CompanyInvestToCompany|CompanyPartnerCompany|PersonInvestToCompany|PersonPosition|PersonLegal*3..5]-(riskCompany:Company)-[riskRel:CompanyShixin|CompanyZhixing|CompanySszc]->()\n" +
            "        where not riskCompany in removeCompanies and n<>riskCompany \n" +
            "        and not riskCompany.companyName  =~ '.*资本.*' and  not riskCompany.companyName =~ '.*投资.*' and  not riskCompany.companyName =~ '.*创投.*'\n" +
            "        and  not riskCompany.companyName =~ '.*基金.*' and  not riskCompany.companyName =~ '.*资产管理.*'\n" +
            "        and all(a_n in nodes(p)[1..2]\n" +
            "            where a_n.companyName is null\n" +
            "                or  ( not a_n.companyName =~ '.*投资.*' and not a_n.companyName =~ '.*资本.*' and not a_n.companyName =~ '.*创投.*'\n" +
            "                and not a_n.companyName =~ '.*基金.*' and not a_n.companyName =~ '.*资产管理.*' )\n" +
            "        )\n" +
            "        return distinct riskCompany limit 100")
    List<Company> getRiskCompany(@Param("companyName") String companyName);

    @Query("match (riskCompany:Company)-[riskRel:CompanyShixin|CompanyZhixing|CompanySszc]-(riskCase) " +
            " using index riskCompany:Company(companyId) " +
            " where riskCompany.companyId in {companyIds} " +
            " and riskCase.publish_date <> '\\\\N' with riskCase" +
            " order by riskCase.publish_date desc, riskCompany " +
            //" return riskCompany.companyId as companyId, collect(riskCase)[..100] as caseRecords" +
            " return riskCompany.companyId as companyId, riskCase.sc_data_id as caseId,riskCase.publish_date as publishDate,labels(riskCase)[0] as type " +
            " limit 100 ")
    List<RiskCaseRecord> getCompanyRiskInfo(@Param("companyIds") List<String> companyIds);


    /**
     * 获取企业信息
     * @param companyName
     * @return
     */
    @Query("match (n:Company {companyName:{companyName}}) return n")
    Company getCompany(@Param("companyName") String companyName);

    @Query("match p=shortestPath((n:Company {companyName:{sourceName}})-[r:CompanyInvestToCompany|CompanyPartnerCompany|PersonInvestToCompany|PersonPosition|PersonLegal*0..5]-(x:Company {companyName:{targetName}}))\n" +
            "        using index n:Company(companyName)\n" +
            "        using index x:Company(companyName)\n" +
            "        where n <> x \n" +
            "        and all(a_n in nodes(p)[1..]\n" +
            "            where a_n.companyName is null\n" +
            "                or  ( not a_n.companyName =~ '.*投资.*' and not a_n.companyName =~ '.*资本.*' and not a_n.companyName =~ '.*创投.*'\n" +
            "                and not a_n.companyName =~ '.*基金.*' and not a_n.companyName =~ '.*资产管理.*' )\n" +
            "        )\n" +
            "        return p\n" +
            "        limit 1")
    List<Company> getRiskCompanyShortPath(@Param("sourceName") String companyName,@Param("targetName") String targetName);


    @Query("match p=allShortestPaths((n:Company {companyId:{sourceId}})\n" +
            "-[r:CompanyInvestToCompany|CompanyPartnerCompany|PersonInvestToCompany|PersonPosition|PersonLegal*0..5]\n" +
            "-(x:Company {companyId:{targetId}}))\n" +
            "        where n.companyId <> x.companyId \n" +
            "        and   not x.companyName=~ '.*资本.*' and  not x.companyName =~ '.*投资.*' and not x.companyName   =~ '.*创投.*'\n" +
            "        and  not x.companyName =~ '.*基金.*' and  not x.companyName =~ '.*资产管理.*'\n" +
            "        and all(a_n in nodes(p)[1..]\n" +
            "            where a_n.companyName is null\n" +
            "                or  ( not a_n.companyName =~ '.*投资.*' and not a_n.companyName =~ '.*资本.*' and not a_n.companyName =~ '.*创投.*'\n" +
            "                and not a_n.companyName =~ '.*基金.*' and not a_n.companyName =~ '.*资产管理.*' )\n" +
            "        )\n" +
            "       with p,r order by length(p)  limit 10\n" +
            "     return nodes(p) as nodes,   RELATIONSHIPS(p) as ships")
    List<RelationPath> getRiskCompanyRelationPath(@Param("sourceId") String sourceId, @Param("targetId") String targetId);




    /* 获取关系类型和图的层数
     */
    @Query("match p=shortestPath((n:Company {companyName:\"嘉兴国邦汽车销售有限公司\"})-[r:CompanyInvestToCompany|CompanyPartnerCompany|PersonInvestToCompany|PersonPosition|PersonLegal*0..5]-(x:Company {companyName:\"中国兵器装备集团公司\"}))\n" +
            "        using index n:Company(companyName)\n" +
            "        using index x:Company(companyName)\n" +
            "        where n <> x\n" +
            "        and all(a_n in nodes(p)[1..]\n" +
            "            where a_n.companyName is null\n" +
            "                or  ( not a_n.companyName =~ '.*投资.*' and not a_n.companyName =~ '.*资本.*' and not a_n.companyName =~ '.*创投.*'\n" +
            "                and not a_n.companyName =~ '.*基金.*' and not a_n.companyName =~ '.*资产管理.*' )\n" +
            "        )\n" +
            "        with p ,r,length(p) as layer  limit 1\n" +
            "        unwind r  as relation\n" +
            "        return distinct type(relation) as relation,layer")
    List<RelationLayer> getRaltionAndLayer();


    @Query("match (riskCompany:Company)-[riskRel:CompanyShixin|CompanyZhixing|CompanySszc]-(riskCase) " +
            " using index riskCompany:Company(companyId)        " +
            " where riskCompany.companyId in {companyIds}" +
            " with distinct riskCompany.companyId as cid " +
            " return cid  limit 100")
    Optional<List<String>> getRiskCompanyId(@Param("companyIds") List<String> companyIds);

}
