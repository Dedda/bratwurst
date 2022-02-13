package org.dedda.bratwurst.test

import org.dedda.bratwurst.lang.classes.BWClass
import org.dedda.bratwurst.lang.scope.Scope
import org.dedda.bratwurst.parse.Parser
import java.io.File

/**
 * Created by dedda on 1/23/16.
 *
 * @author dedda
 */
class TestFunctionRunner(private val runner: TestFileRunner) {

    fun run(filename: String, functionName: String) {
        BWClass.unregisterAll()
        val parser = Parser(File(filename))
        val program = parser.parse()
        val functionOptional = program.functions.stream()
            .filter { f -> f.name == functionName }
            .findFirst()
        if (!functionOptional.isPresent) {
            fail("Function " + functionName + "doesn't exist!")
        }
        val function = functionOptional.get()
        val scope = Scope(program, runner, this)
        function.run(scope)
    }

    fun addAssertionResult(result: AssertionResult) {
        runner.incrementAssertions()
        when (result) {
            is AssertionSuccess -> print(".")
            is AssertionError -> fail(result.message)
        }
    }

    private fun fail(message: String) {
        println(message)
        runner.stop()
    }
}