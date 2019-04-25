package com.epam.javatask2.subtask1;

public class Bogainvillea extends Flowers {

	private int number;
	private final int priceOfBogainvillea = 50;

	@Override
	public int costOfFlower() {

		return priceOfBogainvillea * getNumberOfFlowers();

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
