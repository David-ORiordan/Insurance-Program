package ie.atu.sw;

import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InsuranceProgramParameterizedTest {
	
	// Parameterized Tests used to assess methods and their expected outcomes
	
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
	
	@ParameterizedTest
	// Tests a range of accident amounts and their expected accident-based surcharges
	@CsvSource({"1, 50", "2, 125", "3, 225", "4, 375", "5, 575"})
	public void AccidentSurchargeParameterizedTest(int accidentNumber, int accidentSur) {
		assertEquals(accidentSur, insuranceProgram.accidentSurcharge(accidentNumber));
	}
	
	@ParameterizedTest
	// Tests a number of ages and their expected age-based surcharges
	@CsvSource({"20, 100", "25, 0", "30, 0"})
	public void AgeSurchargeParameterizedTest(int age, int ageSurcharge) {
		assertEquals(ageSurcharge, insuranceProgram.ageSurcharge(age));
	}
	
}