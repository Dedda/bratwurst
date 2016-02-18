package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.scope.Scope;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.testng.Assert.assertEquals;

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
public class PrintVariableTest extends BratwurtstTestcase {

    public final static Program program = new Program();
    private PrintStream systemOut;
    private String outputBuffer = "";
    private final OutputStream customOut = new OutputStream() {
        @Override
        public void write(int b) throws IOException {
            outputBuffer += (char) b;
        }
    };

    // TODO: Fix params
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {"A", new BWVariable("testVar", new BWInteger('A'))},
                {"Test", new BWVariable("testVar", new BWString("Test"))},
                {"" + (char) 0, new BWVariable("testVar", new BWObject(BWClass.getClassForName("testClass")))}

        });
    }

    public String expected;

    public BWVariable programVariable;

    public final Scope scope = new Scope(program);

    public void setUp() throws Exception {
        systemOut = System.out;
        System.setOut(new PrintStream(customOut));
        outputBuffer = "";
        program.setVariables(new ArrayList<>(Arrays.asList(new BWVariable[]{programVariable})));
    }

    @AfterTest
    public void tearDown() throws Exception {
        System.setOut(systemOut);
    }

    @Test
    public void testRun() throws Exception {
        PrintVariable printVariable = new PrintVariable(0, "testVar");
        printVariable.run(scope);
        assertEquals(expected, outputBuffer);
    }
}