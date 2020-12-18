package com.main;

import java.util.Scanner;

public class Main {
	private static int search(int[] arr, int target) {
		if(arr.length == 0) return -1;
		int mid = 0;
		int low = 0;
		int high = arr.length - 1;
		while(low <= high) {
			mid = low + high >> 1;
			if(arr[mid] == target) return mid;
			if(target > arr[mid] && target > arr[low] || target < arr[mid] && target < arr[low]) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		return -1;
	}
	private static void search(int[] arr) {
		System.out.println("array: ");
		for(int i = 0; i < arr.length; i ++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		Scanner sc = new Scanner(System.in);
		int target = 0;
		int index = 0;
		while(true) {
			System.out.println("input the integer you want to search for in this array.");
			target = Integer.valueOf(sc.nextLine());
			index = search(arr, target);
			if(index == -1) System.out.println("target doesn't exist in the array.");
			else System.out.println("target index = " + index);
			System.out.println("try another search on this array? (y/n)");
			if(sc.nextLine().equals("n")) break;
		}
	}
	public static void main(String[] args) {
		System.out.println("--- START ---");
		int[] input1 = {};
		int[] input2 = {0};
		int[] input3 = {0,1};
		int[] input4 = {6,7,8,2,3,6};
		int[] input5 = {1,2,3,4,5,6,7,8};
		search(input1);
		search(input2);
		search(input3);
		search(input4);
		search(input5);
		System.out.println("--- FINISH ---");
	}
}
