package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.Instanceof

/**
 * Created by dedda on 12/9/15.
 *
 * @author dedda
 */
class InstanceofParser : ExpressionParser() {
    override fun parse(line: String, lineNumber: Int): Instanceof? {
        if (line.matches(Regex(Patterns.TYPE_CHECK))) {
            val parts = line.split(" ".toRegex()).toTypedArray()
            val expression = ExpressionParser().parse(parts[0], lineNumber)
            val className = parts[2]
            return Instanceof(lineNumber, expression, className)
        }
        return null
    }
}