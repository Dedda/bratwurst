package org.dedda.bratwurst.lang

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
class BWString(val stringValue: String?) : BWObject(BWClass.getClassForName("string")) {

    override fun getValueType(): String {
        return "string"
    }

    override fun getIntValue(): Int {
        return if (stringValue!!.matches(Regex("\\-?\\d+"))) {
            stringValue.toInt()
        } else 0
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val bwString = o as BWString
        return !if (stringValue != null) stringValue != bwString.stringValue else bwString.stringValue != null
    }

}