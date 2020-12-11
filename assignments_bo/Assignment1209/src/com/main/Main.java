package com.main;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

import javafx.util.Pair;

public class Main {
	private static int[] arr;
	private static int[] arrival;
	private static int[] departure;
	private static int n_trains;
	private static void sumClosestToZero() {
		Pair<Integer, Integer> res = new Pair<>(0, Integer.MAX_VALUE);
		Arrays.sort(arr);
		int i = 0;
		int j = arr.length - 1;
		while(i < j) {
			if(Math.abs(arr[i] + arr[j]) < Math.abs(res.getValue() + res.getKey())) {
				res = new Pair(arr[i], arr[j]);
			}
			if(arr[i] + arr[j] == 0) {
				res = new Pair(arr[i], arr[j]);
				break;
			}
			else if(arr[i] + arr[j] > 0) j --;
			else i ++;
		}
		System.out.println("the sum closest to 0: " + res.getKey() + " + " + res.getValue() + " = " + (res.getKey() + res.getValue()));
	}
	
	private static void minPlatformsOptimal() {
		int res = 0;
		Arrays.sort(arrival);
		Arrays.sort(departure);
		int i = 0;
		int j = 0;
		int cur = 0;
		while(i < arrival.length && j < arrival.length) {
			if(arrival[i] < departure[j]) {
				cur ++;
				i ++;
				res = Math.max(res, cur);
			}
			else {
				j ++;
				cur --;
			}
		}
		System.out.println("minimum " + res + " platforms required.");
	}
	
	private static void minPlatforms() {
		int res = 0;
		int temp = 0;
		for(int i = 0; i + 1 < arrival.length; i ++) {
			for(int j = i + 1; j < arrival.length; j ++) {
				if(arrival[i] > arrival[j]) {
					temp = arrival[i];
					arrival[i] = arrival[j];
					arrival[j] = temp;
					
					temp = departure[i];
					departure[i] = departure[j];
					departure[j] = temp;
				}
			}
		}
		int train = 1;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(departure[0]);
		for(int i = 1; i < arrival.length; i ++) {
			while(!pq.isEmpty() && arrival[i] >= pq.peek()) {
				pq.poll();
				train --;
			}
			if(pq.isEmpty()) {
				train = 1;
				pq.offer(departure[i]);
				res = Math.max(res, train);
				continue;
			}
			else {
				train ++;
				pq.offer(departure[i]);
				res = Math.max(res, train);
			}
		}
		print(arrival);
		print(departure);
		System.out.println("minimum " + res + " platforms required.");
	}
	
	private static void bubbleSort() {
		int temp = 0;
		for(int i = 0; i + 1 < arr.length; i ++) {
			for(int j = i + 1; j < arr.length; j ++) {
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("sorted array: ");
		print(arr);
	}
	
	private static void print(int[] a) {
		for(int i = 0; i < a.length; i ++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	private static void input() {
		arr = Utils.askForIntArray(-1, "the array");
		n_trains = Utils.askForInt("input the number of trains");
		arrival = Utils.askForIntArray(n_trains, "arrivals");
		Utils.setArrivals(arrival);
		departure = Utils.askForIntArray(n_trains, "departures");
	}
	public static void main(String[] args) {
		input();
		sumClosestToZero();
		bubbleSort();
		//minPlatforms();
		minPlatformsOptimal();
	}
}


class Utils{
	private static int[] arrivals;
	private static Scanner sc = new Scanner(System.in);
	private static final String errMsg = "invalid input. try again.";
	public static void setArrivals(int[] a) {
		arrivals = a;
	}
	public static int askForInt(String msg) {
		System.out.println(msg);
		int res = 0;
		while(true) {
			try {
				res = Integer.valueOf(sc.nextLine());
				break;
			} catch(Exception e) {
				System.out.println(errMsg);
			}
		}
		return res;
	}
	public static int[] askForIntArray(int size, String msg) {
		int sz = 0;
		if(size == -1) sz = askForInt("input the size of the array.");
		else sz = size;
		System.out.println("input " + sz + " integers for " + msg + ". separated by Enter key.");
		int[] a = new int[sz];
		int i = 0;
		int temp;
		while(sz -- > 0) {
			temp = askForInt("");
			while(msg.equals("departures") && temp < arrivals[i]) {
				System.out.println("departure time has to be bigger than arrival time. try again.");
				temp = askForInt("");
			}
			a[i ++] = temp;
		}
		return a;
	}
}