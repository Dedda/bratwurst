package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
class Return(lineNumber: Int, private val expression: BWExpression) : BWExpression(lineNumber) {
    private var value: BWObject? = null
    override fun getValue(): BWObject {
        return value!!
    }

    override fun getIntValue(): Int {
        return value!!.intValue
    }

    override fun getValueType(): String {
        return value!!.valueType
    }

    override fun run(scope: Scope) {
        expression.run(scope)
        value = expression.value
    }

}