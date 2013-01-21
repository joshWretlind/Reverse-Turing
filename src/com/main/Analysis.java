package com.main;

import java.util.ArrayList;
import java.util.List;

import com.core.db.DBSingleton;
import com.core.db.NodeWrapper;
import com.core.db.RelationTypes;

public class Analysis implements Runnable {

	public Analysis(){
		
	}
	
	public void run() {
		List<NodeWrapper> nodes = new ArrayList<NodeWrapper>();
		for(int i = 0; i < 10; i++){
			System.out.println(i);
			nodes.add(DBSingleton.getInstance().writeNewNode("Num", i));
		}
		int i =0;
		for(NodeWrapper n1: nodes){
			for(NodeWrapper n2: nodes){
				DBSingleton.getInstance().createNewRelationship(n1, n2, new RelationTypes(), "Node",i );
				i++;
				System.out.println(i);
			}
		}
	}
	
}
