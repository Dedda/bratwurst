package org.dedda.bratwurst.lang.scope

import org.dedda.bratwurst.lang.BWFunction
import org.dedda.bratwurst.lang.BWObject
import org.dedda.bratwurst.lang.BWVariable
import java.util.*

/**
 * Created by dedda on 11/9/15.
 *
 * @author dedda
 */
class StackElement(val obj: BWObject?, val function: BWFunction, variables: MutableList<BWVariable>?) {

    private val functionVars: MutableList<BWVariable> = variables ?: ArrayList()

    fun getVariable(name: String): BWVariable? {
        val localOpt = functionVars.stream().filter { v: BWVariable -> v.name == name }.findFirst()
        if (localOpt.isPresent) {
            return localOpt.get()
        }
        val objectOpt: Optional<BWVariable>
        if (obj != null) {
            objectOpt = listOf(*obj.variables).stream().filter { v: BWVariable -> v.name == name }.findFirst()
            return if (objectOpt.isPresent) objectOpt.get() else null
        }
        return null
    }

    fun setFunctionVar(variable: BWVariable) {
        val local = getVariable(variable.name)
        if (local == null) {
            functionVars.add(variable)
        } else {
            local.value = variable.value
        }
    }

    fun getFunctionVars(): List<BWVariable> {
        return functionVars
    }

}