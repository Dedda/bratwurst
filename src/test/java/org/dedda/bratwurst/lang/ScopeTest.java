package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class ScopeTest {

    @Test
    public void testIsInObject() throws Exception {
        Scope scope = new Scope();
        assertFalse(scope.isInObject());
//        scope = new Scope(new BWObject(null, new BWFunction[0]));
        assertTrue(scope.isInObject());
    }

    @Test
    public void testRegisterVariable() throws Exception {
        Program.getInstance().setVariables(new ArrayList<>(Arrays.asList(new BWVariable[0])));
        Scope scope = new Scope();
        scope.setVariable(new BWVariable("testVar", new BWInteger(1)));
        assertEquals(1, Program.getInstance().getVariables().size());
        assertEquals(Program.getInstance().getVariables().get(0).getName(), "testVar");
        assertEquals(Program.getInstance().getVariables().get(0).getIntValue(), 1);

        Program.getInstance().setVariables(new ArrayList<>(Arrays.asList(new BWVariable[0])));
//        scope = new Scope(new BWObject(BWClass.getClassForName("testClass"), new BWFunction[0]));
        scope.setVariable(new BWVariable("testVar", new BWInteger(1)));
        assertEquals(0, Program.getInstance().getVariables().size());
        assertEquals(1, scope.getCurrentObject().getVariables().length);
        assertEquals(scope.getCurrentObject().getVariables()[0].getName(), "testVar");
        assertEquals(scope.getCurrentObject().getVariables()[0].getIntValue(), 1);
    }

    @Test
    public void testGetVariable() throws Exception {
        Program.getInstance().setVariables(new ArrayList<>(Arrays.asList(new BWVariable[]{
                new BWVariable("abc", new BWInteger(1)),
                new BWVariable("def", new BWString("2"))
        })));
        Scope scope = new Scope();
        assertEquals(1, scope.getVariable("abc").getIntValue());
        assertEquals("2", ((BWString) (scope.getVariable("def").getValue())).getStringValue());

//        scope = new Scope(new BWObject(BWClass.getClassForName("testClass"), new BWFunction[0]));
        scope.getCurrentObject().addVariable(new BWVariable("abc", new BWInteger(3)));
        assertEquals(3, scope.getVariable("abc").getIntValue());
        assertEquals("2", ((BWString) (scope.getVariable("def").getValue())).getStringValue());
    }
}