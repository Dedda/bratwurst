package org.dedda.bratwurst.parse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.dedda.bratwurst.parse.Patterns.*;
import static org.junit.Assert.*;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
@RunWith(Parameterized.class)
public class PatternsTest {

    @Parameters
    public static Collection<Object[]> getParams() {
        return Arrays.asList(new Object[][]{
                {BEGIN, "==>", true},
                {END, "<==", true},
                {CLASS_BEGIN, "#[", true},
                {CLASS_END, "]", true},
                {FUNCTION_BEGIN, "~{", true},
                {FUNCTION_END, "}", true},
                {FUNCTION_CALL, "test{test}", true},
                {FUNCTION_CALL, "test{test} @ test <-- 1", true},
                {FUNCTION_CALL, "test{test} @ test <-- 1 & test <-- 2", true},
                {CLASS_INSTANTIATION, "[test]", true},
                {VARIABLE_DECLARATION, "(test) <-- 123", true},
                {VARIABLE_DECLARATION, "(test) <-- test{test} @ test <-- 2 & test <-- 3", true},
                {VARIABLE_DECLARATION, "(test) <-- [test]", true},
                {INCLUDE, "%test.bw%", true},
                {PRINT, ">td<", true},
                {CONDITION_HEAD, "?(test)>>", true},
                {CONDITION_SEPARATOR, "<<", true},
                {CONDITION_END, "|", true},
                {LOOP_HEAD, "/(test)", true},
                {LOOP_END, "\\", true},
        });
    }

    @Parameter(0)
    public String pattern;
    @Parameter(1)
    public String text;
    @Parameter(2)
    public boolean matches;

    @Test
    public void testPattern() {
        if (matches) {
//            System.out.println("'" + text + "' should match pattern '" + pattern + "'");
            assertTrue(text.matches(pattern));
        } else {
//            System.out.println("'" + text + "' should not match pattern '" + pattern + "'");
            assertFalse(text.matches(pattern));
        }
    }

}