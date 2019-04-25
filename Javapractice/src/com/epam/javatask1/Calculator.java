package com.epam.javatask1;

public class Calculator {

	
	public int addition(int num1, int num2) {
		return num1 + num2;
	}

	public int subtraction(int num1, int num2) {
		return num1 - num2;
	}

	public int multiplication(int num1, int num2) {
		return num1 * num2;
	}

	public int division(int num1, int num2) {
		int result = 0;
		if (num2 == 0) {
			try {

				result = num1 / num2;
			}

			catch (ArithmeticException exception) {
				System.out.println("Cannot divide by 0");
			}
		} else {
			result = num1 / num2;
		}
		return result;

	}

	

}
