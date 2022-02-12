package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.scope.Scope;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class ConditionTest extends BratwurtstTestcase {

    private boolean trueRun = false;
    private boolean falseRun = false;
    private int testValue;
    private Condition condition;

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
        trueRun = false;
        falseRun = false;
        testValue = 1;
        condition.run(mock(Scope.class));
        assertTrue(trueRun);
        assertFalse(falseRun);
    }

    @Test
    public void testRunFalse() throws Exception {
        trueRun = false;
        falseRun = false;
        testValue = 0;
        condition.run(mock(Scope.class));
        assertFalse(trueRun);
        assertTrue(falseRun);
    }
}