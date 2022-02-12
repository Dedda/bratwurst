package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.VariableDeclaration

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
class VariableDeclarationParser : InstructionParser() {
    fun parseDeclaration(line: String, lineNumber: Int): VariableDeclaration {
        val split = line.split(" ", limit = 3).toTypedArray()
        val variableName = split[0].substring(1, split[0].length - 1)
        val expressionString = split[2]
        val expression = ExpressionParser().parse(expressionString, lineNumber)
        return VariableDeclaration(lineNumber, variableName, expression)
    }
}