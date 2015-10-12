package org.dedda.bratwurst.lang.cache;

import org.dedda.bratwurst.lang.function.BWFunction;

import java.util.HashMap;

/**
 * Created by dedda on 29.09.15.
 *
 * @author dedda
 */
public class BWFunctionCache {

    private HashMap<String, BWFunction> functions;

    public BWFunctionCache() {
        this.functions = new HashMap<>();
    }

    public void putFunction(String name, BWFunction function) {
        this.functions.put(name, function);
    }

    public BWFunction getFunction(String name) {
        if (this.functions.containsKey(name)) {
            return this.functions.get(name);
        }
        return null;
    }

}
