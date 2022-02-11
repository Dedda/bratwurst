package org.dedda.bratwurst

import org.dedda.bratwurst.parse.Parser
import org.dedda.bratwurst.test.TestSuite
import java.io.File

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        if (isTestMode(args)) {
            val testSuiteFile = getTestSuite(args)
            val testSuite = TestSuite(testSuiteFile)
            testSuite.run()
        } else {
            if (args.size != 1) {
                throw RuntimeException("No program file given!")
            }
            val fileName = args[0]
            val file = File(fileName)
            if (!file.exists()) {
                throw RuntimeException("Cannot find file!")
            }
            val parser = Parser(file)
            val program = parser.parse()
            program.run()
            val exitCode = program.exitCode
            println("Program exited with code $exitCode")
        }
    }

    private fun isTestMode(args: Array<String>): Boolean {
        for (arg in args) {
            if (arg == "-t") {
                return true
            }
        }
        return false
    }

    private fun getTestSuite(args: Array<String>): String? {
        for (i in 0 until args.size - 1) {
            if (args[i] == "--test-suite") {
                return args[i + 1]
            }
        }
        return null
    }
}