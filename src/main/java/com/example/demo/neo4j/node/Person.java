package com.example.demo.neo4j.node;

import com.example.demo.neo4j.BaseEntity;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @Auther: wdq
 * @Date: 19-5-24 14:40
 **/
@NodeEntity("Person")
public class Person  extends BaseEntity {
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
}
