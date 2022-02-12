package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.BWString

/**
 * Created by dedda on 12/10/15.
 *
 * @author dedda
 */
class StringParser : ExpressionParser() {
    override fun parse(data: String, lineNumber: Int): BWString? {
        if (data.matches(PATTERN)) {
            val message = data.substring(1, data.length - 1)
            return BWString(message)
        }
        return null
    }

    companion object {
        private val PATTERN = Regex(Patterns.BW_STRING)
    }
}