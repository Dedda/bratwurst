package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class ObjectCreation extends BWExpression {

    private final String className;
    private BWObject object = new BWInteger(0);

    public ObjectCreation(int lineNumber, String className) {
        super(lineNumber);
        this.className = className;
    }

    @Override
    public BWObject getValue() {
        return object;
    }

    @Override
    public int getIntValue() {
        return object.getIntValue();
    }

    @Override
    public String getValueType() {
        return object.getValueType();
    }

    @Override
    public void run(Scope scope) {
        BWClass bwClass = BWClass.getClassForName(className);
        object = bwClass.createInstance();
    }
}
