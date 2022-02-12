package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.IntegerComparison

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
class IntegerComparisonParser : ExpressionParser() {
    override fun parse(data: String, lineNumber: Int): IntegerComparison {
        val split = data.split(" ".toRegex()).toTypedArray()
        val nameLeft = split[0]
        val nameRight = split[2]
        return IntegerComparison(lineNumber, nameLeft, nameRight)
    }
}