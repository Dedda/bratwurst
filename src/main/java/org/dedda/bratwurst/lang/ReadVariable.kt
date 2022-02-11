package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
class ReadVariable(lineNumber: Int, private val variableName: String) : BWExpression(lineNumber) {
    private var value: BWObject = BWInteger(0)
    override fun getValue(): BWObject {
        return value
    }

    override fun getIntValue(): Int {
        return value.intValue
    }

    override fun getValueType(): String {
        return value.valueType
    }

    override fun run(scope: Scope) {
        val variable = scope.getVariable(variableName)
        value = if (variable != null) {
            variable.value
        } else {
            throw RuntimeException("Variable $variableName is not defined!")
        }
    }

}