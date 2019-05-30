package com.example.demo.neo4j.node;

import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;

/**
 * @Auther: wdq
 * @Date: 19-5-24 16:18
 **/
@QueryResult
public class RiskInfoData {

    private List<RiskCaseRecord> riskInfos;

    public List<RiskCaseRecord> getRiskInfos() {
        return riskInfos;
    }

    public void setRiskInfos(List<RiskCaseRecord> riskInfos) {
        this.riskInfos = riskInfos;
    }
}
