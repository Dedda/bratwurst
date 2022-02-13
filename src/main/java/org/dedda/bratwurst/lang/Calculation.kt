package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.calculate.operationForChar
import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
class Calculation(lineNumber: Int, val leftSide: BWExpression, val rightSide: BWExpression, val operator: Char) :
    BWExpression(lineNumber) {

    private var value = 0
    override fun getValue(): BWObject {
        return BWInteger(value)
    }

    override fun getIntValue(): Int {
        return value
    }

    override fun getValueType(): ValueType {
        return ValueType.INTEGER
    }

    override fun run(scope: Scope) {
        leftSide.run(scope)
        val left = leftSide.intValue
        rightSide.run(scope)
        val right = rightSide.intValue
        value = operationForChar(operator)(left, right)
    }
}