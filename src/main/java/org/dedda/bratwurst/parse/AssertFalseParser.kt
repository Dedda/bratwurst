package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.assertions.AssertFalse

/**
 * Created by dedda on 1/23/16.
 *
 * @author dedda
 */
class AssertFalseParser {
    fun parse(line: String, lineNumber: Int): AssertFalse {
        val varName = line.substring(3, line.length - 2)
        return AssertFalse(lineNumber, varName)
    }
}