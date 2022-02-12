package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.LengthGet

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
class LengthGetParser : ExpressionParser() {
    override fun parse(data: String, lineNumber: Int): LengthGet {
        val varName = data.substring(2, data.length - 2)
        return LengthGet(lineNumber, varName)
    }
}