package org.dedda.bratwurst.test

import org.dedda.bratwurst.lang.BWClass
import org.dedda.bratwurst.lang.BWFunction
import org.dedda.bratwurst.lang.scope.Scope
import org.dedda.bratwurst.parse.Parser
import java.io.File
import java.util.*

/**
 * Created by dedda on 1/23/16.
 *
 * @author dedda
 */
class TestFunctionRunner {

    private var runner: TestFileRunner? = null

    fun run(runner: TestFileRunner?, filename: String, functionName: String) {
        this.runner = runner
        BWClass.unregisterAll()
        val parser = Parser(File(filename))
        val program = parser.parse()
        val fopt = Arrays.stream(program.functions).filter { f: BWFunction -> f.name == functionName }.findFirst()
        if (!fopt.isPresent) {
            fail("Function " + functionName + "doesn't exist!")
        }
        val function = fopt.get()
        val scope = Scope(program, runner, this)
        function.run(scope)
    }

    fun addAssertionResult(result: AssertionResult) {
        runner!!.incAssertions()
        when (result) {
            is AssertionSuccess -> print(".")
            is AssertionError -> fail(result.message)
        }
    }

    fun fail(message: String) {
        println(message)
        runner!!.stop()
    }
}