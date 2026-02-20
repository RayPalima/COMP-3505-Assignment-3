package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CombineTest {
	private Range combinedRange;
	
	@BeforeEach
    void setUp() {
        
    }
	//Equivalence Class Partitioning
	
	//combineRangeA_RangeB pos pos
	@Test
	void combine_PosRangeA_PosRangeB() {
		combinedRange = Range.combine(new Range(5.0, 10.0), new Range(8.0, 20.0));
		assertAll(
			    () -> assertEquals(5.0, combinedRange.getLowerBound(), 0.0),
			    () -> assertEquals(20.0, combinedRange.getUpperBound(), 0.0)
			);
	}
	//combineRangeA_RangeB pos neg
	@Test
	void combine_PosRangeA_NegRangeB() {
		combinedRange = Range.combine(new Range(5.0, 10.0), new Range(-20.0, -15.0));
		assertAll(
			    () -> assertEquals(-20.0, combinedRange.getLowerBound(), 0.0),
			    () -> assertEquals(10.0, combinedRange.getUpperBound(), 0.0)
			);
	}
	@Test
	//combineRangeA_RangeB neg pos
	void combine_NegRangeA_PosRangeB() {
		combinedRange = Range.combine(new Range(-10.0, -5.0), new Range(15.0, 20.0));
		assertAll(
		    () -> assertEquals(-10.0, combinedRange.getLowerBound(), 0.0),
		    () -> assertEquals(20.0, combinedRange.getUpperBound(), 0.0)
		);
	}
	@Test
	//combineRangeA_RangeB neg neg
	void combine_NegRangeA_NegRangeB() {
		combinedRange = Range.combine(new Range(-10.0, -5.0), new Range(-20.0, -15.0));
		assertAll(
			    () -> assertEquals(-20.0, combinedRange.getLowerBound(), 0.0),
			    () -> assertEquals(-5.0, combinedRange.getUpperBound(), 0.0)
			);
	}
	//combineRangeA_RangeB pos null
	@Test	
	void combine_PosRangeA_NullRangeB() {
		combinedRange = Range.combine(new Range(5, 10), null);
		assertAll(
			    () -> assertEquals(5.0, combinedRange.getLowerBound(), 0.0),
			    () -> assertEquals(10.0, combinedRange.getUpperBound(), 0.0)
			);
	}
	//combineRangeA_RangeB neg null
	@Test
	void combine_NegRangeA_NullRangeB() {
		combinedRange = Range.combine(new Range(-10, -5), null);
		assertAll(
			    () -> assertEquals(-10.0, combinedRange.getLowerBound(), 0.0),
			    () -> assertEquals(-5.0, combinedRange.getUpperBound(), 0.0)
			);
	}
	//combineRangeA_RangeB null pos
	@Test
	void combine_NullRangeA_PosRangeB() {
		combinedRange = Range.combine(null, new Range(23.0, 40.0));
		assertAll(
			    () -> assertEquals(23.0, combinedRange.getLowerBound(), 0.0),
			    () -> assertEquals(40.0, combinedRange.getUpperBound(), 0.0)
			);
	}
	//combineRangeA_RangeB null neg
	@Test
	void combine_NullRangeA_NegRangeB() {
	    combinedRange = Range.combine(null, new Range(-91.0, -68.0));
	    assertAll(
	        () -> assertEquals(-91.0, combinedRange.getLowerBound(), 0.0),
	        () -> assertEquals(-68.0, combinedRange.getUpperBound(), 0.0)
	    );
	}
	//combine both null
	@Test
	void combine_Null_RangeA_Null_RangeB() {
		assertNull(Range.combine(null, null));
	}
}
