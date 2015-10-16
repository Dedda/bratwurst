package org.dedda.bratwurst.lang;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class ScopeTest {

    @Test
    public void testIsInObject() throws Exception {
        Scope scope = new Scope(null, new BWVariable[0]);
        assertFalse(scope.isInObject());
        scope = new Scope(new BWObject(null, new BWVariable[0], new BWObjectFunction[0]), new BWVariable[0]);
        assertTrue(scope.isInObject());
    }

    @Test
    public void testRegisterVariable() throws Exception {
        Program.getInstance().setVariables(new BWVariable[0]);
        Scope scope = new Scope(null, new BWVariable[0]);
        scope.registerVariable(new BWVariable("testVar", new BWInteger(1)));
        assertEquals(1, Program.getInstance().getVariables().length);
        assertEquals(Program.getInstance().getVariables()[0].getName(), "testVar");
        assertEquals(Program.getInstance().getVariables()[0].getIntValue(), 1);

        Program.getInstance().setVariables(new BWVariable[0]);
        scope = new Scope(new BWObject(new BWClass("testClass", new AbstractFunction[0]), new BWVariable[0], new BWObjectFunction[0]), new BWVariable[0]);
        scope.registerVariable(new BWVariable("testVar", new BWInteger(1)));
        assertEquals(0, Program.getInstance().getVariables().length);
        assertEquals(1, scope.getCurrentObject().getVariables().length);
        assertEquals(scope.getCurrentObject().getVariables()[0].getName(), "testVar");
        assertEquals(scope.getCurrentObject().getVariables()[0].getIntValue(), 1);
    }

    @Test
    public void testGetVariable() throws Exception {
        Program.getInstance().setVariables(new BWVariable[]{
                new BWVariable("abc", new BWInteger(1)),
                new BWVariable("def", new BWString("2"))
        });
        Scope scope = new Scope(null, new BWVariable[0]);
        assertEquals(1, scope.getVariable("abc").getIntValue());
        assertEquals("2", ((BWString) (scope.getVariable("def").getValue())).getStringValue());

        scope = new Scope(new BWObject(new BWClass("test", new AbstractFunction[0]), new BWVariable[]{
                    new BWVariable("abc", new BWInteger(3))
        }, new BWObjectFunction[0]), new BWVariable[0]);
        assertEquals(3, scope.getVariable("abc").getIntValue());
        assertEquals("2", ((BWString) (scope.getVariable("def").getValue())).getStringValue());
    }
}