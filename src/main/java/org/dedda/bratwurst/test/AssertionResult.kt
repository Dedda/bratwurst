package org.dedda.bratwurst.test

sealed class AssertionResult {

    abstract fun wasSuccessful(): Boolean

}

object AssertionSuccess : AssertionResult() {
    override fun wasSuccessful() = true
}

class AssertionError(val message: String) : AssertionResult() {
    override fun wasSuccessful() = false
}