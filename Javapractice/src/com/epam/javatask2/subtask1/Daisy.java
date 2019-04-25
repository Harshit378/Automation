package com.epam.javatask2.subtask1;

public class Daisy extends Flowers {

	private int number;
	private final int costOfDaisy = 20;

	@Override
	public int costOfFlower() {

		return costOfDaisy * getNumberOfFlowers();

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
