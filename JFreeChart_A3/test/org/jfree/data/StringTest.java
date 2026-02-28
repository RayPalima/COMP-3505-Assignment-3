package org.jfree.data;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StringTest {

	@ParameterizedTest
	@CsvSource({
	  "5.0, 10.0",
	  "-3.0, 10.0",
	  "-10.0, -8.0",
	  "0.0, 0.0",
	})
	void toString_Format_ValidRanges_Test(double lower, double upper) {
	  Range exampleRange = new Range(lower, upper);
	  assertEquals("Range[" + lower + "," + upper + "]", exampleRange.toString());
	}
	
	@ParameterizedTest
	@CsvSource({
	  "5.0, -10.0",
	  "-8.0, -10.0"
	})
	void toString_Format_LowerGreaterThanUpper_Test(double lower, double upper) {
		  assertThrows(IllegalArgumentException.class, () -> new Range(lower, upper));
	}
	@Test
	void toString_NegativeZero() {
	  Range r = new Range(-0.0, 0.0);
	  assertEquals("Range[-0.0,0.0]", r.toString());
	}

}
