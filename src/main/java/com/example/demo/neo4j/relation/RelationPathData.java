package com.example.demo.neo4j.relation;

import com.example.demo.neo4j.node.Company;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @Auther: wdq
 * @Date: 19-5-28 09:47
 **/
@RelationshipEntity
public class RelationPathData {

    @StartNode
    private Company companyStart;

    @EndNode
    private Company companyEnd;

//    @StartNode
//    private Company companyStart;
//
//    @EndNode
//    private Company companyEnd;


    public Company getCompanyStart() {
        return companyStart;
    }

    public void setCompanyStart(Company companyStart) {
        this.companyStart = companyStart;
    }

    public Company getCompanyEnd() {
        return companyEnd;
    }

    public void setCompanyEnd(Company companyEnd) {
        this.companyEnd = companyEnd;
    }
}
