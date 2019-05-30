package com.example.demo.neo4j.riskRoute;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: zhaopeng.chen
 * @date: 18-4-11 下午2:48
 */
public class RiskRouteResponse {

    /**
     * source : 1F6C9F15F6EEE3EE87F721BD0818507F
     * target : C34634AD6AD75E6B7B1746F2E3C4576A
     * currentNetwork : {"nodes":[{"cateType":2,"oneLevelLinkedNodes":["2052DAA1525E2D097AAF07F6BAF652A5","C34634AD6AD75E6B7B1746F2E3C4576A"],"name":"谢光强","id":"573C7FBC07BAA80363B51803F6DE2862","regCap":"","regCapCur":"","status":-1,"esDate":"","isRisk":false,"isLegal":false,"layer":[5],"pathNum":[1]},{"cateType":1,"oneLevelLinkedNodes":["573C7FBC07BAA80363B51803F6DE2862"],"name":"重庆华强控股（集团）有限公司","id":"C34634AD6AD75E6B7B1746F2E3C4576A","regCap":"16252.000000","regCapCur":"156","status":1,"esDate":"2003-10-10","isRisk":true,"isLegal":false,"layer":[6],"pathNum":[1]},{"cateType":2,"oneLevelLinkedNodes":["9F8254287BA252A1D926B72FD648E8A2","1F6C9F15F6EEE3EE87F721BD0818507F"],"name":"张青","id":"C31E24D5B6430CF1E8FCD5A256D76517","regCap":"","regCapCur":"","status":-1,"esDate":"","isRisk":false,"isLegal":false,"layer":[2],"pathNum":[2]},{"cateType":0,"oneLevelLinkedNodes":["2C9C327DAF4BD108B89EC45D09D36CFE","C31E24D5B6430CF1E8FCD5A256D76517"],"name":"重庆市郑胖子农产品开发有限公司","id":"1F6C9F15F6EEE3EE87F721BD0818507F","regCap":"10000.000000","regCapCur":"156","status":1,"esDate":"2002-09-24","isRisk":true,"isLegal":false,"layer":[1],"pathNum":[1]},{"cateType":2,"oneLevelLinkedNodes":["1F6C9F15F6EEE3EE87F721BD0818507F","9F8254287BA252A1D926B72FD648E8A2"],"name":"粟坤","id":"2C9C327DAF4BD108B89EC45D09D36CFE","regCap":"","regCapCur":"","status":-1,"esDate":"","isRisk":false,"isLegal":true,"layer":[2],"pathNum":[1]},{"cateType":1,"oneLevelLinkedNodes":["2C9C327DAF4BD108B89EC45D09D36CFE","2052DAA1525E2D097AAF07F6BAF652A5","C31E24D5B6430CF1E8FCD5A256D76517"],"name":"重庆市万通工业有限公司","id":"9F8254287BA252A1D926B72FD648E8A2","regCap":"1000.000000","regCapCur":"156","status":1,"esDate":"1996-05-07","isRisk":true,"isLegal":false,"layer":[3],"pathNum":[1]},{"cateType":1,"oneLevelLinkedNodes":["9F8254287BA252A1D926B72FD648E8A2","573C7FBC07BAA80363B51803F6DE2862"],"name":"綦江民生村镇银行股份有限公司","id":"2052DAA1525E2D097AAF07F6BAF652A5","regCap":"6000.000000","regCapCur":"156","status":1,"esDate":"2010-09-02","isRisk":true,"isLegal":false,"layer":[4],"pathNum":[1]}],"links":[{"id":"2C9C327DAF4BD108B89EC45D09D36CFE1F6C9F15F6EEE3EE87F721BD0818507F","target":"1F6C9F15F6EEE3EE87F721BD0818507F","source":"2C9C327DAF4BD108B89EC45D09D36CFE","lineName":"法人代表; 董事; 投资(投资金额：5000.00万人民币元，投资占比：50.00%); 高管","type":4,"lineType":3,"invRatio":"50.00%","invConum":"5000.000000","regCapCur":"万人民币元"},{"id":"2C9C327DAF4BD108B89EC45D09D36CFE9F8254287BA252A1D926B72FD648E8A2","target":"9F8254287BA252A1D926B72FD648E8A2","source":"2C9C327DAF4BD108B89EC45D09D36CFE","lineName":"法人代表; 董事; 投资(投资金额：500.00万人民币元，投资占比：50.00%); 高管","type":4,"lineType":3,"invRatio":"50.00%","invConum":"500.000000","regCapCur":"万人民币元"},{"id":"9F8254287BA252A1D926B72FD648E8A22052DAA1525E2D097AAF07F6BAF652A5","target":"2052DAA1525E2D097AAF07F6BAF652A5","source":"9F8254287BA252A1D926B72FD648E8A2","lineName":"投资(投资金额：120.00万人民币元，投资占比：2.00%)","type":2,"lineType":1,"invRatio":"2.00%","invConum":"120.000000","regCapCur":"万人民币元"},{"id":"573C7FBC07BAA80363B51803F6DE28622052DAA1525E2D097AAF07F6BAF652A5","target":"2052DAA1525E2D097AAF07F6BAF652A5","source":"573C7FBC07BAA80363B51803F6DE2862","lineName":"投资(投资金额：120.00万人民币元，投资占比：2.00%); 高管","type":4,"lineType":3,"invRatio":"2.00%","invConum":"120.000000","regCapCur":"万人民币元"},{"id":"573C7FBC07BAA80363B51803F6DE2862C34634AD6AD75E6B7B1746F2E3C4576A","target":"C34634AD6AD75E6B7B1746F2E3C4576A","source":"573C7FBC07BAA80363B51803F6DE2862","lineName":"法人代表; 董事; 投资(投资金额：7741.23万人民币元，投资占比：47.63%)","type":4,"lineType":3,"invRatio":"47.63%","invConum":"7741.235832","regCapCur":"万人民币元"},{"id":"C31E24D5B6430CF1E8FCD5A256D765171F6C9F15F6EEE3EE87F721BD0818507F","target":"1F6C9F15F6EEE3EE87F721BD0818507F","source":"C31E24D5B6430CF1E8FCD5A256D76517","lineName":"投资(投资金额：5000.00万人民币元，投资占比：50.00%); 监事","type":4,"lineType":3,"invRatio":"50.00%","invConum":"5000.000000","regCapCur":"万人民币元"},{"id":"C31E24D5B6430CF1E8FCD5A256D765179F8254287BA252A1D926B72FD648E8A2","target":"9F8254287BA252A1D926B72FD648E8A2","source":"C31E24D5B6430CF1E8FCD5A256D76517","lineName":"投资(投资金额：500.00万人民币元，投资占比：50.00%); 监事","type":4,"lineType":3,"invRatio":"50.00%","invConum":"500.000000","regCapCur":"万人民币元"}],"paths":[["1F6C9F15F6EEE3EE87F721BD0818507F","2C9C327DAF4BD108B89EC45D09D36CFE","9F8254287BA252A1D926B72FD648E8A2","2052DAA1525E2D097AAF07F6BAF652A5","573C7FBC07BAA80363B51803F6DE2862","C34634AD6AD75E6B7B1746F2E3C4576A"],["1F6C9F15F6EEE3EE87F721BD0818507F","C31E24D5B6430CF1E8FCD5A256D76517","9F8254287BA252A1D926B72FD648E8A2","2052DAA1525E2D097AAF07F6BAF652A5","573C7FBC07BAA80363B51803F6DE2862","C34634AD6AD75E6B7B1746F2E3C4576A"]]}
     */
    @ApiModelProperty(value = "source节点/中心节点的id", example = "1F6C9F15F6EEE3EE87F721BD0818507F")
    private String source;
    @ApiModelProperty(value = "target节点/中心节点的id", example = "C34634AD6AD75E6B7B1746F2E3C4576A")
    private String target;
    @ApiModelProperty(value = "风险链条路径数据")
    private CurrentNetworkBean currentNetwork;

    public RiskRouteResponse() {
    }

    public RiskRouteResponse(String source, String target) {
        this.source = source;
        this.target = target;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public CurrentNetworkBean getCurrentNetwork() {
        return currentNetwork;
    }

    public void setCurrentNetwork(CurrentNetworkBean currentNetwork) {
        this.currentNetwork = currentNetwork;
    }


}
