package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.ValueType.INTEGER
import org.dedda.bratwurst.lang.classes.BWClass

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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val bwInteger = other as BWInteger
        return value == bwInteger.value
    }

}