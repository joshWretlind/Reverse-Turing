package com.core.db;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/**
 * 
 * @author Josh Wretlind
 * Wraps the Neo4j database
 *
 */
public class DBWrapper {
	
	GraphDatabaseService graphDb;
	
	public DBWrapper(){
		
	}
	
	public void runDB(){
		graphDb = new GraphDatabaseFactory().newEmbeddedDatabase("");
		registerShutdownHook( graphDb );
	}
	
	private static void registerShutdownHook( final GraphDatabaseService graphDb )
	{
	    // Registers a shutdown hook for the Neo4j instance so that it
	    // shuts down nicely when the VM exits (even if you "Ctrl-C" the
	    // running example before it's completed)
	    Runtime.getRuntime().addShutdownHook( new Thread()
	    {
	        @Override
	        public void run()
	        {
	            graphDb.shutdown();
	        }
	    } );
	}
	
	public void shutdownDB(){
		graphDb.shutdown();
	}
	
	public void 
}
