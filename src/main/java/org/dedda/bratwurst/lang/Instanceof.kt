package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 12/9/15.
 *
 * @author dedda
 */
class Instanceof(lineNumber: Int, private val expression: BWExpression, val className: String) : BWExpression(lineNumber) {

    private var isInstance = false

    override fun getValue(): BWObject {
        return if (isInstance) BWInteger(1) else BWInteger(0)
    }

    override fun getIntValue(): Int {
        return value.intValue
    }

    override fun getValueType(): ValueType {
        return ValueType.INTEGER
    }

    override fun run(scope: Scope) {
        expression.run(scope)
        val value = expression.value
        val type = value.valueType
        isInstance = if (type == ValueType.OBJECT) {
            val objectClassName = value.bwClass.name
            objectClassName == className
        } else {
            type.value == className
        }
    }
}