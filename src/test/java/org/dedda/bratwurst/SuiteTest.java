package org.dedda.bratwurst;

import org.dedda.bratwurst.test.TestSuite;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created by dedda on 1/24/16.
 *
 * @author dedda
 */
public class SuiteTest {

    @Test
    public void testSuite() {
        TestSuite testSuite = new TestSuite("src/test/testSuite.bw");
        boolean success = testSuite.run();
        assertTrue("Test suite failed!", success);
    }

}
