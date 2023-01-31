package ie.atu.sw;

import java.util.Scanner;

public class InsuranceProgram {
	
	// Refactored Insurance Program

	private int basicInsurance = 500;
	private int ageSurcharge = 100; // under 25 years
	
	public int generateBasicPrice() {
		return basicInsurance;
	}
	
	public int ageSurcharge(int age) {
		if (age < 17) {
			throw new IllegalArgumentException("The legal age for driving in Ireland is 17 years old");
		} else if (age < 25) {
			return ageSurcharge; // if age is under 25 (and at least 17), add surcharge.
		} else {
			return 0; // no surcharge
		}
	}
	
	public int accidentSurcharge(int accidents) {
		if (accidents == 0) return 0;
		else if (accidents == 1) return 50;
		else if (accidents == 2) return 125; 
		else if (accidents == 3) return 225;
		else if (accidents == 4) return 375;
		else if (accidents == 5)  return 575;
		else return (Integer) null;
	}
	
	public String calculateInsurance(int age, int accidents) {
		if (accidents > 6) {
			return "\nNo insurance";
		} else {
			return "\nAge surcharge: " + ageSurcharge(age)
			   + "\nAccident surcharge: " + accidentSurcharge(accidents)
			   + "\nTotal amount to pay: " + (generateBasicPrice() + ageSurcharge(age) + accidentSurcharge(accidents));
		}
	}
	
	public static void main(String[] args) {
		InsuranceProgram insuranceProgram = new InsuranceProgram();
		Scanner input = new Scanner(System.in);

		System.out.print("Enter your age: ");
		int age = input.nextInt();

		System.out.print("\nHow many accidents did you have? ");
		int accidents = input.nextInt();
		
		System.out.println(insuranceProgram.calculateInsurance(age, accidents));
	}
	
}

