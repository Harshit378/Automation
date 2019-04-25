package com.epam.abstractclass;

import java.util.Scanner;

public class RunnerCars {

	public static void main(String[] args) {

		Honda objHonda = new Honda();
		Suzuki objSuzuki = new Suzuki();
		Tata objTata = new Tata();

		System.out.println("Enter the choice of brand");
		System.out.println("1 Honda");
		System.out.println("2 Suzuki");
		System.out.println("3 Tata");

		Scanner scan = new Scanner(System.in);

		int choice = scan.nextInt();
		System.out.println("The technical specifications of the selected car is :");
		switch (choice) {
		case 1:
			objHonda.model();
			objHonda.color();
			objHonda.engine();
			objHonda.fuelType();
			objHonda.seatingCapacity();
			break;

		case 2:
			objSuzuki.model();
			objSuzuki.color();
			objSuzuki.engine();
			objSuzuki.fuelType();
			objSuzuki.seatingCapacity();
			break;

		case 3:
			objTata.model();
			objTata.color();
			objTata.engine();
			objTata.fuelType();
			objTata.seatingCapacity();
			break;

		default:
			System.out.println("Invalid selection");
		}
		scan.close();

	}

}
