package com.core.db;

import org.neo4j.graphdb.RelationshipType;

public class RelationTypes {
	public static enum types implements RelationshipType{
		KNOWS,IS,CAN_BE,BEFORE,AFTER;
	}
	
	public types type;
	
	public RelationTypes(){
		type = types.KNOWS;
	}
}
