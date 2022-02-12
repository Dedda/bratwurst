package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.classes.BWClass
import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
open class BWObject(val bwClass: BWClass) : BWExpression(0) {
    val functions: Array<BWFunction> = bwClass.functions
    private val variables: MutableList<BWVariable> = ArrayList()

    fun getVariables(): List<BWVariable> {
        return variables
    }

    fun addVariable(variable: BWVariable) {
        val variableOptional = variables.stream().filter { v: BWVariable -> v.name == variable.name }.findFirst()
        if (variableOptional.isPresent) {
            variableOptional.get().value = variable.value
        } else {
            variables.add(variable)
        }
    }

    override fun getValue(): BWObject {
        return this
    }

    override fun getIntValue(): Int {
        return 0
    }

    override fun getValueType(): ValueType {
        return ValueType.OBJECT
    }

    override fun run(scope: Scope) {}
}