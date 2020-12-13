package com.project2;

import java.util.HashMap;
import java.util.Map;

public class CountVowel {
	public static void main(String[] args) {
		String name = "Tharshanth";
		char[] tempName = name.toCharArray();
		int count = 0;
		for (Character c : tempName) {
			if ((String.valueOf(c).compareTo("a") == 0) || (String.valueOf(c).compareTo("e") == 0)
					|| (String.valueOf(c).compareTo("i") == 0) || (String.valueOf(c).compareTo("o") == 0) || (String.valueOf(c).compareTo("u") == 0)) {
				count++;
			}
		}
		System.out.println("Total vowel in name: " + count);

		Map<String, Integer> tempMap = new HashMap<String, Integer>();
		for (Character c : tempName) {
			if ((c.compareTo('a') == 0) || (c.compareTo('e') == 0) || (c.compareTo('i') == 0) || (c.compareTo('o') == 0)
					|| (c.compareTo('u') == 0)) {
				if (!tempMap.containsKey(String.valueOf(c))) {
					tempMap.put(String.valueOf(c), 1);
				} else {
					Integer i = tempMap.get(String.valueOf(c));
					i++;
					tempMap.put(String.valueOf(c), i);
				}
			}
		}
		for(Map.Entry<String, Integer> entry : tempMap.entrySet()) {
			Integer i = entry.getValue();
			if(i >=2) {
				System.out.println(entry.getKey() + "  " + i);
			}
		}
		
		
	}
}
