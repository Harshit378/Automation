package com.epam.javatask1;

import java.util.Scanner;

public class RunnerCalculator {

	private static int num1;
	private static int num2;
	private static int result = 0;

	public static void main(String[] args) {

		Calculator objCal = new Calculator();
		boolean repeatProcess = true;
		Scanner scan = new Scanner(System.in);
		while (repeatProcess) {
			System.out.println("Please enter the choice from menu");
			System.out.println("1-Addition");
			System.out.println("2-Subtraction");
			System.out.println("3-Multiplication");
			System.out.println("4-Division");
			System.out.println("5-Exit");

			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter the two numbers");
				num1 = scan.nextInt();
				num2 = scan.nextInt();
				result = objCal.addition(num1, num2);
				System.out.println("The sum of two numbers is " + result);
				break;

			case 2:
				System.out.println("Enter the two numbers");
				num1 = scan.nextInt();
				num2 = scan.nextInt();
				result = objCal.subtraction(num1, num2);
				System.out.println("The difference of two numbers is " + result);
				break;

			case 3:
				System.out.println("Enter the two numbers");
				num1 = scan.nextInt();
				num2 = scan.nextInt();
				result = objCal.multiplication(num1, num2);
				System.out.println("The multiplication of two numbers is " + result);
				break;

			case 4:
				System.out.println("Enter the two numbers");
				num1 = scan.nextInt();
				num2 = scan.nextInt();
				result = objCal.division(num1, num2);
				System.out.println("The division of two numbers is " + result);
				break;

			case 5:
				repeatProcess = false;
				System.out.println("User has exit the menu");
				break;

			default:
				System.out.println("Invalid operation");
				break;
			}
		}
		scan.close();

	}

}
