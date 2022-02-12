package org.dedda.bratwurst.test

import java.io.File

/**
 * Created by dedda on 1/24/16.
 *
 * @author dedda
 */
class TestSuite(suiteFile: String?) {
    private var testFiles: MutableList<String>

    init {
        val file = File(suiteFile!!)
        if (!file.exists()) {
            throw RuntimeException("suite file not found!")
        }
        testFiles = ArrayList()
        file.readLines().map { file.parent + "/" + it }.forEach { testFiles.add(it) }
    }

    fun run(): Boolean {
        var success = true
        var assertions = 0
        println("Running test suite with test files: ")
        testFiles.map { " - $it" }.forEach { println(it) }
        testFiles.forEach { file ->
            val runner = TestFileRunner(file)
            runner.run()
            assertions += runner.allAssertions
            if (!runner.wasSuccessful()) {
                success = false
            }
        }
        println("======================================")
        println("$assertions assertions in test suite")
        if (!success) {
            println("failures!")
        }
        return success
    }
}