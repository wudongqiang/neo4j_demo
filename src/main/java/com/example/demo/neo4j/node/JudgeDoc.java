package com.example.demo.neo4j.node;

import com.example.demo.neo4j.BaseEntity;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @Auther: wdq
 * @Date: 19-5-24 14:39
 **/
@NodeEntity("JudgeDoc")
public class JudgeDoc extends BaseEntity {

    private String sc_data_id;
    private String case_reason;
    private String trail_date;

    public String getSc_data_id() {
        return sc_data_id;
    }

    public void setSc_data_id(String sc_data_id) {
        this.sc_data_id = sc_data_id;
    }

    public String getCase_reason() {
        return case_reason;
    }

    public void setCase_reason(String case_reason) {
        this.case_reason = case_reason;
    }

    public String getTrail_date() {
        return trail_date;
    }

    public void setTrail_date(String trail_date) {
        this.trail_date = trail_date;
    }
}
