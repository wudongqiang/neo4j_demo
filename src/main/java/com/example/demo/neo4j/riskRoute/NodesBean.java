package com.example.demo.neo4j.riskRoute;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Objects;

public class NodesBean {
    /**
     * cateType : 2
     * oneLevelLinkedNodes : ["2052DAA1525E2D097AAF07F6BAF652A5","C34634AD6AD75E6B7B1746F2E3C4576A"]
     * name : 谢光强
     * id : 573C7FBC07BAA80363B51803F6DE2862
     * regCap :
     * regCapCur :
     * status : -1
     * esDate :
     * isRisk : false
     * isLegal : false
     * layer : [5]
     * pathNum : [1]
     */
    @ApiModelProperty(value = "0:中心公司,1:关联公司,2:人员", example = "2")
    private int cateType;
    @ApiModelProperty(value = "公司名字或人名", example = "谢光强")
    private String name;
    @ApiModelProperty(value = " 公司id或人id", example = "573C7FBC07BAA80363B51803F6DE2862")
    private String id;
    @ApiModelProperty(value = "注册资本， 未知处理为\"\"", example = "123.00")
    private String regCap;
    @ApiModelProperty(value = "币种，包含\"万\"字，未知处理为\"\"", example = "万人民币")
    private String regCapCur = "万人民币元";
    @ApiModelProperty(value = "公司的营业状态 1:在营,0:吊销或注销,-1:未知", example = "1")
    private int status;
    @ApiModelProperty(value = "公司的成立时间", example = "2015-09-09")
    private String esDate = "";
    @ApiModelProperty(value = "是否为风险节点。true：是风险点，false：不是风险点", example = "true")
    private boolean isRisk;
    @ApiModelProperty(value = " 是否为法人", example = "true")
    private boolean isLegal;
    @ApiModelProperty("直接相连的点")
    private List<String> oneLevelLinkedNodes;
    @ApiModelProperty(value = "该点所在层数，中心节点为1,从1开始算。前端用于布局", example = "[2,3]")
    private List<Integer> layer;
    @ApiModelProperty(value = " 路径数量，前端用于布局", example = "[1,2]")
    private List<Integer> pathNum;

    public int getCateType() {
        return cateType;
    }

    public void setCateType(int cateType) {
        this.cateType = cateType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegCap() {
        return regCap;
    }

    public void setRegCap(String regCap) {
        this.regCap = regCap;
    }

    public String getRegCapCur() {
        return regCapCur;
    }

    public void setRegCapCur(String regCapCur) {
        this.regCapCur = regCapCur;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEsDate() {
        return esDate;
    }

    public void setEsDate(String esDate) {
        this.esDate = esDate;
    }

    public boolean isIsRisk() {
        return isRisk;
    }

    public void setIsRisk(boolean isRisk) {
        this.isRisk = isRisk;
    }

    public boolean isIsLegal() {
        return isLegal;
    }

    public void setIsLegal(boolean isLegal) {
        this.isLegal = isLegal;
    }

    public List<String> getOneLevelLinkedNodes() {
        return oneLevelLinkedNodes;
    }

    public void setOneLevelLinkedNodes(List<String> oneLevelLinkedNodes) {
        this.oneLevelLinkedNodes = oneLevelLinkedNodes;
    }

    public List<Integer> getLayer() {
        return layer;
    }

    public void setLayer(List<Integer> layer) {
        this.layer = layer;
    }

    public List<Integer> getPathNum() {
        return pathNum;
    }

    public void setPathNum(List<Integer> pathNum) {
        this.pathNum = pathNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodesBean nodesBean = (NodesBean) o;
        return Objects.equals(name, nodesBean.name) &&
                Objects.equals(id, nodesBean.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}