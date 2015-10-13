package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 13.10.15.
 *
 * @author dedda
 */
public abstract class AbstractFunction implements BWExpression {

    protected BWObject value;

    public BWObject getValue() {
        run();
        return value;
    }

    public int getIntValue() {
        run();
        return value.getBwClass().getName().equals("integer") ? value.getIntValue() : 0;
    }

    protected abstract void run();

    protected abstract BWObject getObject();

}
