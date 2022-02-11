package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.ValueType.STRING

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
class BWString(val stringValue: String) : BWObject(BWClass.getClassForName("string")) {

    override fun getValueType() = STRING

    override fun getIntValue(): Int {
        return if (stringValue.matches(Regex("-?\\d+"))) {
            stringValue.toInt()
        } else 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val bwString = other as BWString
        return stringValue == bwString.stringValue
    }

    override fun hashCode(): Int {
        return stringValue.hashCode()
    }

}