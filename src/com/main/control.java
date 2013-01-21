package com.main;

import com.core.db.DBSingleton;

/**
 * Main entry point for this program.
 * @author Josh Wretlind
 *
 */
public class control {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t2 = new Thread(new Analysis());
		t2.run();
	}
}
