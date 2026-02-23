package org.jfree.data;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
public class CreateNumberArray2DTest {
	
	private double[][] Array2DTest;

	@BeforeEach
  	void setUp() throws Exception {
		double[][] Array2DTest = 
			{
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
			};
	}
	
	@Test 
	void test() throws Exception {
		double[][] Array2DTest = 
			{
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},          
				{1, 2, 3, 4, 5},
			};
		assertEquals(Array2DTest, createNumberArray2D();
	}
}
