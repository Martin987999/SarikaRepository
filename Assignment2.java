package com.project2;

import java.text.SimpleDateFormat;
import java.util.List;
import java.nio.charset.CodingErrorAction;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.text.ParseException;

public class Assignment2 {
	public static int pairSum(int[] array) {
		int first = array[0];
		int second = first;
		for (int a : array) {
			if (a <= first) {
				first = a;
			}
		}
		boolean incounterFirst = false;
		for (int a : array) {
			if (a <= second || incounterFirst == true) {
				second = a;
				incounterFirst = false;
			}
			if (a == first) {
				incounterFirst = true;
			}
		}
		System.out.println(first + second);
		return first + second;

	}

	public static int[] bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] >= array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		for (int a : array) {
			System.out.print(a + " ");
		}
		return array;
	}

	public static int platformNumber(String[] arrival, String[] departure) throws Exception {
		List<Integer> tempArrival = new ArrayList<Integer>();
		List<Integer> tempDeparture = new ArrayList<Integer>();
		for (int i = 0; i < arrival.length; i++) {
			String[] tempArraivalString = arrival[i].split(":");
			String[] tempDepartureString = departure[i].split(":");
			tempArrival.add((Integer.parseInt(tempArraivalString[0]) * 60) + (Integer.parseInt(tempArraivalString[1])));
			tempDeparture.add((Integer.parseInt(tempDepartureString[0]) * 60) + (Integer.parseInt(tempDepartureString[1])));
		}
		int arraivalForword = 1;
		int departureForword = 0;
		int count = 1;
		int totalTrainPlatform = count;
		tempArrival.forEach(s -> System.out.println(s));
		tempDeparture.forEach(s -> System.out.println(s));
		while(arraivalForword < arrival.length && departureForword < departure.length) {
			if(totalTrainPlatform <= count) {
				totalTrainPlatform = count;
			}
			if(tempArrival.get(arraivalForword) <= tempDeparture.get(departureForword)) {
				System.out.println("a");
				arraivalForword++;
				count++;
			}else {
				System.out.println("d");
				departureForword++;
				count--;
			}
		}
		System.out.println(totalTrainPlatform);
		return totalTrainPlatform;
	}

	public static void main(String[] args) throws Exception {
		int[] array = { 13, 546, 21, 78, 56, 12, 2, 56, 89, 4, 53, 8479, 546 };
		Assignment2.pairSum(array);
		Assignment2.bubbleSort(array);
		String[] arrival = { "1:00", "1:40", "1:50", "2:00", "2:15", "4:00" };
		String[] departure = { "1:10", "3:00", "2:20", "2:30", "3:15", "6:00" };
		Assignment2.platformNumber(arrival, departure);
	}
}
