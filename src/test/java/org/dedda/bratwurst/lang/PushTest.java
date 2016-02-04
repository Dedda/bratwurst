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
public class PushTest {

    private Scope scope = null;

    @Before
    public void setUp() throws Exception {
        Program program = new Program();
        scope = new Scope(program);
    }

    @Test
    public void testRun() throws Exception {
        BWObject expression = new BWInteger(123);
        Push push = new Push(0, expression);
        push.run(scope);
        assertEquals(expression, scope.getProgram().pop());
    }
}