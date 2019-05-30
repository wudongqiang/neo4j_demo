package com.example.demo.neo4j;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;

/**
 * @Auther: wdq
 * @Date: 19-5-27 09:42
 **/
@QueryResult
public class RelationPath {

    @JsonProperty("nodes")
    private List<NodeInfo> nodes;
    @JsonProperty("ships")
    private List<RelationShips> ships;

    public List<NodeInfo> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeInfo> nodes) {
        this.nodes = nodes;
    }

    public List<RelationShips> getShips() {
        return ships;
    }

    public void setShips(List<RelationShips> ships) {
        this.ships = ships;
    }

}
