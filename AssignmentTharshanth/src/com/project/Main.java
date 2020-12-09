package com.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of stall details:");
		Integer count = scan.nextInt();
		Integer i = 0;
		scan = new Scanner(System.in);
		List<Stall> list = new ArrayList<Stall>();
		while(!i.equals(count)) {
			i++;
			System.out.println("Enter the stall " + i + " detail:");
			String temp = scan.nextLine();
			scan = new Scanner(System.in);
			String[] spiltSting = temp.split(",");
			Stall stall = new Stall(String.format("%-15s", spiltSting[0]), String.format("%-20s", spiltSting[1]), String.format("%-15s", spiltSting[2]), String.format("%s", spiltSting[3]));
			list.add(stall);
		}
		
		System.out.println(" NAME              DETAIL                 TYPE              OWNER NAME");
		list.forEach(s -> System.out.println(s));
		Collections.synchronizedList(list);
		Iterator<Stall> itr = list.iterator();
		System.out.println("\n");
		System.out.println(" NAME              DETAIL                 TYPE              OWNER NAME");
		while(itr.hasNext()) {
			Stall tempStall = itr.next();
			if(tempStall.getName().startsWith("test")){
				itr.remove();
			}
		}
		list.forEach(s -> System.out.println(s));
	}
}
