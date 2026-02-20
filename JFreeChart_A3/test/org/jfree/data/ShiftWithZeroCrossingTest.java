package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShiftWithZeroCrossingTest {
	
private Range exampleRange;
	
  	@BeforeEach
  	void setUp() throws Exception {
	    exampleRange = new Range(2,6);
  	}
	
//	The following are Equivalence Class Partitioning (ECP).
// 	The test cases are also similar to the one in the "ShiftTest" as they are both the same method but this one is just more "expanded". So some of the tests will still apply.
  	
	@Test
	void testValidRangeWithFalseZeroCrossing()  throws Exception {
	    Range shiftedRange = Range.shift(exampleRange, 1, false);
	    Range expectedRange = new Range(1,7);
	    assertEquals(expectedRange, shiftedRange);
    };

	@Test
	void testValidRangeWithTrueZeroCrossing()  throws Exception {
	    Range shiftedRange = Range.shift(exampleRange, 1, true);
	    Range expectedRange = new Range(1,7);
	    assertEquals(expectedRange, shiftedRange);
    };
    
	@Test
	void testNullRangeWithFalseZeroCrossing()  throws Exception {
		Range nullRange = null;
	    assertThrows(InvalidParameterException.class, () -> {
		Range.shift(nullRange, 1, false);
	    });
    };

	@Test
	void testNullRangeWithTrueZeroCrossing()  throws Exception {
		Range nullRange = null;
	    assertThrows(InvalidParameterException.class, () -> {
		Range.shift(nullRange, 1, true);
	    });
    };
    
	@Test
	void testDeltaHigherThanZeroWithFalseZeroCrossing()  throws Exception {
	    Range shiftedRange = Range.shift(exampleRange, 2, false);
	    Range expectedRange = new Range(0,8);
	    assertEquals(expectedRange, shiftedRange);
    };

	@Test
	void testDeltaLowerThanZeroWithFalseZeroCrossing()  throws Exception {
	    Range shiftedRange = Range.shift(exampleRange, -1, false);
	    Range expectedRange = new Range(3,5);
	    assertEquals(expectedRange, shiftedRange);
    };
    
	@Test
	void testDeltaEqualZeroWithFalseZeroCrossing()  throws Exception {
	    Range shiftedRange = Range.shift(exampleRange, 0, false);
	    Range expectedRange = new Range(2,6);
	    assertEquals(expectedRange, shiftedRange);
    };
    
	@Test
	void testShiftCrossesZeroWithFalseZeroCrossing()  throws Exception {
	    Range shiftedRange = Range.shift(exampleRange, 4);
	    Range expectedRange = new Range(0,10);
	    assertEquals(expectedRange, shiftedRange);
    };
    

	@Test
	void testDeltaHigherThanZeroWithTrueZeroCrossing()  throws Exception {
	    Range shiftedRange = Range.shift(exampleRange, 2, true);
	    Range expectedRange = new Range(0,8);
	    assertEquals(expectedRange, shiftedRange);
    };

	@Test
	void testDeltaLowerThanZeroWithTrueZeroCrossing()  throws Exception {
	    Range shiftedRange = Range.shift(exampleRange, -1, true);
	    Range expectedRange = new Range(3,5);
	    assertEquals(expectedRange, shiftedRange);
    };
    
	@Test
	void testDeltaEqualZeroWithTrueZeroCrossing()  throws Exception {
	    Range shiftedRange = Range.shift(exampleRange, 0, true);
	    Range expectedRange = new Range(2,6);
	    assertEquals(expectedRange, shiftedRange);
    };
    
	@Test
	void testShiftCrossesZeroWithTrueZeroCrossing()  throws Exception {
	    Range shiftedRange = Range.shift(exampleRange, 4, true);
	    Range expectedRange = new Range(-2,10);
	    assertEquals(expectedRange, shiftedRange);
    };

//	The following are BVA testing (Only one boundary).
// 	The right at boundary (0 delta) is already covered above.
	@Test
	
	//Following are minimum+ BVA
	void testHighDeltaWithFalseZeroCrossing()  throws Exception {
	    Range shiftedRange = Range.shift(new Range(1,5), 100, false);
	    Range expectedRange = new Range(0,105);
	    assertEquals(expectedRange, shiftedRange);
    };
    
    void testHighDeltaWithTrueZeroCrossing()  throws Exception {
	    Range shiftedRange = Range.shift(new Range(1,5), 100, true);
	    Range expectedRange = new Range(-99,105);
	    assertEquals(expectedRange, shiftedRange);
    };
    
	void testWhenRangeStartsBeyondZeroWithFalseZeroCrossing()  throws Exception {
	    Range shiftedRange = Range.shift(new Range(-1,5), 2, false);
	    Range expectedRange = new Range(0,7);
	    assertEquals(expectedRange, shiftedRange);
    };
    

	void testWhenRangeStartsBeyondZeroWithTrueZeroCrossing()  throws Exception {
	    Range shiftedRange = Range.shift(new Range(-1,5), 2, true);
	    Range expectedRange = new Range(-3,7);
	    assertEquals(expectedRange, shiftedRange);
    };
    
    //Following are minimum- BVA
	@Test
	void testVeryMinimumDeltaWithFalseZeroCrossing()  throws Exception {
	    Range shiftedRange = Range.shift(new Range(0,5), 0.0000001, false);
	    Range expectedRange = new Range(0,5.0000001);
	    assertEquals(expectedRange, shiftedRange);
    };
    
    @Test
	void testVeryMinimumDeltaWithTrueZeroCrossing()  throws Exception {
	    Range shiftedRange = Range.shift(new Range(0,5), 0.0000001, true);
	    Range expectedRange = new Range(-0.0000001,5.0000001);
	    assertEquals(expectedRange, shiftedRange);
    };
  //Did not do State Transition Testing because there is no "state that is changing".
  //Did not do Decision table testing as they were already covered enough by both the ECP and BVA testing.
    
}