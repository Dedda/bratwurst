package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.ScopedTestCase;
import org.dedda.bratwurst.lang.scope.Scope;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
public class StringConcatenationTest extends ScopedTestCase {

    @Test
    public void testRun() throws Exception {
        String[] texts = {
                "Hello ",
                "World",
                "!"
        };
        int intVal = 123;
        Scope scope = createEmptyScope();
        scope.setVariable(new BWVariable("var1", new BWString("Hello ")));
        scope.setVariable(new BWVariable("var2", new BWString("World")));
        scope.setVariable(new BWVariable("var3", new BWString("!")));
        scope.setVariable(new BWVariable("var4", new BWInteger(123)));
        StringConcatenation concatenation = new StringConcatenation(0, new String[]{
                "var1",
                "var2",
                "var3",
                "var4"
        });
        String expected = "Hello World!123";
        concatenation.run(scope);
        String actual = ((BWString) concatenation.getValue()).getStringValue();
        assertEquals(expected, actual);
    }
}