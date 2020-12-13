package com.vowels;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Main {
	private static String name;
	private static Scanner sc = new Scanner(System.in);
	private static void inputStr() {
		System.out.println("input your name.");
		name = sc.nextLine();
	}
	private static void countV() {
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		int count = 0;
		for(int i = 0; i < name.length(); i ++) {
			if(set.contains(name.charAt(i))) count ++;
		}
		System.out.println("there are " + count + " vowels in your name.");
	}
	
	private static void countPrintDup() {
		Map<Character, Integer> map = new HashMap<>();
		char c;
		for(int i = 0; i < name.length(); i ++) {
			c = name.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c, 1);
			}
			else {
				map.put(c, map.get(c) + 1);
			}
		}
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() > 1) {
				System.out.println(entry.getKey() + " occured " + entry.getValue() + " times ");
			}
		}
	}
	
	public static void main(String[] args) {
		inputStr();
		countV();
		countPrintDup();
	}
}
