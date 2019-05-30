package com.example.demo.web;

import com.example.demo.neo4j.*;
import com.example.demo.neo4j.node.Company;
import com.example.demo.neo4j.riskRoute.CurrentNetworkBean;
import com.example.demo.neo4j.riskRoute.LinksBean;
import com.example.demo.neo4j.riskRoute.NodesBean;
import com.example.demo.neo4j.riskRoute.RiskRouteResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.compress.utils.Sets;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by wdq on 16-11-10.
 */
@RestController
public class Neo4jController {

    @Autowired
    private RiskCompanyRepository riskCompanyRepository;

    @RequestMapping("/neo4j")
    public Object index(@RequestParam String companyName) {
        Object riskCompany = riskCompanyRepository.getRiskCompany(companyName);
        return riskCompany;
    }

    @RequestMapping("/neo4j/r")
    public Object indexr(@RequestParam String companyName) {
        List<Company> riskCompany = riskCompanyRepository.getRiskCompany(companyName);

        riskCompany.forEach(company -> {
            // List<List<Company>> shortPath = riskCompanyRepository.getRiskCompanyShortPath(companyName, company.getCompanyName());
            //m.put("shortPath", shortPath);

        });
        return riskCompany;
    }

    @RequestMapping("/neo4j/short")
    public Object getRiskCompanyShortPath(@RequestParam String sourceName, @RequestParam String targetName) {
        Object riskCompanyShortPath = riskCompanyRepository.getRiskCompanyShortPath(sourceName, targetName);
        return riskCompanyShortPath;
    }

    @RequestMapping("/neo4j/re1")
    public List<RelationPath> getRiskCompanyRelationPaths(@RequestParam String sourceId, @RequestParam String targetId) {
        Object riskCompanyShortPath = riskCompanyRepository.getRiskCompanyRelationPath(sourceId, targetId);

        return JsonHelpers.createObjectMapperAlways().convertValue(riskCompanyShortPath, new TypeReference<List<RelationPath>>() {
        });
    }

    @RequestMapping("/neo4j/re")
    public Object getRiskCompanyRelationPath(@RequestParam String sourceId, @RequestParam String targetId) {
        Object riskCompanyShortPath = riskCompanyRepository.getRiskCompanyRelationPath(sourceId, targetId);

        List<RelationPath> o = JsonHelpers.createObjectMapperAlways().convertValue(riskCompanyShortPath, new TypeReference<List<RelationPath>>() {
        });


        //风险链条路径
        RiskRouteResponse riskRouteResponse = new RiskRouteResponse(sourceId, targetId);

        if (CollectionUtils.isEmpty(o)) {
            return riskRouteResponse;
        }

        CurrentNetworkBean currentNetworkBean = new CurrentNetworkBean();
        riskRouteResponse.setCurrentNetwork(currentNetworkBean);

        //每一条路径的节点数据
        List<List<NodeInfo>> nodes = o.stream().map(RelationPath::getNodes).collect(Collectors.toList());
        //每一条路径的关系
        List<List<RelationShips>> ships = o.stream().map(RelationPath::getShips).collect(Collectors.toList());

        //节点 -- nodes
        currentNetworkBean.setNodes(getNodes(nodes, sourceId));

        //线 -- links
        //铺平list
        Map<Long, List<NodeInfo>> collect = nodes.stream().flatMap(Collection::stream).collect(Collectors.groupingBy(NodeInfo::getId));

        Map<String, List<LinksBean>> linksMap = ships.stream().map(ship ->
                ship.stream().map(item -> {
                    String sourceNodeId = Optional.ofNullable(collect.get(item.getStartNode()))
                            .flatMap(i -> i.stream().findFirst())
                            .map(node -> getStrValue(node.getCompanyId(), node.getPersonId())).orElse("");
                    String targetNodeId = Optional.ofNullable(collect.get(item.getEndNode()))
                            .flatMap(i -> i.stream().findFirst())
                            .map(node -> getStrValue(node.getCompanyId(), node.getPersonId())).orElse("");

                    LinksBean linksBean = new LinksBean(targetNodeId, sourceNodeId);
                    linksBean.setTypeStr(Sets.newHashSet(item.getType()));

                    if (RelationshipType.PERSON_INVEST_TO_COMPANY.getCode().equals(item.getType())
                            || RelationshipType.COMPANY_INVEST_TO_COMPANY.getCode().equals(item.getType())) {
                        linksBean.setLineNameTemp(Sets.newHashSet("投资"));
                    } else if (RelationshipType.PERSON_LEGAL.getCode().equals(item.getType())) {
                        linksBean.setLineNameTemp(Sets.newHashSet("法人代表"));
                    }

                    item.getPropertyList().forEach(p -> {
                        if ("ratio".equals(p.getKey()) && StringUtils.isNotEmpty(p.getValue())) {
                            linksBean.setInvRatio(new BigDecimal(p.getValue()).multiply(new BigDecimal(100)).setScale(2).toString() + "%");
                        }
                        if ("invConum".equals(p.getKey())
                                && StringUtils.isNotEmpty(p.getValue())
                                && new BigDecimal(p.getValue()).intValue() > 0) {
                            linksBean.setInvConum(p.getValue());
                        }

                        if ("position".equals(p.getKey())
                                && StringUtils.isNotEmpty(p.getValue())
                                && CollectionUtils.isEmpty(linksBean.getLineNameTemp())) {
                            linksBean.setLineNameTemp(Sets.newHashSet("其他人员".equals(p.getValue()) ? "高管" : p.getValue()));
                        }


                    });

                    return linksBean;
                }).collect(Collectors.toList())
        ).flatMap(Collection::stream).collect(Collectors.groupingBy(LinksBean::getId));

        List<LinksBean> links = new ArrayList<>(linksMap.size());
        //合并
        linksMap.forEach((k, linkValues) ->

        {
            LinksBean linksBean = linkValues.stream().findFirst()
                    .map(item -> new LinksBean(item.getTarget(), item.getSource()))
                    .orElseGet(LinksBean::new);
            for (LinksBean bean : linkValues) {
                if (StringUtils.isNotEmpty(bean.getInvRatio())) {
                    linksBean.setInvRatio(bean.getInvRatio());
                }
                if (StringUtils.isNotEmpty(bean.getInvConum())) {
                    linksBean.setInvConum(bean.getInvConum());
                }

                if (!CollectionUtils.isEmpty(bean.getTypeStr())) {
                    if (CollectionUtils.isEmpty(linksBean.getTypeStr())) {
                        linksBean.setTypeStr(bean.getTypeStr());
                    } else {
                        linksBean.getTypeStr().addAll(bean.getTypeStr());
                    }

                }
                if (!CollectionUtils.isEmpty(bean.getLineNameTemp())) {
                    if (CollectionUtils.isEmpty(linksBean.getLineNameTemp())) {
                        linksBean.setLineNameTemp(bean.getLineNameTemp());
                    } else {
                        linksBean.getLineNameTemp().addAll(bean.getLineNameTemp());
                    }
                }
            }

            //"type": 4, # type: int。任职1; 企业投资2; 股东投资3; 董监高法投资4  (过滤关系用的名字)。
            //"lineType": 1, # type: int。1: 投资; 2: 任职; 3: 投资任职  (线的类型)。
            linksBean.setType(getType(linksBean.getTypeStr()));
            linksBean.setLineType(getLineType(linksBean.getTypeStr()));
            linksBean.setLineType(getLineType(linksBean.getTypeStr()));

            //"lineName": "", # type: string。值域为。 "投资; 法人代表; 董事; 合伙; 监事; 高管",
            //# 线上显示的字, 英文分号加空格(; ) 如果投资有金额那么投资后面包含比例和数额。eg  投资（投资金额：45.89万人民币元，投资占比:100.00%）。
            if (!CollectionUtils.isEmpty(linksBean.getLineNameTemp())) {
                linksBean.setLineName(String.join(";", linksBean.getLineNameTemp()));
                if (StringUtils.isNotEmpty(linksBean.getInvConum()) && StringUtils.isNotEmpty(linksBean.getInvRatio())) {
                    linksBean.setLineName(linksBean.getLineName() + String.format("(投资金额：%s万人民币元，投资占比：%s)", linksBean.getInvConum(), linksBean.getInvRatio()));
                }
            }
            links.add(linksBean);

        });

        currentNetworkBean.setLinks(links);

        //路径 -- paths
        List<List<String>> paths = nodes.stream()
                .map(node -> node.stream().map(item -> getStrValue(item.getCompanyId(), item.getPersonId()))
                        .collect(Collectors.toList())
                ).distinct().collect(Collectors.toList());
        currentNetworkBean.setPaths(paths);

        return riskRouteResponse;
    }


    private List<NodesBean> getNodes(List<List<NodeInfo>> nodes, String sourceId) {
        //风险企业id
        List<String> riskCompanyIds = riskCompanyRepository.getRiskCompanyId(nodes.stream()
                .flatMap(Collection::stream)
                .map(NodeInfo::getCompanyId)
                .filter(StringUtils::isNotEmpty)
                .distinct()
                .collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
        Map<String, List<NodesBean>> nodesMap = nodes.stream()
                .map(nodeInfos -> {
                    List<NodesBean> nodesBeanList = new ArrayList<>(nodeInfos.size());
                    for (int i = 0, len = nodeInfos.size(); i < len; i++) {
                        NodeInfo item = nodeInfos.get(i);
                        NodesBean nodesBean = new NodesBean();
                        nodesBean.setEsDate(item.getEsDate());
                        nodesBean.setId(getStrValue(item.getCompanyId(), item.getPersonId()));
                        nodesBean.setName(getStrValue(item.getCompanyName(), item.getPerson()));

                        nodesBean.setRegCap(item.getRegCap());
                        nodesBean.setStatus(StringUtils.isNotEmpty(item.getStatus()) ? Integer.valueOf(item.getStatus()) : -1);

                        //"cateType": 0, # type: int。 0:中心公司,1:关联公司,2:人员 ；
                        if (sourceId.equals(item.getCompanyId()) || sourceId.equals(item.getPersonId())) {
                            nodesBean.setCateType(0);
                        } else if (StringUtils.isNotEmpty(item.getCompanyId())) {
                            nodesBean.setCateType(1);
                        } else {
                            nodesBean.setCateType(2);
                        }

                        // todo nodesBean.setIsLegal();
                        nodesBean.setIsRisk(riskCompanyIds.contains(nodesBean.getId()));
                        //路径数量 根据path 计算
                        nodesBean.setPathNum(Collections.singletonList(1));
                        //该点所在层数
                        nodesBean.setLayer(Collections.singletonList((i + 1)));

                        NodeInfo last;
                        NodeInfo next;
                        if (i == 0) {
                            //下一个节点id
                            next = nodeInfos.get(i + 1);
                            nodesBean.setOneLevelLinkedNodes(Collections.singletonList(getStrValue(next.getCompanyId(), next.getPersonId())));
                        } else if (i == len - 1) {
                            //上一个节点
                            last = nodeInfos.get(i - 1);
                            nodesBean.setOneLevelLinkedNodes(Collections.singletonList(getStrValue(last.getCompanyId(), last.getPersonId())));
                        } else {
                            //上一个节点
                            last = nodeInfos.get(i - 1);
                            //下一个节点
                            next = nodeInfos.get(i + 1);
                            nodesBean.setOneLevelLinkedNodes(Arrays.asList(getStrValue(last.getCompanyId(), last.getPersonId()),
                                    getStrValue(next.getCompanyId(), next.getPersonId())));
                        }
                        nodesBeanList.add(nodesBean);
                    }
                    return nodesBeanList;
                }).flatMap(Collection::stream)
                .collect(Collectors.groupingBy(NodesBean::getId));

        List<NodesBean> nodesBeanList = new ArrayList<>(nodesMap.size());
        nodesMap.forEach((id, nodeList) ->
            //合并处理 oneLevelLinkedNodes
            nodeList.stream().findFirst().ifPresent(data -> {
                List<String> linkedNodes = nodeList.stream()
                        .map(NodesBean::getOneLevelLinkedNodes)
                        .flatMap(Collection::stream)
                        .distinct()
                        .collect(Collectors.toList());
                //todo 可能需要注意linkedNodes顺序
                data.setOneLevelLinkedNodes(linkedNodes);
                nodesBeanList.add(data);
            })
        );
        return nodesBeanList;
    }

    private String getStrValue(String companyId, String personId) {
        return StringUtils.isNotEmpty(companyId) ? companyId : personId;
    }

    /**
     * @param relations
     * @return
     */
    private int getType(Set<String> relations) {
        //"type": 4, # type: int。任职1; 企业投资2; 股东投资3; 董监高法投资4  (过滤关系用的名字)。
        boolean flag = (relations.contains(RelationshipType.PERSON_POSITION.getCode()) || relations.contains(RelationshipType.PERSON_LEGAL.getCode()))
                && (relations.contains(RelationshipType.COMPANY_INVEST_TO_COMPANY.getCode()) || relations.contains(RelationshipType.PERSON_INVEST_TO_COMPANY.getCode()));
        if (flag) {
            return 4;
        }

        if (relations.contains(RelationshipType.PERSON_INVEST_TO_COMPANY.getCode())) {
            return 3;
        }

        if (relations.contains(RelationshipType.COMPANY_INVEST_TO_COMPANY.getCode())) {
            return 2;
        }


        if (relations.contains(RelationshipType.PERSON_POSITION.getCode())
                || relations.contains(RelationshipType.PERSON_LEGAL.getCode())) {
            return 1;
        }
        return 0;
    }

    /**
     * @param relations
     * @return
     */
    private int getLineType(Set<String> relations) {
        //"lineType": 1, # type: int。1: 投资; 2: 任职; 3: 投资任职  (线的类型)。
        boolean flag = (relations.contains(RelationshipType.PERSON_POSITION.getCode()) || relations.contains(RelationshipType.PERSON_LEGAL.getCode()))
                && (relations.contains(RelationshipType.COMPANY_INVEST_TO_COMPANY.getCode()) || relations.contains(RelationshipType.PERSON_INVEST_TO_COMPANY.getCode()));
        if (flag) {
            return 3;
        }

        if (relations.contains(RelationshipType.PERSON_POSITION.getCode()) || relations.contains(RelationshipType.PERSON_LEGAL.getCode())) {
            return 2;
        }
        if (relations.contains(RelationshipType.COMPANY_INVEST_TO_COMPANY.getCode()) || relations.contains(RelationshipType.PERSON_INVEST_TO_COMPANY.getCode())) {
            return 1;
        }
        return 0;

    }


    @RequestMapping("/neo4j/risk")
    public Object getCompanyRiskInfo(@RequestParam List<String> companyId) {
        Object riskCompanyShortPath = riskCompanyRepository.getCompanyRiskInfo(companyId);
        return riskCompanyShortPath;
    }


    @RequestMapping("/neo4j/relation")
    public Object getRaltionAndLayer() {
        Object relation = riskCompanyRepository.getRaltionAndLayer();
        return relation;
    }

    @RequestMapping("/neo4j/company")
    public Object getCompany(@RequestParam String companyName) {
        Object relation = riskCompanyRepository.getCompany(companyName);
        return relation;
    }


}
