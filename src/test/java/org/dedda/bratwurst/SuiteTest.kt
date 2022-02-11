package org.dedda.bratwurst

import org.dedda.bratwurst.test.TestSuite
import org.testng.AssertJUnit
import org.testng.annotations.Test

/**
 * Created by dedda on 1/24/16.
 *
 * @author dedda
 */
class SuiteTest {
    @Test
    fun testSuite() {
        val testSuite = TestSuite("src/test/testSuite.bw")
        val success = testSuite.run()
        AssertJUnit.assertTrue("Test suite failed!", success)
    }
}