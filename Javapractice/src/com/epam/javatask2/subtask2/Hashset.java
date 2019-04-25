package com.epam.javatask2.subtask2;

import java.util.HashSet;

public class Hashset {

	HashSet<Integer> hset = new HashSet<Integer>();

	public void addElementsHashSet() {

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 11000; i++) {
			hset.add(i);
		}
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("Adding elements execution time for HashSet in milliseconds is :" + executionTime);

	}

	public void searchElementsHashSet() {

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 11000; i++) {
			hset.contains(i);
		}
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("Searching elements execution time for HashSet in milliseconds is :" + executionTime);
	}

	public void removeElementsHashSet() {

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 11000; i++) {
			hset.remove(i);
		}
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("Removing elements execution time for HashSet in milliseconds is :" + executionTime);
	}

}
