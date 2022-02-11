package org.dedda.bratwurst.lang.assertions

import org.dedda.bratwurst.lang.BWInstruction
import org.dedda.bratwurst.lang.scope.Scope
import org.dedda.bratwurst.test.AssertionResult

abstract class Assertion(lineNumber: Int): BWInstruction(lineNumber) {

    override fun run(scope: Scope) {
        if (!scope.isInTest) {
            return
        }
        val testFileRunner = scope.testFileRunner
        testFileRunner.incAssertions()
        val result = doAssertion(scope)
        scope.testFunctionRunner.addAssertionResult(result)
    }

    abstract fun doAssertion(scope: Scope): AssertionResult

}