package org.dedda.bratwurst.lang;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class BWClass {

    private static List<BWClass> classes = new ArrayList<>();

    public final String name;
    public final AbstractFunction[] functions;
    public AbstractVariable[] variables;

    public BWClass(String name, AbstractFunction[] functions) {
        this.name = name;
        this.functions = functions;
        if (classes.stream().filter(c -> c.name.equals(this.name)).findAny().isPresent()) {
            throw new RuntimeException("class already registered");
        }
        classes.add(this);
    }

    public BWObject createInstance() {
        BWObjectFunction[] functions = new BWObjectFunction[this.functions.length];
        BWVariable[] variables = new BWVariable[this.variables.length];
        //TODO: init functions and variables
        BWObject object = new BWObject(this, variables, functions);
        for (int i = 0; i < functions.length; i++) {
            functions[i] = this.functions[i].createObjectFunction(object);
        }
        for (int i  = 0; i < variables.length; i++) {
            variables[i] = this.variables[i].getVariable(new Scope(object, new BWVariable[0]));
        }
        object.setFunctions(functions);
        object.setVariables(variables);
        return object;
    }

}
