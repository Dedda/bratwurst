package org.dedda.bratwurst.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
@RunWith(Parameterized.class)
public class PrintVariableTest {

    private PrintStream systemOut;
    private String outputBuffer = "";
    private OutputStream customOut = new OutputStream() {
        @Override
        public void write(int b) throws IOException {
            outputBuffer += (char) b;
        }
    };

    @Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {"A", new Scope(null), new BWVariable("testVar", new BWInteger('A'))},
                {"Test", new Scope(null), new BWVariable("testVar", new BWString("Test"))},
                {"" + (char) 0, new Scope(null), new BWVariable("testVar", new BWObject(null, null, null))}

        });
    }

    @Parameter(0)
    public String expected;

    @Parameter(1)
    public Scope scope;

    @Parameter(2)
    public BWVariable programVariable;

    @Before
    public void setUp() throws Exception {
        systemOut = System.out;
        System.setOut(new PrintStream(customOut));
        outputBuffer = "";
        Program.getInstance().setVariables(new ArrayList<>(Arrays.asList(new BWVariable[]{programVariable})));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(systemOut);
    }

    @Test
    public void testRun() throws Exception {
        PrintVariable printVariable = new PrintVariable("testVar");
        printVariable.run(scope);
        assertEquals(expected, outputBuffer);
    }
}