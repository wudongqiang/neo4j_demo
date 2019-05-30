package com.example.demo.neo4j.node;

import com.example.demo.neo4j.BaseEntity;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @Auther: wdq
 * @Date: 19-5-24 14:38
 **/
@NodeEntity("SszcCompany")
public class SszcCompany extends BaseEntity {

    private String sc_data_id;
    private String publish_date;

    public String getSc_data_id() {
        return sc_data_id;
    }

    public void setSc_data_id(String sc_data_id) {
        this.sc_data_id = sc_data_id;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }
}