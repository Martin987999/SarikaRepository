package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;

import javafx.util.Pair;

public class Main {
	private static void findSumClosestToX(int x, int[] arr) {
		if(arr.length < 2) {
			System.out.println("invalid input.");
			return;
		}
		Arrays.sort(arr);
		Pair<Integer, Integer> p = new Pair<>(x + Integer.MAX_VALUE, 0);
		int left = 0;
		int right = arr.length - 1;
		while(left < right) {
			if(arr[left] + arr[right] == x) {
				p = new Pair(arr[left], arr[right]);
				break;
			}
			else {
				if(Math.abs(p.getKey() + p.getValue() - x) > Math.abs(arr[left] + arr[right] - x))
					p = new Pair(arr[left], arr[right]);
				if(arr[left] + arr[right] > x) right --;
				else left ++;
			}
		}

		System.out.println("the pair that sums closest to " + x + ": " + p.getKey() + " + " + p.getValue() + " = " + (p.getKey() + p.getValue()));
	}

	private static void findInMatrix(int[][] a, int target) {
		for(int i = 0; i < a.length; i ++) {
			int low = 0;
			int high = a[i].length - 1;
			int mid = 0;
			while(low <= high) {
				mid = low + high >> 1;
				if(a[i][mid] == target) {
					System.out.println("target index (" + i + "," + mid + ")");
					return;
				}
				else if(a[i][mid] > target) high = mid - 1;
				else low = mid + 1;
			}
		}
		System.out.println("target doesn't exist.");
	}

	private static void maxProfit(int[] arr) {
		int res = 0;
		boolean bought = false;
		int price = 0;
		for(int i = 0; i + 1 < arr.length; i ++) {
			if(bought) {
				if(arr[i + 1] < arr[i]) {
					res += arr[i] - price;
					bought = false;
				}
			}
			else {
				if(arr[i + 1] > arr[i]) {
					price = arr[i];
					bought = true;
				}
			}
		}
		if(arr[arr.length - 1] > price && bought) res += arr[arr.length - 1] - price;
		System.out.println("max profit = " + res);
	}

	private static void findAllPairsSumToX(int x, int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int a : arr) {
			int v = map.getOrDefault(a, 0);
			map.put(a, v + 1);
		}
		List<int[]> list = new ArrayList<>();
		for(int a : map.keySet()) {
			map.put(a, map.get(a) - 1);
			int count = map.getOrDefault(x - a, 0);
			if(count > 0) {
				map.put(x - a, 0);
				list.add(new int[] {a, x - a});
			}
			map.put(a, 0);
		}
		System.out.print("pairs suming to " + x + ":{");
		for(int i = 0; i < list.size(); i ++) {
			int[] a = list.get(i);
			System.out.print("{");
			System.out.print(a[0] + "," + a[1]);
			System.out.print("}");
			if(i + 1 != list.size()) System.out.print(",");
		}
		System.out.println("}");
	}

	public static void main(String[] args) {
		int[] arr = { 8, 5, 6, 1, 2, -1, 3 , 2};
		int x = -2;
		maxProfit(arr);
		findSumClosestToX(x, arr);
		x = 2;
		findAllPairsSumToX(x, arr);
		int[][] a = { { 1, 3, 6, 8 }, { 2, 4, 7, 9 }, { 4, 5, 7, 9 }, { 4, 5, 8, 18 } };
		int target = 7;
		findInMatrix(a, target);
	}
}
