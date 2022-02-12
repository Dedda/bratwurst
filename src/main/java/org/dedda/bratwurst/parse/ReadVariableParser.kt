package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.ReadVariable

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
class ReadVariableParser : ExpressionParser() {
    override fun parse(data: String, lineNumber: Int): ReadVariable {
        return ReadVariable(lineNumber, data.trim())
    }
}