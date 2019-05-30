package com.example.demo.neo4j.relation;

import com.example.demo.neo4j.BaseEntity;
import com.example.demo.neo4j.node.BCompany;
import com.example.demo.neo4j.node.Company;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * 企业对外投资
 *
 * @Auther: wdq
 * @Date: 19-5-24 10:22
 **/
@RelationshipEntity("CompanyInvestToCompany")
@QueryResult
public class CompanyInvestToCompany extends BaseEntity {

    private String invConum;
    private String conDate;
    private String regCapCur;
    private String ratio;

    @StartNode
    private BCompany sCompany;
    @EndNode
    private BCompany eCompany;

    public BCompany getsCompany() {
        return sCompany;
    }

    public void setsCompany(BCompany sCompany) {
        this.sCompany = sCompany;
    }

    public BCompany geteCompany() {
        return eCompany;
    }

    public void seteCompany(BCompany eCompany) {
        this.eCompany = eCompany;
    }

    public String getInvConum() {
        return invConum;
    }

    public void setInvConum(String invConum) {
        this.invConum = invConum;
    }

    public String getConDate() {
        return conDate;
    }

    public void setConDate(String conDate) {
        this.conDate = conDate;
    }

    public String getRegCapCur() {
        return regCapCur;
    }

    public void setRegCapCur(String regCapCur) {
        this.regCapCur = regCapCur;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }


}
