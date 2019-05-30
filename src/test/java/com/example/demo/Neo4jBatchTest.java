package com.example.demo;

import org.junit.Test;
import org.neo4j.driver.v1.*;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Path;
import org.neo4j.driver.v1.types.Relationship;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Neo4jBatchTest {
 
	Driver driver = GraphDatabase.driver("bolt://192.168.31.36:7474", AuthTokens.basic("neo4j", "1qaz2wsx"));
	private Session session = driver.session();
 
	/**
	 * 批量创建
	 * 
	 * @throws Exception
	 */
	@Test
	public void shortEstPath() throws Exception {
//		try {
			String cmdSql = "MATCH n=shortestPath((a:朋友圈{姓名:'小讯'})-[*]-"
					+ "(b:朋友圈{姓名:'小锐'})) return n";
			StatementResult result = session.run(cmdSql);
			System.out.println(result);
//			while (result.hasNext()) {
//				Record record = result.next();
//				List<Value> values = record.values();
//				Map<Long, org.neo4j.driver.v1.types.Node> nodesMap = new HashMap<>();
//				for (Value value : values) {
//					if (value.type().name().equals("PATH")) {
//						Path p = value.asPath();
//						System.out.println("小讯和小锐之间的关系最短路径长度为：" + p.length());
//						System.out.println("====================================");
//						Iterable<Node> nodes = p.nodes();
//						for (org.neo4j.driver.v1.types.Node node : nodes) {
//							nodesMap.put(node.id(), node);
//						}
//
//						/**
//						 * 打印最短路径里面的关系 == 关系包括起始节点的ID和末尾节点的ID，以及关系的type类型
//						 */
//						Iterable<Relationship> relationships = p.relationships();
//						for (Relationship relationship : relationships) {
//							Long startID = relationship.startNodeId();
//							Long endID = relationship.endNodeId();
//							String rType = relationship.type();
//							/**
//							 * asMap 相当于 节点的properties属性信息
//							 */
//							System.out.println(
//									nodesMap.get(startID).asMap() + "-" + rType + "-"
//							+ nodesMap.get(endID).asMap());
//						}
//					}
//				}
//			}
//		} catch (Exception e) {
//			System.err.println(e.getClass() + "," + e.getMessage());
//		}
	}
 
}