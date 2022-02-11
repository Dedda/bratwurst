package org.dedda.bratwurst.lang.assertions

import org.dedda.bratwurst.lang.BWInteger
import org.dedda.bratwurst.lang.BWObject
import org.dedda.bratwurst.lang.BWString
import org.dedda.bratwurst.lang.assertions.equality.equalityTestFor
import org.dedda.bratwurst.lang.scope.Scope
import org.dedda.bratwurst.test.AssertionError
import org.dedda.bratwurst.test.AssertionResult
import org.dedda.bratwurst.test.AssertionSuccess

/**
 * Created by dedda on 1/23/16.
 *
 * @author dedda
 */
class AssertNotEquals(lineNumber: Int, private val variableNameLeft: String, private val variableNameRight: String) : Assertion(lineNumber) {

    override fun doAssertion(scope: Scope): AssertionResult {
        val left = scope.getVariable(variableNameLeft).value
        val right = scope.getVariable(variableNameRight).value
        var message: String? = null
        if (left.javaClass != right.javaClass) {
            return AssertionSuccess
        } else {
            val equal = equalityTestFor(left)(right)
            if (equal) {
                when (left) {
                    is BWInteger -> {
                        message = "Integers ($left) and ($right) equal!"
                    }
                    is BWString -> {
                        message = ("Strings (${left.stringValue}) and (${(right as BWString).stringValue}) equal!")
                    }
                    is BWObject -> {
                        message = "Objects of equal type!"
                    }
                }
            }
        }
        if (message != null) {
            message = "ERROR asserting two variables are equal --> $lineNumber: $message"
            return AssertionError(message)
        }
        return AssertionSuccess
    }
}