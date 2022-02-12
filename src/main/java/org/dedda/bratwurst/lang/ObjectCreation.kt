package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.classes.BWClass
import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
class ObjectCreation(lineNumber: Int, private val className: String) : BWExpression(lineNumber) {
    private var obj: BWObject = BWInteger(0)
    override fun getValue(): BWObject {
        return obj
    }

    override fun getIntValue(): Int {
        return obj.intValue
    }

    override fun getValueType() = obj.valueType

    override fun run(scope: Scope) {
        val bwClass = BWClass.getClassForName(className)
        obj = bwClass.createInstance()
    }

}