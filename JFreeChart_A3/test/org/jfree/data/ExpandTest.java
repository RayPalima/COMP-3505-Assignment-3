package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpandTest {

	private Range exampleRange;
	
  	@BeforeEach
  	void setUp() throws Exception {
	    exampleRange = new Range(2,6);
  	}
	
//	The following are Equivalence Class Partitioning (ECP).
	
	@Test
	void testValidRange()  throws Exception {
	    Range expandedRange = Range.expand(exampleRange, 0.25, 0.5);
	    Range expectedRange = new Range(1,8);
	    
	    // Not sure if the following is proper since it is relying on a method that is being tested (It has bugs so this test automatically not going to work properly).
//	    assertEquals(1.0, expandedRange.getLowerBound());
//	    assertEquals(8.0, expandedRange.getUpperBound());
	    
	    //So I did this one next so its not using "broken" methods, but its also not working properly? because it should be false given what it returns (based on the print statements afterwards).
	    assertEquals(expectedRange, expandedRange);
//	    System.out.println(expectedRange);
//	    System.out.println(expandedRange);
	    }
	
	@Test
	void testValidRangeCaseTwo()  throws Exception {
	    Range expandedRange = Range.expand(exampleRange, 0.5, 0.8);
	    Range expectedRange = new Range(0,9.2);
	    
	    // Not sure if the following is proper since it is relying on a method that is being tested (It has bugs so this test automatically not going to work properly).
//	    assertEquals(0, expandedRange.getLowerBound());
//	    assertEquals(8.0, expandedRange.getUpperBound());
	    
	    //So I did this one next so its not using "broken" methods, but its also not working properly? because it should be false given what it returns (based on the print statements afterwards).
	    assertEquals(expectedRange, expandedRange);
//	    System.out.println(expectedRange);
//	    System.out.println(expandedRange);
	    }
	@Test
	void testValidRangeCaseThree()  throws Exception {
		Range anotherExampleRange = new Range (2,8);
	    Range expandedRange = Range.expand(anotherExampleRange, 0.9, 0.8);
	    Range expectedRange = new Range(-4.4,12.8);
	    
	    // Not sure if the following is proper since it is relying on a method that is being tested (It has bugs so this test automatically not going to work properly).
//	    assertEquals(1.0, expandedRange.getLowerBound());
//	    assertEquals(8.0, expandedRange.getUpperBound());
	    
	    //So I did this one next so its not using "broken" methods, but its also not working properly? because it should be false given what it returns (based on the print statements afterwards).
	    assertEquals(expectedRange, expandedRange);
//	    System.out.println(expectedRange);
//	    System.out.println(expandedRange);
	}
	
	@Test
	void testNullRange() throws Exception {
		Range nullRange = null;
		
		assertThrows(InvalidParameterException.class, () -> {
            Range.expand(nullRange, 0.25, 0.5);
        });
	}

	@Test
	void testInvalidRange() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        Range.expand(new Range(6, 2), 0.25, 0.5);
	    });
	}
	
	@Test
	void testMarginEqualsZero()  throws Exception {
	    Range expandedRange = Range.expand(exampleRange, 0, 0);
	    
	    Range expectedRange = new Range(2,6);
	    
	    // Not sure if the following is proper since it is relying on a method that is being tested (It has bugs so this test automatically not going to work properly).
//	    assertEquals(2, expandedRange.getLowerBound());
//	    assertEquals(6, expandedRange.getUpperBound());
	  
//	    System.out.println(expandedRange.getLowerBound());
//	    System.out.println(expandedRange.getUpperBound());
	    
	    //So I did this one next so its not using "broken" methods, but its also not working properly? because it should be false given what it returns (based on the print statements afterwards).
	    assertEquals(expectedRange, expandedRange);
	    
//	    System.out.println(expectedRange);
//	    System.out.println(expandedRange);
	    }
	
	@Test
	void testMarginEqualsOne()  throws Exception {
	    Range expandedRange = Range.expand(exampleRange, 1, 1);
	    
	    Range expectedRange = new Range(-2,10);
	    
	    // Not sure if the following is proper since it is relying on a method that is being tested (It has bugs so this test is automatically not going to work properly).
//	    assertEquals(-2, expandedRange.getLowerBound());
//	    assertEquals(10, expandedRange.getUpperBound());
	  
//	    System.out.println(expandedRange.getLowerBound());
//	    System.out.println(expandedRange.getUpperBound());
	    
	    //So I did this one next so its not using "broken" methods, but its also not working properly? because it should be false given what it returns (based on the print statements afterwards).
	    assertEquals(expectedRange, expandedRange);
	    
//	    System.out.println(expectedRange);
//	    System.out.println(expandedRange);
	    }
	
	@Test
	void testMarginSmallerThanOne()  throws Exception {
	    
	    assertThrows(IllegalArgumentException.class, () -> {
	    	Range.expand(exampleRange, -1, -1);
	    });
	    }
	
	@Test
	void testMarginGreaterThanOne()  throws Exception {
	    Range expandedRange = Range.expand(exampleRange, 2, 2);
	    
	    Range expectedRange = new Range(-6,14);
	    
	    // Not sure if the following is proper since it is relying on a method that is being tested (It has bugs so this test is automatically not going to work properly).
//	    assertEquals(-6, expandedRange.getLowerBound());
//	    assertEquals(14, expandedRange.getUpperBound());
	  
//	    System.out.println(expandedRange.getLowerBound());
//	    System.out.println(expandedRange.getUpperBound());
	    
	    //So I did this one next so its not using "broken" methods, but its also not working properly? because it should be false given what it returns (based on the print statements afterwards).
	    assertEquals(expectedRange, expandedRange);
	    
//	    System.out.println(expectedRange);
//	    System.out.println(expandedRange);
	    }
	
	//The Following are Boundary Value Analysis (BVA):
	
	//nominal (typical) has already been considered earlier.
	//max/max+ and min are also "decently covered" since percentages for the margins and the values of the range can be technically as low and as high as possible. Therefore we covered this enough with the margins 0, 2, 1, -1 etc. 
	
	//min- BVA testing:
	@Test
	void testCloseToMinBVA()  throws Exception {
	    Range expandedRange = Range.expand(exampleRange, 0.000001, 0.000001);
	    
	    Range expectedRange = new Range(-1.000002,1.000002);
	    
	    // Not sure if the following is proper since it is relying on a method that is being tested (It has bugs so this test is automatically not going to work properly).
//	    assertEquals(-6, expandedRange.getLowerBound());
//	    assertEquals(14, expandedRange.getUpperBound());
	  
//	    System.out.println(expandedRange.getLowerBound());
//	    System.out.println(expandedRange.getUpperBound());
	    
	    //So I did this one next so its not using "broken" methods, but its also not working properly? because it should be false given what it returns (based on the print statements afterwards).
	    assertEquals(expectedRange, expandedRange);
	    
//	    System.out.println(expectedRange);
//	    System.out.println(expandedRange);
	    }
	
	//min+ BVA testing:
	@Test
	void testfarToMinBVA()  throws Exception {
	    Range expandedRange = Range.expand(exampleRange, -2, -2);
	    
	    Range expectedRange = new Range(3, -3);
	    
	    // Not sure if the following is proper since it is relying on a method that is being tested (It has bugs so this test is automatically not going to work properly).
//	    assertEquals(-6, expandedRange.getLowerBound());
//	    assertEquals(14, expandedRange.getUpperBound());
	  
//	    System.out.println(expandedRange.getLowerBound());
//	    System.out.println(expandedRange.getUpperBound());
	    
	    //So I did this one next so its not using "broken" methods, but its also not working properly? because it should be false given what it returns (based on the print statements afterwards).
	    assertEquals(expectedRange, expandedRange);
	    
//	    System.out.println(expectedRange);
//	    System.out.println(expandedRange);
	    }
	
	//max- BVA testing:
	@Test
	void testCloseToMaxBVA()  throws Exception {
	    Range expandedRange = Range.expand(exampleRange, 0.9999999999, 0.999999999);
	    
	    Range expectedRange = new Range(-2.9999999998, 2.999999998);;
	    
	    // Not sure if the following is proper since it is relying on a method that is being tested (It has bugs so this test is automatically not going to work properly).
//	    assertEquals(-6, expandedRange.getLowerBound());
//	    assertEquals(14, expandedRange.getUpperBound());
	  
//	    System.out.println(expandedRange.getLowerBound());
//	    System.out.println(expandedRange.getUpperBound());
	    
	    //So I did this one next so its not using "broken" methods, but its also not working properly? because it should be false given what it returns (based on the print statements afterwards).
	    assertEquals(expectedRange, expandedRange);
	    
//	    System.out.println(expectedRange);
//	    System.out.println(expandedRange);
	    }
	// Did not include Decision Table Testing or State Transition Testing as they both do not apply to this test (There are no different decisions nor is there a "state change"). 
}
