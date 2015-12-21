package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.VariableDeclaration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.dedda.bratwurst.parse.Emoji.*;
import static org.junit.Assert.*;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
@RunWith(Parameterized.class)
public class VariableDeclarationParserTest extends BratwurtstTestcase {

    @Parameters
    public static Collection<Object[]> getParams() {
        return Arrays.asList(new Object[][]{
                {AUBERGINE + SKULL_BONES + FRIES + " <-- 65", SKULL_BONES},
                {AUBERGINE + TIGER + METAL + FRIES + " <-- {test} @ def <-- 13 & ghi <-- 26", TIGER + METAL},
                {AUBERGINE + OCTOPUS + BREAD + TWO_BEERS + FRIES + " <-- [Point]", OCTOPUS + BREAD + TWO_BEERS},
                {AUBERGINE + WINE + FRIES + " <-- point{getX}", WINE}
        });
    }

    @Parameter(0)
    public String data;

    @Parameter(1)
    public String expectedName;

    @Test
    public void testParseDeclaration() throws Exception {
        VariableDeclarationParser parser = new VariableDeclarationParser();
        VariableDeclaration declaration = parser.parseDeclaration(data, 0);
        assertEquals(expectedName, declaration.getVariableName());
    }
}