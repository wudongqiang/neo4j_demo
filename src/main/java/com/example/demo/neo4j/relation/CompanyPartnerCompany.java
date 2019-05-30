package com.example.demo.neo4j.relation;

import com.example.demo.neo4j.BaseEntity;

/**
 *
 * @Auther: wdq
 * @Date: 19-5-24 10:22
 **/
public class CompanyPartnerCompany extends BaseEntity {

    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
