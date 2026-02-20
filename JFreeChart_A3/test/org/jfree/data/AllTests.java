package org.jfree.data;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ CombineTest.class, ConstrainTest.class, ContainsTest.class, EqualsTest.class, ExpandTest.class,
		ExpandToIncludeTest.class, GetCentralValueTest.class, GetLengthTest.class, GetLowerBoundTest.class,
		GetUpperBoundTest.class, IntersectsTest.class, ShiftTest.class, ShiftWithZeroCrossingTest.class,
		StringTest.class })
public class AllTests {

}
