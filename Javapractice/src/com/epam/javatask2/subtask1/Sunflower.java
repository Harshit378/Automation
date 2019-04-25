package com.epam.javatask2.subtask1;

public class Sunflower extends Flowers {

	private int number;
	private final int priceOfSunflower = 100;

	@Override
	public int costOfFlower() {

		return priceOfSunflower * getNumberOfFlowers();

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
