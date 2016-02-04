package org.dedda.bratwurst.lang.assertions;

import org.dedda.bratwurst.ScopedTestCase;
import org.dedda.bratwurst.lang.*;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by dedda on 1/24/16.
 *
 * @author dedda
 */
public class AssertEqualsTest extends ScopedTestCase {

    @Test
    public void testAssertEqualsInteger() throws Exception {
        AssertEquals assertEquals = new AssertEquals(0, "var1", "var2");
        assertTrue(assertEquals.assertEqualsInteger(
                new BWVariable("var1", new BWInteger(123)),
                new BWVariable("var2", new BWInteger(123))
        ));
        assertFalse(assertEquals.assertEqualsInteger(
                new BWVariable("var1", new BWInteger(123)),
                new BWVariable("var2", new BWInteger(321))
        ));
    }

    @Test
    public void testAssertEqualsString() throws Exception {
        AssertEquals assertEquals = new AssertEquals(0, "var1", "var2");
        assertTrue(assertEquals.assertEqualsString(
                new BWVariable("var1", new BWString("test")),
                new BWVariable("var2", new BWString("test"))
        ));
        assertFalse(assertEquals.assertEqualsString(
                new BWVariable("var1", new BWString("test")),
                new BWVariable("var2", new BWString("tset"))
        ));
    }

    @Test
    public void testAssertEqualsObject() throws Exception {
        AssertEquals assertEquals = new AssertEquals(0, "var1", "var2");
        assertTrue(assertEquals.assertEqualsObject(
                new BWVariable("var1", new BWObject(BWClass.getClassForName("testClass"))),
                new BWVariable("var2", new BWObject(BWClass.getClassForName("testClass")))
        ));
        assertFalse(assertEquals.assertEqualsObject(
                new BWVariable("var1", new BWObject(BWClass.getClassForName("testClass"))),
                new BWVariable("var2", new BWObject(BWClass.getClassForName("testClass2")))
        ));
    }
}