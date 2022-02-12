package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.StringGetChar

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
class StringGetCharParser : ExpressionParser() {
    override fun parse(data: String, lineNumber: Int): StringGetChar {
        val split = data.split("}".toRegex()).toTypedArray()
        val varName = split[0].substring(1)
        val location = split[1].substring(0, split[1].length - 1)
        return StringGetChar(lineNumber, location, varName)
    }
}