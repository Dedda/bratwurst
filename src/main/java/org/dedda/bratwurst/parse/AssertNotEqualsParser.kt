package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.assertions.AssertNotEquals

/**
 * Created by dedda on 1/23/16.
 *
 * @author dedda
 */
class AssertNotEqualsParser {
    fun parse(line: String, lineNumber: Int): AssertNotEquals {
        val split = line.split(" ").toTypedArray()
        val varName1 = split[0].substring(2)
        val varName2 = split[2].substring(0, split[2].length - 2)
        return AssertNotEquals(lineNumber, varName1, varName2)
    }
}