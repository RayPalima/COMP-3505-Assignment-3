package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class calculateRowTotalTest {

    private DefaultKeyedValues2D exampleData;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        exampleData = new DefaultKeyedValues2D();
        exampleData.addValue(1, 0, 0);  
        exampleData.addValue(2, 0, 1);  
        exampleData.addValue(3, 0, 2); 
    }
// All valid values – does not throw an exception
    @Test
    void validValues() {
        assertDoesNotThrow(() -> {
            DataUtilities.calculateRowTotal(exampleData, 0);
        });
    }
// All valid values – checks correct mathematical result
    @Test
    void validValuesResult() {
    	double expected = 6;
	    
    	double result = DataUtilities.calculateRowTotal(exampleData, 0);
    	
    	 assertEquals(expected, result, 0.0001);  // 1+2+3 = 6
    }
 

// Row contains null values – does not throw an exception
    @Test
    void nullValues() {
    	DefaultKeyedValues2D nullValues = new DefaultKeyedValues2D();
        nullValues.addValue(null, 0, 0);
        nullValues.addValue(5.0, 0, 1);

        assertDoesNotThrow(() -> {
            DataUtilities.calculateRowTotal(nullValues, 0);
        });
    }

// Row contains null values – nulls are ignored in sum
    @Test
    void nullValuesResult() {
    	DefaultKeyedValues2D nullValues = new DefaultKeyedValues2D();
        nullValues.addValue(null, 0, 0);
        nullValues.addValue(5.0, 0, 1);

        double expected = 5.0;

        double result = DataUtilities.calculateRowTotal(nullValues, 0);

        assertEquals(expected, result, 0.0001);
    }

//empty table – does not throw an exception
    @Test
    void emptyTable() {
    	DefaultKeyedValues2D emptyData = new DefaultKeyedValues2D();

        assertDoesNotThrow(() -> {
            DataUtilities.calculateRowTotal(emptyData, 0);
        });
    }

 // Empty table – returns zero
    @Test
    void emptyTableResult() {
    	DefaultKeyedValues2D emptyData = new DefaultKeyedValues2D();

        double result = DataUtilities.calculateRowTotal(emptyData, 0);

        assertEquals(0.0, result, 0.0001);
    }

// Invalid row index – does not throw an exception
    @Test
    void invalidRow() {
        assertDoesNotThrow(() -> {
            DataUtilities.calculateRowTotal(exampleData, 5);
        });
    }

 // Invalid row index – returns zero 
    @Test
    void invalidRowResult() {
        double expected = 0.0;

        double result = DataUtilities.calculateRowTotal(exampleData, 5);

        assertEquals(expected, result, 0.0001);
    }
// single column – does not throw an exception
    @Test
    void singleColumn() {
    	DefaultKeyedValues2D oneColumn = new DefaultKeyedValues2D();
        oneColumn.addValue(10.0, 0, 0);

        assertDoesNotThrow(() -> {
            DataUtilities.calculateRowTotal(oneColumn, 0);
        });
    }
// Single column – correct mathematical result
    @Test
    void singleColumnResult() {
    	DefaultKeyedValues2D oneColumn = new DefaultKeyedValues2D();
        oneColumn.addValue(10.0, 0, 0);

        double expected = 10.0;

        double result = DataUtilities.calculateRowTotal(oneColumn, 0);

        assertEquals(expected, result, 0.0001);
    }
// null data object – throws InvalidParameterException
    @Test
    void nullData() {
        Exception exception = assertThrows(InvalidParameterException.class, () -> {
            DataUtilities.calculateRowTotal(null, 0);
        });

        assertNotNull(exception);
    }
    
 // Negative values - correct mathematical result
    @Test
    void withNegativeValues_ShouldCalculateCorrectly() {
        DefaultKeyedValues2D data = new DefaultKeyedValues2D();
        data.addValue(-5.0, 0, 0);  
        data.addValue(10.0, 0, 1);  
        data.addValue(-3.0, 0, 2);  
        
        double expected = 2.0;  // -5.0 + 10.0 + -3.0 = 2.0
        
        double result = DataUtilities.calculateRowTotal(data, 0);  // row 0
        assertEquals(expected, result, 0.0001);
    }

    // Large Values - can handle large quantities 
    @Test
    void withLargeValues_ShouldNotOverflow() {
        DefaultKeyedValues2D data = new DefaultKeyedValues2D();
        data.addValue(Double.MAX_VALUE, 0, 0); 
        data.addValue(Double.MAX_VALUE, 0, 1);  
        
        double result = DataUtilities.calculateRowTotal(data, 0);  // sum row 0
        assertEquals(Double.POSITIVE_INFINITY, result, 0.0001);
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }
}