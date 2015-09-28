package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public abstract class BWVariable<T> implements BWExpression {

    protected String name;
    protected T value;
    protected String type = "null";

    public BWVariable(String name) {
        this.name = name;
    }

    public BWVariable(String name, T value, String type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public String getName() {
        return name;
    }
}
