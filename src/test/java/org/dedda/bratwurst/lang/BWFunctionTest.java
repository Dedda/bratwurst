package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.ScopedTestCase;
import org.dedda.bratwurst.lang.scope.Scope;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class BWFunctionTest extends ScopedTestCase {

    private BWFunction function;
    private static boolean[] executed;

    // TODO: Fix params
    @DataProvider(name = "getParams")
    public Object[][] getParams() {
        return new Object[][]{
                {new BWInstruction[] {
                        new BWInstruction(0) {
                            @Override
                            public void run(Scope scope) {
                                executed[0] = true;
                            }
                        },
                        new BWInstruction(0) {
                            @Override
                            public void run(Scope scope) {
                                executed[1] = true;
                            }
                        }
                }, new BWInteger(0), new BWVariable[0]},
                {new BWInstruction[] {
                        new BWInstruction(0) {
                            @Override
                            public void run(Scope scope) {
                                executed[0] = true;
                            }
                        }, new Return(0, new BWInteger(1){
                    @Override
                    public void run(Scope scope) {
                        super.run(scope);
                        executed[1] = true;
                    }
                })
                }, new BWInteger(1), new BWVariable[0]}
        };
    }

    @Test(dataProvider = "getParams")
    public void testFunction(BWInstruction[] instructions, BWObject expectedValue, BWVariable[] arguments) throws Exception {
        function = new BWFunction("testFunction", instructions);
        executed = new boolean[instructions.length];
        for (int i = 0; i < executed.length; i++) {
            executed[i] = false;
        }
        function.setArguments(arguments);
        function.run(createEmptyScope());
        assertEquals(expectedValue.getValueType(), function.getValueType());
        assertEquals(expectedValue.getIntValue(), function.getIntValue());
        for (int i = 0; i < executed.length; i++) {
            boolean isExecuted = executed[i];
            assertTrue("instruction " + i + " wan't executed!", isExecuted);
        }
    }
}