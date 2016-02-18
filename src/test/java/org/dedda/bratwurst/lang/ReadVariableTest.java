package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by dedda on 12/17/15.
 *
 * @author dedda
 */
public class ReadVariableTest {

    private Scope scope;

    @BeforeMethod
    public void setUp() throws Exception {
        Program program = new Program();
        scope = new Scope(program);
        scope.setVariable(new BWVariable("abc", new BWInteger(123)));
    }

    @Test
    public void testRun() throws Exception {
        ReadVariable readVariable = new ReadVariable(0, "abc");
        readVariable.run(scope);
        BWObject variable = readVariable.getValue();
        assertEquals(123, variable.getIntValue());
    }
}