package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dedda on 12/17/15.
 *
 * @author dedda
 */
public class PopTest {

    private Scope scope;
    private BWObject object;

    @Before
    public void setUp() throws Exception {
        object = new BWInteger(312);
        Program program = new Program();
        program.push(object);
        scope = new Scope(program);
    }

    @Test
    public void testRun() throws Exception {
        Pop pop = new Pop(0, "abc");
        pop.run(scope);
        BWVariable variable = scope.getVariable("abc");
        assertEquals(312, variable.getIntValue());
    }
}