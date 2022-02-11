package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.ValueType.INTEGER

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
open class BWInteger(private val value: Int) : BWObject(BWClass.getClassForName("integer")) {
    override fun getIntValue(): Int {
        return value
    }

    override fun getValueType() = INTEGER

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val bwInteger = o as BWInteger
        return value == bwInteger.value
    }

}