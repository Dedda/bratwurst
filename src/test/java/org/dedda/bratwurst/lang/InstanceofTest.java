package org.dedda.bratwurst.lang;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dedda on 12/9/15.
 *
 * @author dedda
 */
public class InstanceofTest {

    @Test
    public void testRun() throws Exception {
        String integerType = "integer";
        String testType = "testClass";
        BWClass testClass = new BWClass("testClass", new BWFunction[0]);
        BWInteger integer = new BWInteger(12);
        BWObject testObject = new BWObject(testClass, new BWFunction[0]);
        Instanceof instruction = new Instanceof(0, integer, integerType);
        instruction.run(null);
        assertEquals(new BWInteger(1), instruction.getValue());
        instruction = new Instanceof(0, integer, testType);
        instruction.run(null);
        assertEquals(new BWInteger(0), instruction.getValue());
        instruction = new Instanceof(0, testObject, testType);
        instruction.run(null);
        assertEquals(new BWInteger(1), instruction.getValue());
        instruction = new Instanceof(0, testObject, integerType);
        instruction.run(null);
        assertEquals(new BWInteger(0), instruction.getValue());
    }
}