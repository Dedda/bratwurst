package org.dedda.bratwurst.lang

import org.dedda.bratwurst.ScopedTestCase
import org.testng.Assert
import org.testng.annotations.Test

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
class StringConcatenationTest : ScopedTestCase() {
    @Test
    @Throws(Exception::class)
    fun testRun() {
        val scope = createEmptyScope()
        scope.setVariable(BWVariable("var1", BWString("Hello ")))
        scope.setVariable(BWVariable("var2", BWString("World")))
        scope.setVariable(BWVariable("var3", BWString("!")))
        scope.setVariable(BWVariable("var4", BWInteger(123)))
        val concatenation = StringConcatenation(0, arrayOf(
                "var1",
                "var2",
                "var3",
                "var4"
        ))
        val expected = "Hello World!123"
        concatenation.run(scope)
        val actual = (concatenation.value as BWString).stringValue
        Assert.assertEquals(expected, actual)
    }
}