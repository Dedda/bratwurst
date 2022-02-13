package org.dedda.bratwurst.test

import org.dedda.bratwurst.lang.BWFunction
import org.dedda.bratwurst.lang.Program
import org.dedda.bratwurst.lang.classes.BWClass.Companion.unregisterAll
import org.dedda.bratwurst.parse.Parser
import java.io.File
import java.util.stream.Collectors

/**
 * Created by dedda on 1/23/16.
 *
 * @author dedda
 */
class TestFileRunner(private val fileName: String) {

    private var assertions = 0
    var allAssertions = 0
        private set
    private var stop = false
    private var finished = false
    private val isTestFunction: (BWFunction) -> Boolean = { function -> function.name.startsWith("test") }

    fun run() {
        unregisterAll()
        val functions = loadProgram(fileName).functions
        val testFunctions = functions.stream()
            .filter(isTestFunction)
            .collect(Collectors.toList())
        println("\n${testFunctions.size} test functions found in file$fileName\n")
        for (function in testFunctions) {
            assertions = 0
            println("running " + function.name + ":")
            TestFunctionRunner(this).run(fileName, function.name)
            if (stop) {
                break
            }
            println(" [$assertions] assertions.")
        }
        println("\n$allAssertions assertions in file $fileName")
        if (stop) {
            println("failures!")
        }
        println("--------------------------------------")
        finished = true
    }

    fun incrementAssertions() {
        assertions++
        allAssertions++
    }

    fun stop() {
        stop = true
    }

    fun wasSuccessful(): Boolean {
        if (!finished) {
            throw RuntimeException("Test still running!")
        }
        return !stop
    }

    private fun loadProgram(fileName: String): Program {
        val file = File(fileName)
        val parser = Parser(file)
        return parser.parse()
    }
}