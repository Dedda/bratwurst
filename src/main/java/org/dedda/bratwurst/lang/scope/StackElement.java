package org.dedda.bratwurst.lang.scope;

import org.dedda.bratwurst.lang.BWFunction;
import org.dedda.bratwurst.lang.BWObject;
import org.dedda.bratwurst.lang.BWVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by dedda on 11/9/15.
 *
 * @author dedda
 */
public class StackElement {

    private BWObject object;
    private BWFunction function;
    private List<BWVariable> functionVars;

    protected StackElement(BWObject object, BWFunction function, List<BWVariable> variables) {
        this.object = object;
        this.function = function;
        this.functionVars = variables != null ? variables : new ArrayList<>();
    }

    public BWVariable getVariable(String name) {
        Optional<BWVariable> localOpt = functionVars.stream().filter(v -> v.getName().equals(name)).findFirst();
        if (localOpt.isPresent()) {
            return localOpt.get();
        }
        Optional<BWVariable> objectOpt = Arrays.asList(object.getVariables()).stream().filter(v -> v.getName().equals(name)).findFirst();
        return objectOpt.isPresent() ? objectOpt.get() : null;
    }

    public void setFunctionVar(BWVariable variable) {
        BWVariable local = getVariable(variable.getName());
        if (local == null) {
            functionVars.add(variable);
        } else {
            local.setValue(variable.getValue());
        }
    }

    public BWObject getObject() {
        return object;
    }

    public BWFunction getFunction() {
        return function;
    }

    public List<BWVariable> getFunctionVars() {
        return functionVars;
    }
}
