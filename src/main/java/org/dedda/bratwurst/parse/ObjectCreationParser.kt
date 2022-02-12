package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.ObjectCreation

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
class ObjectCreationParser : ExpressionParser() {
    override fun parse(line: String, lineNumber: Int): ObjectCreation {
        val trimmed = line.trim()
        return ObjectCreation(lineNumber, trimmed.substring(1, trimmed.length - 1))
    }
}