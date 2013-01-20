package com.core.db;
/*
 * Josh Wretlind
 * Handles the database as a singleton
 */
public class DBSingleton {

	DBSingleton dbs = null;
	DBWrapper dbo = null;
	
	private DBSingleton(){
		dbo = new DBWrapper();
	}
	
	public DBWrapper getInstance(){
		if(dbs == null){
			dbs = new DBSingleton();
			return dbs.dbo;
		} else {
			return dbs.dbo;
		}
	}
}
