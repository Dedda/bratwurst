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
public class PopTest {

    private Scope scope;

    @BeforeMethod
    public void setUp() throws Exception {
        BWObject object;
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