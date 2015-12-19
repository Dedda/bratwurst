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
                {FUNCTION_CALL,         ROSE + "{" + BABY_BOTTLE + LOLLIPOP + "}",                      true},
                {FUNCTION_CALL,         OCTOPUS + "{" + MEH + DONUT + "} @ " + CLOVER + " <-- 1",       true},
                {FUNCTION_CALL,         TIGER + "{" + SUSHI + SPOCK + "} @ " + TWO_BEERS + " <-- 1 & " + CANDY + " <-- 2",   true},
                {CLASS_INSTANTIATION,   "[" + BABY + BEER + "]",                                        true},
                {VARIABLE_DECLARATION,  "(" + OCTOPUS + TIGER + ") <-- 123",                            true},
                {VARIABLE_DECLARATION,  "(" + OCTOPUS + TIGER + ") <-- " + CLOVER + "{" + MEH + SOFT_ICE + "} @ " + TWO_BEERS + " <-- 2 & " + ROSE + " <-- 3",   true},
                {VARIABLE_DECLARATION,  "(" + OCTOPUS + TIGER + ") <-- [" + UNICORN + PALM + "]",       true},
                {INCLUDE,               "%test.bw%",                                                    true},
                {PRINT,                 SNAKE + SKULL_BONES + TURBAN,                                   true},
                {PRINT,                 X_X + 'R' + PIG,                                                true},
                {PRINT,                 X_X + "-123" + PIG,                                             true},
                {CONDITION_HEAD,        EVERGREEN + "test" + CORN,                                      true},
                {CONDITION_SEPARATOR,   SQUIRT,                                                         true},
                {CONDITION_END,         BANANA,                                                         true},
                {LOOP_HEAD,             EXPLOSION + "test" + HEART_BIG,                                 true},
                {LOOP_END,              GRAND_PA,                                                       true},
                {RETURN,                METAL + TIGER + " -->",                                         true},
                {RETURN,                BOY + PEAR + " -->",                                            true},
                {RETURN,                BOY + "{" + SPIDER + ELEPHANT + "} @ " + TIGER + " <-- 1 & " + OCTOPUS + " <-- 2 -->",    true},
                {CALCULATION,           "123 + 456",                                                    true},
                {CALCULATION,           SKULL_BONES + TIGER + " - 456",                                 true},
                {CALCULATION,           CLOVER + ROSE + " * " + OCTOPUS + COOKIE,                       true},
                {CALCULATION,           SKULL_BONES + "{" + TREE_REGULAR + SOFT_ICE + "} @ " + WINE + " <-- 1 & " + FRIED_SHRIMP + " <-- 2 / " + FRIED_SHRIMP,  true},
                {CALCULATION,           CHERRIES + "{" + SUSHI + "} @ " + COOKIE + " <-- 1 & " + METAL + " <-- 2 / " + HOT_DOG + "{" + SMIRKING + "} @ " + TWO_BEERS + " <-- 1 & " + BREAD + " <-- 2", true},
                {POP,                   PINEAPPLE + SKULL_BONES + OCTOPUS + MONKEY_FACE,                true},
                {POP,                   "<test>",                                                       false},
                {PUSH,                  LEMON + TIGER + METAL + BOY + SANTA,                            true},
                {PUSH,                  "<test>",                                                       false},
                {TYPE_CHECK,            SKULL_BONES + CACTUS + POLICE + CAKE_PIECE,                     true},
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
            assertTrue("\"" + text + "\" does not match \"" + pattern + "\"!", text.matches(pattern));
        } else {
            assertFalse("\"" + text + "\" does match \"" + pattern + "\"!", text.matches(pattern));
        }
    }
}