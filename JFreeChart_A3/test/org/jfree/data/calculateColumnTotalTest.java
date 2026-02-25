package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class calculateColumnTotalTest {

    private DefaultKeyedValues2D exampleData;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        exampleData = new DefaultKeyedValues2D();
        exampleData.addValue(1, 0, 0);  
        exampleData.addValue(2, 1, 0);  
        exampleData.addValue(3, 2, 0); 
    }

// All valid values – doesn't throw an exception
    @Test
    void validValues() {
        assertDoesNotThrow(() -> {
            DataUtilities.calculateColumnTotal(exampleData, 0);
        });
    }

// Valid values – checks correct mathematical result
    @Test
    void validValuesResult() {
        double expected = 6;

        double result = DataUtilities.calculateColumnTotal(exampleData, 0);

        assertEquals(expected, result, 0.0001);
    }

// Column contains null values – does not throw an exception
    @Test
    void nullValues() {
        DefaultKeyedValues2D nullValues = new DefaultKeyedValues2D();
        nullValues.addValue(null, 0, 0);
        nullValues.addValue(5.0, 1, 0);

        assertDoesNotThrow(() -> {
            DataUtilities.calculateColumnTotal(nullValues, 0);
        });
    }

 // Column contains null values – nulls are ignored in sum
    @Test
    void nullValuesResult() {
    	DefaultKeyedValues2D nullValues = new DefaultKeyedValues2D();
        nullValues.addValue(null, 0, 0);
        nullValues.addValue(5.0, 1, 0);

        double expected = 5.0;

        double result = DataUtilities.calculateColumnTotal(nullValues, 0);

        assertEquals(expected, result, 0.0001);
    }

 // Empty table – does not throw an exception
    @Test
    void emptyTable() {
    	DefaultKeyedValues2D emptyData = new DefaultKeyedValues2D();

        assertDoesNotThrow(() -> {
            DataUtilities.calculateColumnTotal(emptyData, 0);
        });
    }

// Empty table – returns zero
    @Test
    void emptyTableResult() {
    	DefaultKeyedValues2D emptyData = new DefaultKeyedValues2D();

        double result = DataUtilities.calculateColumnTotal(emptyData, 0);

        assertEquals(0.0, result, 0.0001);
    }

// Invalid column index – does not throw an exception
    @Test
    void invalidColumn() {
        assertDoesNotThrow(() -> {
            DataUtilities.calculateColumnTotal(exampleData, 5);
        });
    }

// Invalid column index – returns zero (per specification)
    @Test
    void invalidColumnResult() {
        double expected = 0.0;

        double result = DataUtilities.calculateColumnTotal(exampleData, 5);

        assertEquals(expected, result, 0.0001);
    }

// Single row – does not throw an exception
    @Test
    void singleRow() {
    	DefaultKeyedValues2D oneRow = new DefaultKeyedValues2D();
        oneRow.addValue(10.0, 0, 0);

        assertDoesNotThrow(() -> {
            DataUtilities.calculateColumnTotal(oneRow, 0);
        });
    }

// Single row – correct mathematical result
    @Test
    void singleRowResult() {
    	DefaultKeyedValues2D oneRow = new DefaultKeyedValues2D();
        oneRow.addValue(10.0, 0, 0);

        double expected = 10.0;

        double result = DataUtilities.calculateColumnTotal(oneRow, 0);

        assertEquals(expected, result, 0.0001);
    }
// Null data object – throws InvalidParameterException
    @Test
    void nullData() {
        Exception exception = assertThrows(InvalidParameterException.class, () -> {
            DataUtilities.calculateColumnTotal(null, 0);
        });

        assertNotNull(exception);
    }
 // negative values - correct mathematical result
    @Test
    void withNegativeValues_ShouldCalculateCorrectly() {
        DefaultKeyedValues2D data = new DefaultKeyedValues2D();
        data.addValue(-5.0, 0, 0);
        data.addValue(10.0, 1, 0);
        data.addValue(-3.0, 2, 0);
        
        double expected = 2.0; // -5.0 + 10.0 + -3.0 = 2.0
        
        double result = DataUtilities.calculateColumnTotal(data, 0);
        assertEquals(expected, result, 0.0001);
    }
// Large Values - can handle large quantities 
    @Test
    void withLargeValues_ShouldNotOverflow() {
        DefaultKeyedValues2D data = new DefaultKeyedValues2D();
        data.addValue(Double.MAX_VALUE, 0, 0);
        data.addValue(Double.MAX_VALUE, 1, 0);
        
        double result = DataUtilities.calculateColumnTotal(data, 0);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.0001);
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }
    
    
}