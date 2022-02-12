package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.BWInteger

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
class IntegerParser : ExpressionParser() {
    override fun parse(data: String, lineNumber: Int): BWInteger {
        return BWInteger(data.trim().toInt())
    }
}