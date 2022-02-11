package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.assertions.AssertTrue

/**
 * Created by dedda on 1/23/16.
 *
 * @author dedda
 */
class AssertTrueParser {
    fun parse(line: String, lineNumber: Int): AssertTrue {
        val varName = line.substring(2, line.length - 2)
        return AssertTrue(lineNumber, varName)
    }
}