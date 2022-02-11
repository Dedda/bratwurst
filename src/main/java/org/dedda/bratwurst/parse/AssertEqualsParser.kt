package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.assertions.AssertEquals

/**
 * Created by dedda on 1/23/16.
 *
 * @author dedda
 */
class AssertEqualsParser {
    fun parse(line: String, lineNumber: Int): AssertEquals {
        val split = line.split(" ").toTypedArray()
        val varName1 = split[0].substring(2)
        val varName2 = split[2].substring(0, split[2].length - 2)
        return AssertEquals(lineNumber, varName1, varName2)
    }
}