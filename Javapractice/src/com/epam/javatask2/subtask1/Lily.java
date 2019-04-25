package com.epam.javatask2.subtask1;

public class Lily extends Flowers {

	private int number;
	private final int priceOfLily = 8;

	@Override
	public int costOfFlower() {

		return priceOfLily * getNumberOfFlowers();

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
