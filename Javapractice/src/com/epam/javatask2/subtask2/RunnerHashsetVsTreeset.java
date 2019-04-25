 package com.epam.javatask2.subtask2;

public class RunnerHashsetVsTreeset {

	public static void main(String[] args) {

		// creating objects of the class to access their methods
		Hashset objHashSet = new Hashset();
		Treeset objTreeSet = new Treeset();

		// comparing adding execution speed of hashset and treeset
		System.out.println("Comparing add execution speed");
		objHashSet.addElementsHashSet();
		objTreeSet.addElementsTreeSet();

		// comparing searching execution speed of hashset and treeset
		System.out.println("\nComparing search execution speed");
		objHashSet.searchElementsHashSet();
		objTreeSet.searchElementsTreeSet();

		// comparing removing execution speed of hashset and treeset
		System.out.println("\nComparing remove execution speed");
		objHashSet.removeElementsHashSet();
		objTreeSet.removeElementsTreeSet();

	}

}
