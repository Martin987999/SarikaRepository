package com.main;

import java.util.LinkedList;
import java.util.Scanner;


public class Main {

	private static Scanner sc = new Scanner(System.in);
	private static LinkedList<Integer> list = new LinkedList<>();
	private static final String errMsg = "invalid input. try again.";

	private static int askForInt(String msg) {
		int x = 0;
		while(true) {
			System.out.println(msg);
			try {
				x = Integer.valueOf(sc.nextLine());
				break;
			} catch(Exception e) {
				System.out.println(errMsg);
			}
		}
		return x;
	}
	
	private static int askForInt(String msg, int min, int max) {
		int x = 0;
		while(true) {
			System.out.println(msg);
			try {
				x = Integer.valueOf(sc.nextLine());
				if(x >= min && x <= max) break;
			} catch(Exception e) {
				System.out.println(errMsg);
			}
		}
		return x;
	}
	
	private static void print() {
		for(int x : list) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	
	private static void inputList() {
		int sz = askForInt("input the size of the list");
		list.clear();
		int input = 0;
		System.out.println("input " + sz + " integers, seperated by Enter key");
		while(sz -- > 0) {
			input = askForInt("input an integer.");
			list.add(input);
		}
	}
	private static void printSum() {
		int sum = 0;
		for(int x : list) sum += x;
		System.out.println("sum = " + sum);
	}
	
	private static void printFirstLast() {
		if(list.size() == 0) {
			System.out.println("list is empty.");
			return;
		}
		System.out.println("first element is " + list.get(0));
		System.out.println("last element is " + list.get(list.size() - 1));
	}
	
	private static void addToFirst(int x) {
		list.add(0, x);
		System.out.println("after insertion: ");
		print();
	}
	
	private static void addToLast(int x) {
		list.add(x);
		System.out.println("after insertion: ");
		print();
	}
	
	public static void main(String[] args) {
		System.out.println("--- PROGRAM START ---");
		inputList();
		int choice = 0;
		while(true) {
			String msg = "input id (1-4) of the operation. input 0 to exit.\n"
					+ "1. print sum of integers\n"
					+ "2. print first and last elements of a linked list\n"
					+ "3. add an integer to the first position of a linked list\n"
					+ "4. add an integer to the last position of a linked list.";
			choice = askForInt(msg, 0, 4);
			if(choice == 0) break;
			if(choice == 1) {
				printSum();
			}
			else if(choice == 2) {
				printFirstLast();
			}
			else if(choice == 3) {
				int x = askForInt("input the integer you want to add to the first position.");
				addToFirst(x);
			}
			else {
				int x = askForInt("Input the integer you want to add to the last position.");
				addToLast(x);
			}
		}
		System.out.println("--- PROGRAM FINISH ---");
	}

}
