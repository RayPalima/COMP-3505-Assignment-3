package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CreateNumberArray2DTest {
	
	private Number[][] result;
	@Test 
	void values2D_NullTest() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> {
		    DataUtilities.createNumberArray2D(null);
		});
	}
	@Test
	void values2D_EmptyTest() {
		double[][] data = new double[0][];
		result = DataUtilities.createNumberArray2D(data);
		assertAll(
				() -> assertNotNull(result),
				() -> assertEquals(0, result.length)
				);
	}
	@Test
	void values2D_SingleRowTest() {
		double[][] data = {
			    {1.0, 2.0, 3.0}
		};
		result = DataUtilities.createNumberArray2D(data);
		
		assertAll(
				() -> assertNotNull(result),
				() -> assertEquals(1, result.length),
				() -> assertEquals(3, result[0].length),
				() -> assertEquals(1.0, result[0][0]),
				() -> assertEquals(2.0, result[0][1]),
				() -> assertEquals(3.0, result[0][2])
				);
	}
	@Test
	void values2D_MultiRowTest() {
		double[][] data = {
				{1.0, 2.0, 3.0}, 
				{4.0, 5.0, 6.0}, 
				{7.0, 8.0, 9.0}};
		result = DataUtilities.createNumberArray2D(data);
		
		assertAll(
			() -> assertNotNull(result),
			() -> assertEquals(3, result.length),
			() -> assertEquals(3, result[0].length),
			() -> assertEquals(3, result[1].length),
			() -> assertEquals(3, result[2].length),
			() -> assertEquals(1.0, result[0][0]),
			() -> assertEquals(4.0, result[1][0]),
			() -> assertEquals(7.0, result[2][0])
		);
	}
	@Test
	void values2D_DiffRowTest() {
		double[][] data = {
				{1.0, 4.0},
				{2.0, 3.0, 5.0},
				{9.0}
		};
		result = DataUtilities.createNumberArray2D(data);
		assertAll(
			() -> assertNotNull(result),
			() -> assertEquals(3, result.length),
			() -> assertEquals(2, result[0].length),
			() -> assertEquals(3, result[1].length),
			() -> assertEquals(1, result[2].length),
			() -> assertEquals(1.0, result[0][0]),
			() -> assertEquals(5.0, result[1][2]),
			() -> assertEquals(9.0, result[2][0])
				);
	}
	@Test
	void values2D_EmptyRowTest() {
		double[][] data = {
				{},
				{2.0, 3.0, 5.0}
		};
		result = DataUtilities.createNumberArray2D(data);
		assertAll(
			() -> assertNotNull(result),
			() -> assertEquals(2, result.length),
			() -> assertEquals(0, result[0].length),
			() -> assertEquals(3, result[1].length),
			() -> assertEquals(5.0, result[1][2])
				);
	}
	@Test
	void values2D_NullRowTest() {
		double[][] data = {
				null,
				{2.0, 3.0, 5.0}
		};
		assertThrows(IllegalArgumentException.class, () -> {
			DataUtilities.createNumberArray2D(data);
		});
	}
	@Test
	void values2D_NegativeTest() {
		double[][] data = {
				{-1}
		};
		result = DataUtilities.createNumberArray2D(data);
		assertAll(
			() -> assertNotNull(result),
			() -> assertEquals(1, result.length),
			() -> assertEquals(-1, result[0][0])
				);
	}
	@Test
	void values2D_ZeroTest() {
		double[][] data = {
				{0}
		};
		result = DataUtilities.createNumberArray2D(data);
		assertAll(
			() -> assertNotNull(result),
			() -> assertEquals(1, result.length),
			() -> assertEquals(0, result[0][0])
				);
	}
	
    
}
