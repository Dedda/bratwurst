package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.parse.Emoji;
import org.dedda.bratwurst.parse.StringValidator;
import org.dedda.bratwurst.parse.VariableDeclarationParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.dedda.bratwurst.parse.Emoji.BOY;
import static org.dedda.bratwurst.parse.Emoji.CHEESE;
import static org.dedda.bratwurst.parse.Emoji.OCTOPUS;
import static org.dedda.bratwurst.parse.Emoji.ROSE;
import static org.dedda.bratwurst.parse.Patterns.validVariableNameEmojis;
import static org.junit.Assert.*;

/**
 * Created by dedda on 12/19/15.
 *
 * @author dedda
 */
@RunWith(Parameterized.class)
public class StringValidatorTest {


    @Parameters
    public static Collection<Object[]> getParams() {
        return Arrays.asList(new Object[][]{
                {"test", false},
                {BOY + ROSE, true},
                {OCTOPUS + CHEESE, false}
        });
    }

    @Parameter(0)
    public String toTest;

    @Parameter(1)
    public boolean isValid;

    @Test
    public void testIsValid() throws Exception {
        if (isValid) {
            assertTrue("\"" + toTest + "\" should be valid!", new StringValidator().isValid(toTest, validVariableNameEmojis()));
        } else {
            assertFalse("\"" + toTest + "\" should not be valid!", new StringValidator().isValid(toTest, validVariableNameEmojis()));
        }
    }
}