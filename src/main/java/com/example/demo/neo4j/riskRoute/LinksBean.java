package com.example.demo.neo4j.riskRoute;

import io.swagger.annotations.ApiModelProperty;

import java.util.Set;

public class LinksBean {
    /**
     * id : 2C9C327DAF4BD108B89EC45D09D36CFE1F6C9F15F6EEE3EE87F721BD0818507F
     * target : 1F6C9F15F6EEE3EE87F721BD0818507F
     * source : 2C9C327DAF4BD108B89EC45D09D36CFE
     * lineName : 法人代表; 董事; 投资(投资金额：5000.00万人民币元，投资占比：50.00%); 高管
     * type : 4
     * lineType : 3
     * invRatio : 50.00%
     * invConum : 5000.000000
     * regCapCur : 万人民币元
     */

    @ApiModelProperty(value = "link的id", example = "2C9C327DAF4BD108B89EC45D09D36CFE1F6C9F15F6EEE3EE87F721BD0818507F")
    private String id;
    @ApiModelProperty(value = "起点的id值", example = "1F6C9F15F6EEE3EE87F721BD0818507F")
    private String target;
    @ApiModelProperty(value = "终点的id值", example = "2C9C327DAF4BD108B89EC45D09D36CFE")
    private String source;
    @ApiModelProperty(value = "投资; 法人代表; 董事; 合伙; 监事; 高管\", # 线上显示的字, 英文分号加空格(; ) 如果投资有金额那么投资后面包含比例和数额", example = "法人代表; 董事; 投资(投资金额：5000.00万人民币元，投资占比：50.00%); 高管")
    private String lineName;
    @ApiModelProperty(value = "任职1; 企业投资2; 股东投资3; 董监高法投资4  (过滤关系用的名字)", example = "1")
    private int type;
    @ApiModelProperty(value = "1: 投资; 2: 任职; 3: 投资任职  (线的类型)", example = "1")
    private int lineType;
    @ApiModelProperty(value = "2位小数。0和未知处理为\"\"", example = "50.00%")
    private String invRatio = "";
    @ApiModelProperty(value = "6位小数。投资比例。0和未知的情况处理为\"\"", example = "5000.000000")
    private String invConum = "";
    @ApiModelProperty(value = "投资币种", example = "万人民币元")
    private String regCapCur = "万人民币元";


    private Set<String> typeStr;
    private Set<String> lineNameTemp;

    public LinksBean() {
    }

    public LinksBean(String target, String source) {
        this.target = target;
        this.source = source;
        this.id = source + target;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLineType() {
        return lineType;
    }

    public void setLineType(int lineType) {
        this.lineType = lineType;
    }

    public String getInvRatio() {
        return invRatio;
    }

    public void setInvRatio(String invRatio) {
        this.invRatio = invRatio;
    }

    public String getInvConum() {
        return invConum;
    }

    public void setInvConum(String invConum) {
        this.invConum = invConum;
    }

    public String getRegCapCur() {
        return regCapCur;
    }

    public void setRegCapCur(String regCapCur) {
        this.regCapCur = regCapCur;
    }

    public Set<String> getTypeStr() {
        return typeStr;
    }

    public void setTypeStr(Set<String> typeStr) {
        this.typeStr = typeStr;
    }

    public Set<String> getLineNameTemp() {
        return lineNameTemp;
    }

    public void setLineNameTemp(Set<String> lineNameTemp) {
        this.lineNameTemp = lineNameTemp;
    }
}