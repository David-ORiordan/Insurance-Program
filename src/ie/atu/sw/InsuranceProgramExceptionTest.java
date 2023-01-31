package ie.atu.sw;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class InsuranceProgramExceptionTest {
	
	// Test for NullPointerException and IllegalArgumentException
	
	public static InsuranceProgram insuranceProgram;
	@BeforeAll 
	public static void SetUp() { 
		insuranceProgram = new InsuranceProgram();
	}
	
	@Test
	// If age is less than 17, then an IllegalArgumentException is expected to be thrown
	public void IllegalArgumentExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			int age = 15;
			insuranceProgram.ageSurcharge(age);
			}, "The legal age for driving in Ireland is 17 years old");
		}
	
	@Test
	// If accidentAmount is greater than 5, then a return of null is expected, thereby throwing a NullPointerException
	public void NullPointerExceptionTest() {
		assertThrows(NullPointerException.class, () -> {
			int accidentAmount = 6;
			insuranceProgram.accidentSurcharge(accidentAmount);
			}, "If more than five accidents, then cannot give insurance");
		}	
}

	


