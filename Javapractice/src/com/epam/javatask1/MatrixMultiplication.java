package com.epam.javatask1;

import java.util.Scanner;

public class MatrixMultiplication {

	public static void main(String[] args) {

		int row1 = 0, col1 = 0, row2 = 0, col2 = 0;
		int i, j, k, sumOfElements = 0;

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the size of matrix 1");
		System.out.println("Enter the size of row");
		row1 = scan.nextInt();
		System.out.println("Enter the size of column");
		col1 = scan.nextInt();
		int[][] matrixOne = new int[row1][col1];

		System.out.println("enter the elements of matrix 1");
		for (i = 0; i < row1; i++) {
			for (j = 0; j < col1; j++) {
				matrixOne[i][j] = scan.nextInt();
			}
		}

		System.out.println("Enter the size of matrix 2");
		System.out.println("Enter the size of row");
		row2 = scan.nextInt();
		System.out.println("Enter the size of column");
		col2 = scan.nextInt();
		int[][] matrixTwo = new int[row2][col2];

		System.out.println("enter the elements of matrix 2");
		for (i = 0; i < row2; i++) {
			for (j = 0; j < col2; j++) {
				matrixTwo[i][j] = scan.nextInt();
			}
		}

		if (col1 != row2) {
			System.out.println("Multiplication of this order cannot be done");
		}

		else {
			int[][] resultant = new int[row1][col2];

			System.out.println("Resultant matrix after multiplication is:");
			for (i = 0; i < row1; i++) {
				for (j = 0; j < col2; j++) {
					for (k = 0; k < row2; k++) {
						sumOfElements += matrixOne[i][k] * matrixTwo[k][j];
					}
					resultant[i][j] = sumOfElements;
					sumOfElements = 0;

				}
			}

			for (i = 0; i < row1; i++) {
				for (j = 0; j < col2; j++) {
					System.out.print(resultant[i][j] + " ");
				}
				System.out.println("\n");
			}

		}
		scan.close();

	}

}
