package com.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static List<Stall> stalist = new ArrayList<>();
	private static void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("input the size of the stalls.");
		int n = 0;
		while(true) {
			try {
				n = Integer.valueOf(sc.nextLine());
				break;
			} catch(Exception e) {
				System.out.println("invalid input. try again.");
			}
		}
		String line;
		String[] values;
		int i = 0;
		while(i < n) {
			System.out.println("Enter the detail of stall " + (i + 1) + " in this format: name, detail, type, ownerName");
			line = sc.nextLine();
			values = line.split(",");
			if(values.length != 4) System.out.println("invalid stall. try again.");
			else {
				for(String value : values) {
					while(value.startsWith(" ")) value = value.substring(1);
					while(value.endsWith(" ")) value = value.substring(0, value.length() - 2);
				}
				Stall s = new Stall(values[0], values[1], values[2], values[3]);
				stalist.add(s);
				i ++;
			}
		}
	}
	private static void removeTests() {
		String prefix = "test";
		Iterator<Stall> it = stalist.iterator();
		while(it.hasNext()) {
			if(it.next().getName().startsWith(prefix)) it.remove();
		}
	}
	private static void output() {
		System.out.println("\n" + String.format("%-15s %-20s %-15s %s", "Name", "Detail", "Type", "Owner name"));
		for(Stall s : stalist) {
			System.out.println(String.format("%-15s %-20s %-15s %s", s.getName(), s.getDetail(), s.getType(), s.getOwnerName()));
		}
	}
	public static void main(String[] args) {
		input();
		removeTests();
		output();
	}
}
