package org.dedda.bratwurst.lang.classes

import org.dedda.bratwurst.lang.BWFunction
import org.dedda.bratwurst.lang.BWObject

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
class BWClass(val name: String, val functions: Array<BWFunction>) {
    init {
        if (cache.hasClass(name)) {
            throw RuntimeException("class $name already registered")
        }
        cache.addClass(this)
    }

    fun createInstance(): BWObject {
        return BWObject(this)
    }

    companion object {
        private val cache = ClassCache()

        @JvmStatic
        fun getClassForName(name: String?): BWClass {
            return cache.classByName(name!!)
        }

        @JvmStatic
        fun unregisterAll() {
            cache.clear()
        }
    }
}