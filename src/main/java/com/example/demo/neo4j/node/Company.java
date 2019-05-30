package com.example.demo.neo4j.node;

import com.example.demo.neo4j.BaseEntity;
import com.example.demo.neo4j.relation.CompanyInvestToCompany;
import com.example.demo.neo4j.relation.PersonInvestToCompany;
import com.example.demo.neo4j.relation.PersonLegal;
import com.example.demo.neo4j.relation.PersonPosition;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;
import java.util.Set;

/*
 * @NodeEntity：声明该类为Neo4j的节点类
 * @GraphId：Neo4j的主键id，必须为长整型
 * @Property：Neo4j的节点属性值，支持8种基本类型外加String
 */
@NodeEntity
public class Company extends BaseEntity {

    private String companyId;
    private String esDate;
    private String regCapCur;
    private String companyName;
    private String regCap;
    private String status;
    private String auditDate;


    //股东相关
    @Relationship(value = "CompanyInvestToCompany",direction = Relationship.OUTGOING)
    private Set<CompanyInvestToCompany> companyInvestToCompany;
    //股东相关
    @Relationship(value ="PersonInvestToCompany",direction = Relationship.OUTGOING)
    private Set<PersonInvestToCompany> personInvestToCompany;
    //法人代表相关
    @Relationship(value ="PersonLegal",direction = Relationship.UNDIRECTED)
    private Set<PersonLegal> personLegal;
    //高管相关
    @Relationship(value ="PersonPosition",direction = Relationship.UNDIRECTED)
    private Set<PersonPosition> personPosition;

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

    public Set<CompanyInvestToCompany> getCompanyInvestToCompany() {
        return companyInvestToCompany;
    }

    public void setCompanyInvestToCompany(Set<CompanyInvestToCompany> companyInvestToCompany) {
        this.companyInvestToCompany = companyInvestToCompany;
    }

    public Set<PersonInvestToCompany> getPersonInvestToCompany() {
        return personInvestToCompany;
    }

    public void setPersonInvestToCompany(Set<PersonInvestToCompany> personInvestToCompany) {
        this.personInvestToCompany = personInvestToCompany;
    }

    public Set<PersonLegal> getPersonLegal() {
        return personLegal;
    }

    public void setPersonLegal(Set<PersonLegal> personLegal) {
        this.personLegal = personLegal;
    }

    public Set<PersonPosition> getPersonPosition() {
        return personPosition;
    }

    public void setPersonPosition(Set<PersonPosition> personPosition) {
        this.personPosition = personPosition;
    }
}