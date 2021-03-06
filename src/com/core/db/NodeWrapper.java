package com.core.db;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.apache.commons.lang3.RandomStringUtils;

public class NodeWrapper {
	Node n;
	String id;
	public NodeWrapper(GraphDatabaseService graphdb){
		id = RandomStringUtils.randomAlphanumeric(64);
		n = graphdb.createNode();
		set("NODE_ID", id);
	}
	
	public NodeWrapper(String id){
		this.id = id;
	}
	
	public void set(String key, Object value){
		n.setProperty(key, value);
	}
}
