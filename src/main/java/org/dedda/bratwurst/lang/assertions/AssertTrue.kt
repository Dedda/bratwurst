package org.dedda.bratwurst.lang.assertions

import org.dedda.bratwurst.lang.BWInteger
import org.dedda.bratwurst.lang.scope.Scope
import org.dedda.bratwurst.test.AssertionError
import org.dedda.bratwurst.test.AssertionResult
import org.dedda.bratwurst.test.AssertionSuccess

/**
 * Created by dedda on 1/23/16.
 *
 * @author dedda
 */
class AssertTrue(lineNumber: Int, private val variableName: String) : Assertion(lineNumber) {

    override fun doAssertion(scope: Scope): AssertionResult {
        val `var` = scope.getVariable(variableName)
        var message: String? = null
        if (`var`.value !is BWInteger) {
            message = "variable is not a number!"
        } else if (`var`.intValue == 0) {
            message = "variable is false!"
        }
        if (message != null) {
            message = "ERROR asserting variable is true --> $lineNumber: $message"
            return AssertionError(message)
        }
        return AssertionSuccess
    }

}