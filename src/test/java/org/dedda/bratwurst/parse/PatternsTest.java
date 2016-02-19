package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.dedda.bratwurst.parse.Patterns.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
public class PatternsTest extends BratwurtstTestcase {

    @DataProvider(name = "getParams")
    public static Object[][] getParams() {
        return new Object[][]{
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
                {RETURN, "123 -->", true},
                {RETURN, "abc -->", true},
                {RETURN, "abc{def} @ test <-- 1 & test <-- 2 -->", true},
                {CALCULATION, "123 + 456", true},
                {CALCULATION, "abc - 456", true},
                {CALCULATION, "abc * def", true},
                {CALCULATION, "abc{ghi} @ j <-- 1 & k <-- 2 / def", true},
                {CALCULATION, "abc{ghi} @ j <-- 1 & k <-- 2 / def{lmn} @ o <-- 1 & p <-- 2", true},
                {POP, "<test<", true},
                {POP, "<test>", false},
                {PUSH, ">test>", true},
                {PUSH, "<test>", false},
                {TYPE_CHECK, "testVar -?> testClass", true},
                {TYPE_CHECK, "testVar <?- testClass", false},
                {BW_STRING, ":Here's some text!;", true},
                {BW_STRING, ":Here's some wrong: text!;", false},
                {BW_STRING, ":Here's some wrong; text!;", false},
                {BW_STRING, ":Here's some wrong text!", false},
                {BW_STRING, "Here's some wrong text!;", false}
        };
    }

    @Test(dataProvider = "getParams")
    public void testPattern(String pattern, String text, boolean matches) {
        if (matches) {
            assertTrue(text.matches(pattern));
        } else {
            assertFalse(text.matches(pattern));
        }
    }

}
