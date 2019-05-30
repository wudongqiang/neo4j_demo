package com.example.demo.neo4j;

import org.neo4j.ogm.annotation.Property;
import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * @Auther: wdq
 * @Date: 19-5-27 09:42
 **/
public class RelationLayer {

    private Long id;
    //@Property("relation")
    private String relation;
    //@Property("layer")
    private Integer layer;

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
