package com.example.demo.neo4j.node;

import org.neo4j.ogm.annotation.Property;
import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * @Auther: wdq
 * @Date: 19-5-24 16:01
 **/
@QueryResult
public class RiskCaseRecord {

    @Property("companyId")
    private String companyId;
    @Property("caseId")
    private String caseId;
    @Property("publishDate")
    private String publishDate;

    @Property("type")
    private String type;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
