package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.Return

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
class ReturnParser : InstructionParser() {
    override fun parse(line: String, lineNumber: Int): Return {
        return Return(lineNumber, ExpressionParser().parse(line.substring(0, line.length - 4), lineNumber))
    }
}