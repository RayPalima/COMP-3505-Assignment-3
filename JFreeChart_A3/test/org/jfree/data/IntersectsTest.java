package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class IntersectsTest {
    private Range exampleRange;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @Test
    void testFullIntersectingRanges() throws Exception {
        exampleRange = new Range(100, 500);
        assertTrue(exampleRange.intersects(180,480),"Overlap expected");
    }

    @Test
    void testNonIntersectingRanges() throws Exception {
        exampleRange = new Range(0, 5);
        assertFalse(exampleRange.intersects(100,101),"No overlap");
    }
    void testIntersectingNegativeRanges() throws Exception {
        exampleRange = new Range(-20, -1);
        assertTrue(exampleRange.intersects(-5,-4),"Overlap expected");
    }
    @Test
    void testNonIntersectingNegativeRanges() throws Exception {
        exampleRange = new Range(-20,-1);
        assertTrue(exampleRange.intersects(0,5),"No overlap");
    }
    @Test
    void testPositiveToNegativeIntersecting() throws Exception{
    	exampleRange = new Range(-20,20);
        assertTrue(exampleRange.intersects(0,5),"Overlap Expected");
    }
    @Test
    void testPositiveToNegativeNonIntersecting() throws Exception{
    	exampleRange = new Range(-20,20);
        assertTrue(exampleRange.intersects(30,31),"No Overlap");
    }
    @Test
    void testUpperIntersecting() throws Exception {
        exampleRange = new Range(99,110);
        assertTrue(exampleRange.intersects(50,99), "Partial Upper Overlap");
    }

    @Test
    void testSinglePointRange() throws Exception{
    	exampleRange = new Range(99,99);
        assertTrue(exampleRange.intersects(99,99), "Complete Overlap");
    }
   
}
