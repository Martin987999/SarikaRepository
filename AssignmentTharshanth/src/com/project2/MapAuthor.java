package com.project2;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MapAuthor {
	public static void main(String[] args) {
		TreeMap<Author, String> treeMap = new TreeMap<Author, String>();
		treeMap.put(new Author("T", "K"),"");
		treeMap.put(new Author("H", "H"),"");
		treeMap.put(new Author("A", "A"),"");
		treeMap.put(new Author("R", "R"),"");
		
		Iterator itr = treeMap.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry temp = (Map.Entry)itr.next();
			System.out.println(temp.getKey() + "  " + temp.getValue());
		}
		
		
		
	}
}
