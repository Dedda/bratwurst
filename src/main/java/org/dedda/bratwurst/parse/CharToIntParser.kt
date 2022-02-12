package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.CharToInt

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
class CharToIntParser : ExpressionParser() {
    override fun parse(data: String, lineNumber: Int): CharToInt {
        val varname = data.split(" ".toRegex()).toTypedArray()[1]
        return CharToInt(lineNumber, varname)
    }
}