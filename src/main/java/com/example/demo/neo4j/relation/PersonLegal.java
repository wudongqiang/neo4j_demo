package com.example.demo.neo4j.relation;

import com.example.demo.neo4j.BaseEntity;
import com.example.demo.neo4j.node.BCompany;
import com.example.demo.neo4j.node.Company;
import com.example.demo.neo4j.node.Person;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * 法人
 * @Auther: wdq
 * @Date: 19-5-24 14:13
 **/
@RelationshipEntity("PersonLegal")
@QueryResult
public class PersonLegal extends BaseEntity {

    private String position;

    @EndNode
    private BCompany sCompany;
    @StartNode
    private Person person;

    public BCompany getsCompany() {
        return sCompany;
    }

    public void setsCompany(BCompany sCompany) {
        this.sCompany = sCompany;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
