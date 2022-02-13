package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.scope.Scope;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
public class PrintCharTest extends BratwurtstTestcase {

    private String outputBuffer = "";

    private final PrintStream systemOut = System.out;
    private final OutputStream customOut = new OutputStream() {
        @Override
        public void write(int b) throws IOException {
            outputBuffer += (char) b;
        }
    };

    public void setUp() throws Exception {
        System.setOut(new PrintStream(customOut));
    }

    @AfterTest
    public void tearDown() throws Exception {
        System.setOut(systemOut);
    }

    @Test
    public void testRun() throws Exception {
        PrintChar instance = new PrintChar(0, 'A');
        instance.run(mock(Scope.class));
        assertEquals(outputBuffer, "A");
    }
}