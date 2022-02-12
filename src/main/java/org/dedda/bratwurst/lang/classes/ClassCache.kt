package org.dedda.bratwurst.lang.classes

class ClassCache {

    private val classes = HashMap<String, BWClass>()

    fun hasClass(name: String) = classes.containsKey(name)

    fun addClass(bwClass: BWClass) {
        classes[bwClass.name] = bwClass
    }

    fun classByName(name: String): BWClass {
        var found = classes[name]
        if (found == null) {
            found = BWClass(name, emptyArray())
            classes[name] = found
        }
        return found
    }

    fun clear() = classes.clear()
}