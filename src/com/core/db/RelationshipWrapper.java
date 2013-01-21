package com.core.db;

import org.apache.commons.lang3.RandomStringUtils;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Relationship;

public class RelationshipWrapper {
	String id;
	Relationship rel;
	
	public RelationshipWrapper(GraphDatabaseService graphdb, NodeWrapper to, NodeWrapper from, RelationTypes.types type){
		id = RandomStringUtils.randomAlphanumeric(64);
		rel = from.n.createRelationshipTo(to.n, type);
		rel.setProperty("RELATION_ID", id);
	}
	
	public void set(String key, Object value){
		rel.setProperty(key, value);
	}
	
}
