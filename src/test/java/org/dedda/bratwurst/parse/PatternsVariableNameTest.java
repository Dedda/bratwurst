package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.dedda.bratwurst.parse.Emoji.*;
import static org.dedda.bratwurst.parse.Patterns.*;
import static org.junit.Assert.*;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
@RunWith(Parameterized.class)
public class PatternsVariableNameTest extends BratwurtstTestcase {

    @Parameters
    public static Collection<Object[]> getParams() {
        return Arrays.asList(new Object[][]{
            {METAL + COOKIE, true},
            {"testName", false},
            {HOT_DOG + DIAMOND, false}
        });
    }

    @Parameter(0)
    public String text;
    @Parameter(1)
    public boolean matches;

    @Test
    public void testPattern() {
        if (matches) {
            assertTrue("\"" + text + "\" does not match!", text.matches(VARIABLE_NAME));
        } else {
            assertFalse("\"" + text + "\" does match!", text.matches(VARIABLE_NAME));
        }
    }
}