package org.dedda.bratwurst.parse.validate;

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
 * Created by dedda on 9/27/15.
 *
 * @author dedda
 */
@RunWith(Parameterized.class)
public class IsCorrectFunctionCallTest {

    private VariableDeclarationValidator instance;

    @Before
    public void setUp() {
        this.instance = new VariableDeclarationValidator();
    }

    @Parameters
    public static Collection<Object[]> getParams() {
        return Arrays.asList(new Object[][]{
                {"abc{test}", true},
                {"abc{test} @ var <-- 14", true},
                {"abc{test} @ var <-- 14 & otherVar <-- 1", true},
                {"{test}", false},
                {"abc{}", false},
                {"abc{test} var <-- 14", false},
                {"abc{test} @ <-- 14", false},
                {"abc{test} @ var 14", false},
                {"abc{test} @ var <--", false},
                {"abc{test} @ var <-- 14 otherVar <-- 1", false}
        });
    }

    @Parameter(0)
    public String line;
    @Parameter(1)
    public boolean isValid;

    @Test
    public void testIsCorrectFunctionCall() throws Exception {
        if (isValid) {
            assertTrue(instance.isCorrectFunctionCall(line));
        } else {
            assertFalse(instance.isCorrectFunctionCall(line));
        }
    }
}