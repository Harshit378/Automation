package com.epam.interfaceex;

public class TestInterface {

	public static void main(String[] args) {
		Bank bob = new BankOfBaroda();
		Bank sbi = new SBI();
		Bank hdfc = new HDFC();

		System.out.println("ROI of Bank Of Baroda:" + bob.rateOfInterest());
		
		System.out.println("ROI of State Bank Of India:" + sbi.rateOfInterest());
		
		System.out.println("ROI of HDFC Bank:" + hdfc.rateOfInterest());

	}

}
