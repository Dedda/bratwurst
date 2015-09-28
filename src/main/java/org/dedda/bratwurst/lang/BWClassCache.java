package org.dedda.bratwurst.lang;

import java.util.HashMap;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
public class BWClassCache {

    private HashMap<String, BWClass> classes;

    public BWClassCache() {
        classes = new HashMap<>();
    }

    public void registerClass(BWClass bwClass) {
        if (classes.containsKey(bwClass.getName())) {
            throw new RuntimeException("class already registered");
        }
        classes.put(bwClass.getName(), bwClass);
    }

    public BWClass getBWClass(String name) {
        if (!classes.containsKey(name)) {
            throw new RuntimeException("unknown class");
        }
        return classes.get(name);
    }

}
