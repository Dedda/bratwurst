package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
public class PrintCharTest extends BratwurtstTestcase {

    private String outputBuffer = "";

    private PrintStream systemOut = System.out;
    private OutputStream customOut = new OutputStream() {
        @Override
        public void write(int b) throws IOException {
            outputBuffer += (char) b;
        }
    };

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(customOut));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(systemOut);
    }

    @Test
    public void testRun() throws Exception {
        PrintChar instance = new PrintChar(0, 'A');
        instance.run(null);
        assertEquals(outputBuffer, "A");
    }
}