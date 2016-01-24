package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.scope.Scope;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dedda on 12/17/15.
 *
 * @author dedda
 */
public class ObjectCreationTest extends BratwurtstTestcase {

    private Scope scope;

    public void setUp() throws Exception {
        Program program = new Program();
        program.registerClass(new BWClass("testClass", new BWFunction[]{}));
        scope = new Scope(program);
    }

    @Test
    public void testRun() throws Exception {
        ObjectCreation objectCreation = new ObjectCreation(0, "testClass");
        objectCreation.run(scope);
        BWObject object = objectCreation.getValue();
        assertEquals("object", object.getValueType());
        assertEquals("testClass", object.getBwClass().name);
    }
}