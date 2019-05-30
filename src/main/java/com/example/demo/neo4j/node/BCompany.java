package com.example.demo.neo4j.node;

import com.example.demo.neo4j.BaseEntity;
import com.example.demo.neo4j.relation.CompanyInvestToCompany;
import com.example.demo.neo4j.relation.PersonInvestToCompany;
import com.example.demo.neo4j.relation.PersonLegal;
import com.example.demo.neo4j.relation.PersonPosition;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

/*
 * @NodeEntity：声明该类为Neo4j的节点类
 * @GraphId：Neo4j的主键id，必须为长整型
 * @Property：Neo4j的节点属性值，支持8种基本类型外加String
 */
@NodeEntity
public class BCompany extends BaseEntity {

    private String companyId;
    private String esDate;
    private String regCapCur;
    private String companyName;
    private String regCap;
    private String status;
    private String auditDate;

    private String person;
    private String personId;

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getEsDate() {
        return esDate;
    }

    public void setEsDate(String esDate) {
        this.esDate = esDate;
    }

    public String getRegCapCur() {
        return regCapCur;
    }

    public void setRegCapCur(String regCapCur) {
        this.regCapCur = regCapCur;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegCap() {
        return regCap;
    }

    public void setRegCap(String regCap) {
        this.regCap = regCap;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(String auditDate) {
        this.auditDate = auditDate;
    }
}