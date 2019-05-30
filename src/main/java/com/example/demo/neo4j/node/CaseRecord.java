package com.example.demo.neo4j.node;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * @Auther: wdq
 * @Date: 19-5-24 16:02
 **/
@NodeEntity
public class CaseRecord {

    //@Property("sc_data_id")
    private String sc_data_id;
    //@Property("publish_date")
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


//    @Relationship("ShixinCompany")
//    private ShixinCompany shixinCompany;
//    @Relationship("SszcCompany")
//    private SszcCompany sszcCompany;
//    @Relationship("ZhixingCompany")
//    private ZhixingCompany zhixingCompany;
//
//    public ShixinCompany getShixinCompany() {
//        return shixinCompany;
//    }
//
//    public void setShixinCompany(ShixinCompany shixinCompany) {
//        this.shixinCompany = shixinCompany;
//    }
//
//    public SszcCompany getSszcCompany() {
//        return sszcCompany;
//    }
//
//    public void setSszcCompany(SszcCompany sszcCompany) {
//        this.sszcCompany = sszcCompany;
//    }
//
//    public ZhixingCompany getZhixingCompany() {
//        return zhixingCompany;
//    }
//
//    public void setZhixingCompany(ZhixingCompany zhixingCompany) {
//        this.zhixingCompany = zhixingCompany;
//    }
}
