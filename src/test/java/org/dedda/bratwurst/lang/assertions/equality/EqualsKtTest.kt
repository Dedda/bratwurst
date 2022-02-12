package org.dedda.bratwurst.lang.assertions.equality

import org.dedda.bratwurst.lang.BWInteger
import org.dedda.bratwurst.lang.BWObject
import org.dedda.bratwurst.lang.BWString
import org.dedda.bratwurst.lang.classes.BWClass
import org.testng.Assert
import org.testng.annotations.Test

class EqualsKtTest {
    @Test
    @Throws(Exception::class)
    fun testAssertEqualsInteger() {
        val equalityTest = equalityTestFor(BWInteger(123))
        Assert.assertTrue(equalityTest(BWInteger(123)))
        Assert.assertFalse(equalityTest(BWInteger(321)))
    }

    @Test
    @Throws(Exception::class)
    fun testAssertEqualsString() {
        val equalityTest = equalityTestFor(BWString("test"))
        Assert.assertTrue(equalityTest(BWString("test")))
        Assert.assertFalse(equalityTest(BWString("tset")))
    }

    @Test
    @Throws(Exception::class)
    fun testAssertEqualsObject() {
        val equalityTest = equalityTestFor(BWObject(BWClass.getClassForName("testClass")))
        Assert.assertTrue(equalityTest(BWObject(BWClass.getClassForName("testClass"))))
        Assert.assertFalse(equalityTest(BWObject(BWClass.getClassForName("testClass2"))))
    }
}

