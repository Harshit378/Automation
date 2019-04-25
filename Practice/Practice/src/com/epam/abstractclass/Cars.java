package com.epam.abstractclass;

public abstract class Cars {

	public abstract void model();

	public abstract void color();

	public abstract void engine();

	public void fuelType() {
		System.out.println("Fuel-Diesel");
	}

	public void seatingCapacity() {
		System.out.println("Seating-5 seater");
	}

}
