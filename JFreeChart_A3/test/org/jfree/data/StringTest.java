package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringTest {

	@ParameterizedTest
	@CsvSource({
	  "5.0, 10.0",
	})
	void toString_Format_Pos_Pos(double lower, double upper) {
	  Range exampleRange = new Range(lower, upper);
	  assertEquals("Range[" + lower + "," + upper + "]", exampleRange.toString());
	}
	@ParameterizedTest
	@CsvSource({
	  "-3.0, 10.0",
	})
	void toString_Format_Pos_Neg(double lower, double upper) {
	  Range exampleRange = new Range(lower, upper);
	  assertEquals("Range[" + lower + "," + upper + "]", exampleRange.toString());
	}
	@ParameterizedTest
	@CsvSource({
	  "5.0, -10.0",
	})
	void toString_Format_Neg_Pos(double lower, double upper) {
	  Range exampleRange = new Range(lower, upper);
	  assertEquals("Range[" + lower + "," + upper + "]", exampleRange.toString());
	}
	@ParameterizedTest
	@CsvSource({
	  "-8.0, -10.0",
	})
	void toString_Format_(double lower, double upper) {
	  Range exampleRange = new Range(lower, upper);
	  assertEquals("Range[" + lower + "," + upper + "]", exampleRange.toString());
	}
	
	


}
