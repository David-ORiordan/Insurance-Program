package ie.atu.sw;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InsuranceProgramMethodTest {
	
	// Tests for the individual methods in the InsuranceProgram class

	public static InsuranceProgram insuranceProgram;
	public static int insuranceTotal;
	@BeforeAll 
	public static void SetUpAll() {
		insuranceProgram = new InsuranceProgram();
	}
	
	@BeforeEach
	public void SetUpEach() {
		insuranceTotal = 0;
	}
	
	@AfterEach
	public void displayInsuranceTotal() {
		System.out.println("Insurance Subtotal: " + insuranceTotal);
	}
	
	@Test
	void generateBasicPriceTest() {
		insuranceTotal += insuranceProgram.generateBasicPrice(); 
		assertEquals(500, insuranceTotal);
	}
	
	@Test 
	void surchargeEligibilityTest1() {
		insuranceTotal += insuranceProgram.ageSurcharge(23); 
		assertEquals(100, insuranceTotal); 
	}
	
	@Test 
	void surchargeEligibilityTest2() {
		insuranceTotal += insuranceProgram.ageSurcharge(32); 
		assertEquals(0, insuranceTotal); 
	}
	
	@Test 
	void accidentSurchargeTest1() {
		insuranceTotal += insuranceProgram.accidentSurcharge(1); 
		assertEquals(50, insuranceTotal);
	}
	
	@Test 
	void accidentSurchargeTest2() {
		insuranceTotal += insuranceProgram.accidentSurcharge(3); 
		assertEquals(225, insuranceTotal);
	}
	
	@Test 
	void calculateInsurance1() {
		String insuranceQuote = insuranceProgram.calculateInsurance(19, 3); 
		assertEquals("\nAge surcharge: " + 100 + "\nAccident surcharge: " + 225 + "\nTotal amount to pay: " + 825, insuranceQuote);
	}
	
	@Test 
	void calculateInsurance2() {
		String insuranceQuote = insuranceProgram.calculateInsurance(48, 5); 
		assertEquals("\nAge surcharge: " + 0 + "\nAccident surcharge: " + 575 + "\nTotal amount to pay: " + 1075, insuranceQuote);
	}
	
	@Test 
	void calculateInsurance3() {
		String insuranceQuote = insuranceProgram.calculateInsurance(62, 7); 
		assertEquals("\nNo insurance", insuranceQuote);
	}
	
}
