package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.Comparison

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
class ComparisonParser : ExpressionParser() {
    override fun parse(data: String, lineNumber: Int): Comparison {
        val split = data.split(" ".toRegex()).toTypedArray()
        val varName1 = split[0]
        val varName2 = split[2]
        return Comparison(lineNumber, varName1, varName2)
    }
}