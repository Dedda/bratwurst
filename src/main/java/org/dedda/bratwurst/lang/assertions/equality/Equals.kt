package org.dedda.bratwurst.lang.assertions.equality

import org.dedda.bratwurst.lang.BWInteger
import org.dedda.bratwurst.lang.BWObject
import org.dedda.bratwurst.lang.BWString

typealias EqualsFun = (BWObject) -> Boolean

fun equalityTestFor(variable: BWObject): EqualsFun {
    return when (variable) {
        is BWInteger -> testIntEquality(variable)
        is BWString -> testStringEquality(variable)
        else -> testObjectTypeEquality(variable)
    }
}

fun testIntEquality(variable: BWInteger): EqualsFun {
    return fun(other: BWObject): Boolean {
        return variable.intValue == other.intValue
    }
}

fun testStringEquality(variable: BWString): EqualsFun {
    return fun(other: BWObject): Boolean {
        return variable.stringValue == (other as BWString).stringValue
    }
}

fun testObjectTypeEquality(variable: BWObject): EqualsFun {
    return fun(other: BWObject): Boolean {
        return variable.bwClass.name == other.bwClass.name
    }
}

