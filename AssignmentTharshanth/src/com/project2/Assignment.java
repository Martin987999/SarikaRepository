package com.project2;

import java.util.Arrays;
import java.util.LinkedList;

public class Assignment {
	public static long printSummation(int[] array) {
		long sum = 0;
		for(int tempvalue : array) {
			sum = sum + tempvalue;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] array = {1,213,4564,484,213,45,5,12,54,6};
		System.out.println("Sum value: " + Assignment.printSummation(array));
		
		LinkedList<Integer> tempInteger = new LinkedList<Integer>(Arrays.asList(1,5,3,2,5,8,4,2,5,6,8,2,5,5,8,5));
		System.out.println("Print first element: " + tempInteger.getFirst());
		System.out.println("Print Last element: " + tempInteger.getLast());
		
		tempInteger.addFirst(8989);
		tempInteger.forEach(s -> System.out.print(s + ", "));
		System.out.println();
		
		tempInteger.addLast(951753);
		tempInteger.forEach(s -> System.out.print(s + ", "));
		System.out.println();
		
	}
}
