package com.epam.javatask2.subtask1;

public class Rose extends Flowers {

	private int number;
	private final int priceOfRose = 10;

	@Override
	public int costOfFlower() {

		return priceOfRose * getNumberOfFlowers();

	}

	@Override
	public int getNumberOfFlowers() {
		return number = setNumberOfFlowers(number);

	}

	@Override
	public int setNumberOfFlowers(int number) {
		return this.number = number;
	}

}
