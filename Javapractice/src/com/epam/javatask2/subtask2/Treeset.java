package com.epam.javatask2.subtask2;

import java.util.TreeSet;

public class Treeset {

	TreeSet<Integer> tset = new TreeSet<Integer>();

	public void addElementsTreeSet() {

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 11000; i++) {
			tset.add(i);
		}
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("Adding elements execution time for TreeSet in milliseconds is :" + executionTime);

	}

	public void searchElementsTreeSet() {

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 11000; i++) {
			tset.contains(i);
		}
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("Searching elements execution time for TreeSet in milliseconds is :" + executionTime);
	}

	public void removeElementsTreeSet() {

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 11000; i++) {
			tset.remove(i);
		}
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("Removing elements execution time for TreeSet in milliseconds is :" + executionTime);
	}

}
