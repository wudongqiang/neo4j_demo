package com.example.demo.neo4j;

import java.util.List;

/**
 * @Auther: wdq
 * @Date: 19-5-29 12:01
 **/

public class RelationShips {

    private Long id;
    private String version;
    private String type;//	"CompanyInvestToCompany"
    private Long startNode;//	6272902
    private Long endNode;//	31578703
    private String primaryIdName;

    private List<RelationProperty> propertyList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getStartNode() {
        return startNode;
    }

    public void setStartNode(Long startNode) {
        this.startNode = startNode;
    }

    public Long getEndNode() {
        return endNode;
    }

    public void setEndNode(Long endNode) {
        this.endNode = endNode;
    }

    public String getPrimaryIdName() {
        return primaryIdName;
    }

    public void setPrimaryIdName(String primaryIdName) {
        this.primaryIdName = primaryIdName;
    }

    public List<RelationProperty> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<RelationProperty> propertyList) {
        this.propertyList = propertyList;
    }
}
