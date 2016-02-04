package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dedda on 12/17/15.
 *
 * @author dedda
 */
public class ReadVariableTest {

    private Scope scope;

    @Before
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