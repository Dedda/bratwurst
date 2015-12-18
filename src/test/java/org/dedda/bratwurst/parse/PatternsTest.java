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
public class PatternsTest extends BratwurtstTestcase {

    @Parameters
    public static Collection<Object[]> getParams() {
        return Arrays.asList(new Object[][]{
                {BEGIN,                 ALIEN,                                                          true},
                {END,                   ALL_OK,                                                         true},
                {CLASS_BEGIN,           GHOST,                                                          true},
                {CLASS_END,             ANGEL_FACE,                                                     true},
                {FUNCTION_BEGIN,        BOMB,                                                           true},
                {FUNCTION_END,          FLEX,                                                           true},
                {FUNCTION_CALL,         "test{test}",                                                   true},
                {FUNCTION_CALL,         "test{test} @ test <-- 1",                                      true},
                {FUNCTION_CALL,         "test{test} @ test <-- 1 & test <-- 2",                         true},
                {CLASS_INSTANTIATION,   "[test]",                                                       true},
                {VARIABLE_DECLARATION,  "(test) <-- 123",                                               true},
                {VARIABLE_DECLARATION,  "(test) <-- test{test} @ test <-- 2 & test <-- 3",              true},
                {VARIABLE_DECLARATION,  "(test) <-- [test]",                                            true},
                {INCLUDE,               "%test.bw%",                                                    true},
                {PRINT,                 SNAKE + "td" + TURBAN,                                          true},
                {CONDITION_HEAD,        EVERGREEN + "test" + CORN,                                      true},
                {CONDITION_SEPARATOR,   SQUIRT,                                                         true},
                {CONDITION_END,         BANANA,                                                         true},
                {LOOP_HEAD,             EXPLOSION + "test" + HEART_BIG,                                 true},
                {LOOP_END,              GRAND_PA,                                                       true},
                {RETURN,                "123 -->",                                                      true},
                {RETURN,                "abc -->",                                                      true},
                {RETURN,                "abc{def} @ test <-- 1 & test <-- 2 -->",                       true},
                {CALCULATION,           "123 + 456",                                                    true},
                {CALCULATION,           "abc - 456",                                                    true},
                {CALCULATION,           "abc * def",                                                    true},
                {CALCULATION,           "abc{ghi} @ j <-- 1 & k <-- 2 / def",                           true},
                {CALCULATION,           "abc{ghi} @ j <-- 1 & k <-- 2 / def{lmn} @ o <-- 1 & p <-- 2",  true},
                {POP,                   "<test<",                                                       true},
                {POP,                   "<test>",                                                       false},
                {PUSH,                  ">test>",                                                       true},
                {PUSH,                  "<test>",                                                       false},
                {TYPE_CHECK,            "testVar -?> testClass",                                        true},
                {TYPE_CHECK,            "testVar <?- testClass",                                        false},
                {BW_STRING,             POODLE + "Here's some text!" + POOP,                            true},
                {BW_STRING,             POODLE + "Here's some wrong text!",                             false},
                {BW_STRING,             "Here's some wrong text!" + POOP,                               false}
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
            assertTrue(text.matches(pattern));
        } else {
            assertFalse(text.matches(pattern));
        }
    }

}