package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class Scope {

    private BWObject currentObject;
    private BWVariable[] arguments;

    public Scope(BWObject currentObject, BWVariable[] arguments) {
        this.currentObject = currentObject;
        this.arguments = arguments;
    }

    public BWObject getCurrentObject() {
        return currentObject;
    }

    public boolean isInObject() {
        return currentObject != null;
    }

    public BWVariable[] getArguments() {
        return arguments;
    }
}
