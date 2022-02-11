package org.dedda.bratwurst.lang

enum class ValueType(val value: String) {

    INTEGER("integer"),
    STRING("string"),
    OBJECT("object"),
    ;

    companion object {
        private val map = ValueType.values().associateBy(ValueType::value)
        fun fromString(value: String) = map[value]
    }

}