package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.ScopedTestCase;
import org.dedda.bratwurst.lang.scope.Scope;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dedda on 12/17/15.
 *
 * @author dedda
 */
public class ExitTest extends ScopedTestCase {

    private Scope scope;

    public void setUp() throws Exception {
        scope = createEmptyScope();
        scope.getProgram().run();
    }

    @Test
    public void testRun() throws Exception {
        Exit exit = new Exit(0);
        assertFalse(scope.getProgram().isStopped());
        exit.run(scope);
        assertTrue(scope.getProgram().isStopped());
    }
}