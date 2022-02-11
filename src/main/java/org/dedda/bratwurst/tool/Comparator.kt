package org.dedda.bratwurst.tool

import org.dedda.bratwurst.lang.BWObject

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
interface Comparator<T : BWObject?> {
    fun compare(obj1: T, obj2: T): Boolean
}