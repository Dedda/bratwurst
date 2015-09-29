package org.dedda.bratwurst.lang;

import com.sun.org.apache.xpath.internal.operations.Variable;

import java.util.HashMap;

/**
 * Created by dedda on 29.09.15.
 *
 * @author dedda
 */
public class BWVariableCache {

    private HashMap<String, BWVariable> variables;

    public BWVariableCache() {
        this.variables = new HashMap<>();
    }

    public void setVariable(String name, BWObject object) {
        if (this.variables.containsKey(name)) {
            this.variables.get(name).setValue(object);
        } else {
            this.variables.put(name, new BWVariable(name, object));
        }
    }

    public BWVariable getVariable(String name) {
        if (this.variables.containsKey(name)) {
            return this.variables.get(name);
        }
        return null;
    }

    public BWObject getObject(String varName) {
        BWVariable variable = this.getVariable(varName);
        if (variable != null) {
            return variable.getValue();
        }
        return null;
    }
}
