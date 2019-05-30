package com.example.demo.neo4j.riskRoute;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class CurrentNetworkBean {
    @ApiModelProperty("节点")
    private List<NodesBean> nodes;
    @ApiModelProperty("连接")
    private List<LinksBean> links;
    @ApiModelProperty("路径。可能有多条路径。里面的每一个数组是一条路径。")
    private List<List<String>> paths;

    public List<NodesBean> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodesBean> nodes) {
        this.nodes = nodes;
    }

    public List<LinksBean> getLinks() {
        return links;
    }

    public void setLinks(List<LinksBean> links) {
        this.links = links;
    }

    public List<List<String>> getPaths() {
        return paths;
    }

    public void setPaths(List<List<String>> paths) {
        this.paths = paths;
    }


}