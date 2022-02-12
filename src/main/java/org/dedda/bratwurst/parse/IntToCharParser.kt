package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.IntToChar

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
class IntToCharParser : ExpressionParser() {
    override fun parse(data: String, lineNumber: Int): IntToChar {
        val varname = data.split(" ".toRegex()).toTypedArray()[1]
        return IntToChar(lineNumber, varname)
    }
}