package org.dedda.bratwurst.lang;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class CalculationTest {

    @Test
    public void testRun() throws Exception {
        BWInteger int1 = new BWInteger(10);
        BWInteger int2 = new BWInteger(2);
        Calculation calculation = new Calculation(int1, int2, '+');
        calculation.run(null);
        assertEquals(12, calculation.getIntValue());
        calculation = new Calculation(int1, int2, '-');
        calculation.run(null);
        assertEquals(8, calculation.getIntValue());
        calculation = new Calculation(int1, int2, '*');
        calculation.run(null);
        assertEquals(20, calculation.getIntValue());
        calculation = new Calculation(int1, int2, '/');
        calculation.run(null);
        assertEquals(5, calculation.getIntValue());
    }

    @Test
    public void testGetIntValue() throws Exception {
        Calculation calculation = new Calculation(new BWInteger(1), new BWInteger(2), '+');
        calculation.run(null);
        assertEquals(3, calculation.getIntValue());
    }

    @Test
    public void testGetValue() throws Exception {
        Calculation calculation = new Calculation(new BWInteger(1), new BWInteger(2), '+');
        calculation.run(null);
        assertEquals("integer", calculation.getValue().getValueType());
        assertEquals(3, calculation.getValue().getIntValue());
    }

    @Test
    public void testGetValueType() throws Exception {
        assertEquals("integer", new Calculation(null, null, '+').getValueType());
    }
}