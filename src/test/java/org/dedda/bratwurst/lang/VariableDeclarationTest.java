package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.ScopedTestCase;
import org.dedda.bratwurst.lang.scope.Scope;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by dedda on 12/17/15.
 *
 * @author dedda
 */
public class VariableDeclarationTest extends ScopedTestCase {

    private Scope scope;

    @BeforeMethod
    public void setUp() throws Exception {
        scope = createEmptyScope();
    }

    @Test
    public void testRun() throws Exception {
        VariableDeclaration declaration = new VariableDeclaration(0, "abc", new BWInteger(123));
        declaration.run(scope);
        assertEquals(123, scope.getVariable("abc").getIntValue());
    }
}