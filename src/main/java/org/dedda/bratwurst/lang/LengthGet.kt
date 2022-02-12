package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.ValueType.INTEGER
import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
class LengthGet(lineNumber: Int, private val varName: String) : BWExpression(lineNumber) {
    private var value = 0
    override fun getValue(): BWObject {
        return BWInteger(value)
    }

    override fun getIntValue(): Int {
        return value
    }

    override fun getValueType() = INTEGER

    override fun run(scope: Scope) {
        val variable = scope.getVariable(varName)
        value = if (variable.value is BWString) {
            (variable.value as BWString).stringValue.length
        } else {
            throw RuntimeException("variable not of type string!")
        }
    }

}