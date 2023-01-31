package ie.atu.sw;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

	// Test Suite housing all the tests made for the Insurance Program

@Suite
@SelectClasses({ 
	InsuranceProgramMethodTest.class,
	InsuranceProgramParameterizedTest.class,
	InsuranceProgramExceptionTest.class,
	InsuranceProgramTestCase1Test.class,
	InsuranceProgramTestCase2Test.class
})

public class InsuranceProgramTestSuite {

}
