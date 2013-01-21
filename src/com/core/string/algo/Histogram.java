package com.core.string.algo;

/**
 * Creates a frequency map for a given collection of strings
 */
import java.util.HashMap;
import java.util.Map;

public class Histogram {
	
	public static Map<String, Integer> create(String... sc){
		Map<String, Integer> map = new HashMap<String,Integer>();
		int i = 1;
		for(String s: sc){
			if(!map.containsKey(s.toLowerCase())){
				map.put(s.toLowerCase(),i);
			}
			else{
				map.put(s.toLowerCase(), map.get(s.toLowerCase())+1);
			}
		}	
		return map;
	}	
}
