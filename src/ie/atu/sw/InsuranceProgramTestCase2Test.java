package ie.atu.sw;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class InsuranceProgramTestCase2Test {
	
	// Test case of an individual aged 32 seeking insurance with history of having 2 accidents (with a @Timeout value set to 100 milliseconds)

	public static InsuranceProgram insuranceProgram;
	public static int insuranceTotal;
	@BeforeAll 
	public static void SetUp() { 
		insuranceProgram = new InsuranceProgram();
		insuranceTotal = 0;
	}
	
	@AfterAll
	public static void displayInsuranceTotal() {
		System.out.println("Insurance Total: " + insuranceTotal);
		insuranceTotal = 0;
	}
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	// Test if the following test case is carried out within the given duration
	void generateOverallInsurancePriceTestCase2() {
		insuranceTotal += insuranceProgram.generateBasicPrice(); // +500
		insuranceTotal += insuranceProgram.ageSurcharge(32);	 // +0
		insuranceTotal += insuranceProgram.accidentSurcharge(2); // +125
		assertEquals(625, insuranceTotal);
	}
	
}
