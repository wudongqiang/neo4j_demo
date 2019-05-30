package com.example.demo.neo4j;

import org.springframework.data.annotation.Id;

/**
 * @Auther: wdq
 * @Date: 19-5-24 14:33
 **/
public class BaseEntity {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
