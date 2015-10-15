package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public abstract class AbstractFunction {

    private String name;
    private String scope;

    public BWFunction createFunction() {
        BWFunction function = new BWFunction(name, getInstructions());
        return function;
    }

    public BWObjectFunction createObjectFunction(final BWObject object) {
        BWObjectFunction function = new BWObjectFunction(name, getInstructions(), object);
        return function;
    }

    public String getName() {
        return name;
    }

    public String getScope() {
        return scope;
    }

    public abstract BWInstruction[] getInstructions();

}
