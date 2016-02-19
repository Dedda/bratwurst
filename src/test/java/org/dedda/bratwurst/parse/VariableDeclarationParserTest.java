package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.VariableDeclaration;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.Assert.assertEquals;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class VariableDeclarationParserTest extends BratwurtstTestcase {

    @DataProvider(name = "getParams")
    public static Object[][] getParams() {
        return new Object[][]{
                {"(px) <-- 65", "px"},
                {"(abc) <-- {test} @ def <-- 13 & ghi <-- 26", "abc"},
                {"(point) <-- [Point]", "point"},
                {"(px) <-- point{getX}", "px"}
        };
    }

    @Test(dataProvider = "getParams")
    public void testParseDeclaration(String data, String expectedName) throws Exception {
        VariableDeclarationParser parser = new VariableDeclarationParser();
        VariableDeclaration declaration = parser.parseDeclaration(data, 0);
        assertEquals(expectedName, declaration.getVariableName());
    }
}