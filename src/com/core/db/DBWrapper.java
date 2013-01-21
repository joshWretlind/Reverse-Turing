package com.core.db;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.index.Index;

/**
 * 
 * @author Josh Wretlind
 * Wraps the Neo4j database
 *
 */
public class DBWrapper {
	
	GraphDatabaseService graphDb;
	Index<Node> nodeIndex = null;
	Index<Relationship> relationIndex = null;
	
	public DBWrapper(){
		runDB();
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
	
	public NodeWrapper writeNode(String key, Object value){
		Transaction tx = graphDb.beginTx();
		NodeWrapper n = new NodeWrapper(graphDb);

		try{
			n.set(key, value);
			if(nodeIndex == null){
				nodeIndex = graphDb.index().forNodes("NODE_ID");
			}
			
			nodeIndex.add(n.n, "NODE_ID", n.id);
		    tx.success();
		}
		finally{
		    tx.finish();
		}
		
		return n;
	}
	
	public RelationshipWrapper createRelationship(NodeWrapper from, NodeWrapper to, RelationTypes type, String key, Object value){
		Transaction tx = graphDb.beginTx();
		RelationshipWrapper rel = new RelationshipWrapper(graphDb,to,from,type.type);

		try{
			rel.set(key, value);
			if(relationIndex == null){
				relationIndex = graphDb.index().forRelationships("RELATION_ID");
			}
			relationIndex.add(rel.rel, "RELATION_ID", rel.id);
		    tx.success();
		}
		finally{
		    tx.finish();
		}
		return rel;
	}
	
	public void deleteNode(Node n){
		Transaction tx = graphDb.beginTx();
		try{
			n.delete();
		    tx.success();
		}
		finally{
		    tx.finish();
		}
	}
	
	public void deleteRelationship(Relationship rel){
		Transaction tx = graphDb.beginTx();
		try{
			rel.delete();
		    tx.success();
		}
		finally{
		    tx.finish();
		}
	}
	
	
}
