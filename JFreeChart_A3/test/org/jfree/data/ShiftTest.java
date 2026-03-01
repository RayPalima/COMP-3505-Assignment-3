package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShiftTest {
	
private Range exampleRange;
	
  	@BeforeEach
  	void setUp() throws Exception {
	    exampleRange = new Range(2,6);
  	}
	
//	The following are Equivalence Class Partitioning (ECP).
  	
	@Test
	void testValidRange()  throws Exception {
	    Range shiftedRange = Range.shift(exampleRange, 1);
	    Range expectedRange = new Range(3,7);
	    assertEquals(expectedRange, shiftedRange);
    };
    @Test
    void shift_NegativeDelta() {
      Range shifted = Range.shift(exampleRange, -1);
      assertEquals(1.0, shifted.getLowerBound(), 0.0);
      assertEquals(5.0, shifted.getUpperBound(), 0.0);
    }
	@Test
	void testNullRange()  throws Exception {
		Range nullRange = null;
	    assertThrows(InvalidParameterException.class, () -> {
		Range.shift(nullRange, 1);
	    });
    };
    
	@Test
	void testDeltaHigherThanZero()  throws Exception {
	    Range shiftedRange = Range.shift(exampleRange, 2);
	    Range expectedRange = new Range(4,8);
	    assertEquals(expectedRange, shiftedRange);
    };

	@Test
	void testDeltaLowerThanZero()  throws Exception {
	    Range shiftedRange = Range.shift(exampleRange, -1);
	    Range expectedRange = new Range(1,5);
	    assertEquals(expectedRange, shiftedRange);
    };
    
	@Test
	void testDeltaEqualZero()  throws Exception {
	    Range shiftedRange = Range.shift(exampleRange, 0);
	    Range expectedRange = new Range(2,6);
	    assertEquals(expectedRange, shiftedRange);
    };
    
	@Test
	void testShiftCrossesZero()  throws Exception {
	    Range shiftedRange = Range.shift(exampleRange, 4);
	    Range expectedRange = new Range(6,10);
	    assertEquals(expectedRange, shiftedRange);
    };
    //No zero crossing allowed, test this.
    @Test
    void testShift_DisallowZeroCrossing_ClampsAtZero() {
        Range base = new Range(2, 6);
        Range shifted = Range.shift(base, -5); 
        assertEquals(0.0, shifted.getLowerBound(), 0.0);
        assertEquals(1.0, shifted.getUpperBound(), 0.0);
    }

//	The following are BVA testing (Only one boundary).
// 	The right at boundary (0 delta) is already covered above.
	
	//Following are minimum+ 
    @Test
	void testHighDelta()  throws Exception {
	    Range shiftedRange = Range.shift(new Range(1,5), 100);
	    Range expectedRange = new Range(0,105);
	    assertEquals(expectedRange, shiftedRange);
    };
    @Test
	void testWhenRangeStartsBeyondZero()  throws Exception {
	    Range shiftedRange = Range.shift(new Range(-1,5), 2);
	    Range expectedRange = new Range(0,7);
	    assertEquals(expectedRange, shiftedRange);
    };
    
    //Following are minimum- BVA
	@Test
	void testVeryMinimumDelta()  throws Exception {
	    Range shiftedRange = Range.shift(new Range(0,5), 0.0000001);
	    Range expectedRange = new Range(0,5.0000001);
	    assertEquals(expectedRange, shiftedRange);
    };
    
  //Did not do State Transition Testing because there is no "state that is changing".
  //Did not do Decision table testing as they were already covered enough by both the ECP and BVA testing.
    
}
