package org.dedda.bratwurst.lang;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class ConditionTest {

    private boolean trueRun = false;
    private boolean falseRun = false;
    private int testValue;
    private Condition condition;

    @Before
    public void setUp() throws Exception {
        BWInstruction[] trueInstructions = new BWInstruction[]{
                new BWInstruction(0) {
                    @Override
                    public void run(Scope scope) {
                        trueRun = true;
                    }
                }
        };
        BWInstruction[] falseInstructions = new BWInstruction[]{
                new BWInstruction(0) {
                    @Override
                    public void run(Scope scope) {
                        falseRun = true;
                    }
                }
        };
        BWExpression expression = new BWInteger(0) {
            @Override
            public int getIntValue() {
                return testValue;
            }
        };
        condition = new Condition(0, expression, trueInstructions, falseInstructions);
    }

    @Test
    public void testRunTrue() throws Exception {
        testValue = 1;
        condition.run(null);
        assertTrue(trueRun);
        assertFalse(falseRun);
    }

    @Test
    public void testRunFalse() throws Exception {
        testValue = 0;
        condition.run(null);
        assertFalse(trueRun);
        assertTrue(falseRun);
    }
}