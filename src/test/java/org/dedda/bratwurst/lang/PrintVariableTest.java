package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.classes.BWClass;
import org.dedda.bratwurst.lang.scope.Scope;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

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

    @DataProvider(name = "getParams")
    public static Object[][] getParams() {
        return new Object[][]{
                {"A", new BWVariable("testVar", new BWInteger('A'))},
                {"Test", new BWVariable("testVar", new BWString("Test"))},
                {"" + (char) 0, new BWVariable("testVar", new BWObject(BWClass.getClassForName("testClass")))}

        };
    }

    public final Scope scope = new Scope(program);

    @AfterTest
    public void tearDown() throws Exception {
        System.setOut(systemOut);
    }

    @Test(dataProvider = "getParams")
    public void testRun(String expected, BWVariable programVariable) throws Exception {
        systemOut = System.out;
        System.setOut(new PrintStream(customOut));
        outputBuffer = "";
        program.setVariables(new ArrayList<>(Arrays.asList(new BWVariable[]{programVariable})));
        PrintVariable printVariable = new PrintVariable(0, "testVar");
        printVariable.run(scope);
        assertEquals(expected, outputBuffer);
    }
}