package com.core.db;
/*
 * Josh Wretlind
 * Handles the database as a singleton
 */
public class DBSingleton{

	static DBSingleton dbs = null;
	DBWrapper dbo = null;
	
	private DBSingleton(){
		dbo = new DBWrapper();
	}
	
	public static DBWrapper getInstance(){
		if(dbs == null){
			dbs = new DBSingleton();
			return dbs.dbo;
		} else {
			return dbs.dbo;
		}
	}
}
