package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.scope.Scope;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
@RunWith(Parameterized.class)
public class BWFunctionTest extends BratwurtstTestcase {

    private BWFunction function;
    private static boolean[] executed;

    @Before
    public void setUp() throws Exception {
        function = new BWFunction("testFunction", instructions);
        executed = new boolean[instructions.length];
        for (int i = 0; i < executed.length; i++) {
            executed[i] = false;
        }
    }

    @Parameter(0)
    public BWInstruction[] instructions;

    @Parameter(1)
    public BWObject expectedValue;

    @Parameter(2)
    public BWVariable[] arguments;

    @Parameters
    public static Collection<Object[]> getParams() {
        return Arrays.asList(new Object[][]{
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
        });
    }

    @Test
    public void testFunction() throws Exception {
        function.setArguments(arguments);
        function.run(new Scope(new Program()));
        assertEquals(expectedValue.getValueType(), function.getValueType());
        assertEquals(expectedValue.getIntValue(), function.getIntValue());
        for (int i = 0; i < executed.length; i++) {
            boolean isExecuted = executed[i];
            assertTrue("instruction " + i + " wan't executed!", isExecuted);
        }
    }
}