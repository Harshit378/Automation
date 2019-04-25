package com.epam.javatask2.subtask1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.epam.javatask3.Streams;
import com.epam.javatask3.UserException;

public class RunnerBouquet {

	public static void main(String[] args) throws IOException {

		Rose objRose = new Rose();
		Lily objLily = new Lily();
		Daisy objDaisy = new Daisy();
		Bogainvillea objBogainvillea = new Bogainvillea();
		Sunflower objSunflower = new Sunflower();

		Scanner scan = new Scanner(System.in);
		boolean repeat = true;
		Streams objstreams = new Streams();
		objstreams.readAndWriteFile();

		ArrayList<Flowers> bunchOfFlowers = new ArrayList<Flowers>();

		bunchOfFlowers.add(objRose);
		bunchOfFlowers.add(objLily);
		bunchOfFlowers.add(objDaisy);
		bunchOfFlowers.add(objBogainvillea);
		bunchOfFlowers.add(objSunflower);

		try {
			while (repeat) {
				int choice = 0;

				System.out.println("Please enter the choice of flowers and their quantity ");
				System.out.println("1-Rose");
				System.out.println("2-Lily");
				System.out.println("3-Daisy");
				System.out.println("4-Bogainvillea");
				System.out.println("5-Sunflower");
				System.out.println("0-Exit");

				choice = scan.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter the number of Rose flower needed in bouquet");
					int numberOfRoses = scan.nextInt();
					bunchOfFlowers.get(0).setNumberOfFlowers(numberOfRoses);
					break;

				case 2:
					System.out.println("Enter the number of Lily flower needed in bouquet");
					int numberOfLilies = scan.nextInt();
					bunchOfFlowers.get(1).setNumberOfFlowers(numberOfLilies);
					break;

				case 3:
					System.out.println("Enter the number of Daisy flower needed in bouquet");
					int numberOfDaisy = scan.nextInt();
					bunchOfFlowers.get(2).setNumberOfFlowers(numberOfDaisy);
					break;

				case 4:
					System.out.println("Enter the number of Bogainvillea flower needed in bouquet");
					int numberOfBogainvilleas = scan.nextInt();
					bunchOfFlowers.get(3).setNumberOfFlowers(numberOfBogainvilleas);
					break;

				case 5:
					System.out.println("Enter the number of Sunflower flower needed in bouquet");
					int numberOfSunflowers = scan.nextInt();
					bunchOfFlowers.get(4).setNumberOfFlowers(numberOfSunflowers);
					break;

				case 0:
					repeat = false;
					System.out.println("User has selected the flowers");
					break;

				default:
					throw new UserException("Invalid Input from the user,please enter numbers between 0 to 5");

				}
			}
		} catch (UserException exception) {
			System.out.println(exception.getMessage());

		} catch (InputMismatchException exception) {
			System.out.println("The type of data is not accepted,please enter an integer value");
		}

		scan.close();

		int costOfBouquet = bunchOfFlowers.get(0).costOfFlower() + bunchOfFlowers.get(1).costOfFlower()
				+ bunchOfFlowers.get(2).costOfFlower() + bunchOfFlowers.get(3).costOfFlower()
				+ bunchOfFlowers.get(4).costOfFlower();

		System.out.println("The total cost of bouquet is :" + costOfBouquet);
		objstreams.writeFile("The total cost of bouquet is :" + costOfBouquet);

	}

}
