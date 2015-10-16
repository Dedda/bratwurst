package org.dedda.bratwurst.lang;

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
public class BWFunctionTest {

    private BWFunction function;

    @Before
    public void setUp() throws Exception {
        function = new BWFunction("testFunction", instructions);
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
                        new BWInstruction() {
                            @Override
                            public void run(Scope scope) {}
                        }
                }, new BWInteger(0), new BWVariable[0]},
                {new BWInstruction[] {
                        new BWInstruction() {
                            @Override
                            public void run(Scope scope) {}
                        }, new Return(new BWInteger(1))
                }, new BWInteger(1), new BWVariable[0]},
                {new BWInstruction[] {
                        new Return(
                                new ReadVariable("a")
                        )
                }, new BWInteger(1), new BWVariable[]{
                        new BWVariable("a", new BWInteger(1))
                }}
        });
    }

    @Test
    public void testFunction() throws Exception {
        function.setArguments(arguments);
        function.run(new Scope(null));
        assertEquals(expectedValue.getValueType(), function.getValueType());
        assertEquals(expectedValue.getIntValue(), function.getIntValue());
    }
}