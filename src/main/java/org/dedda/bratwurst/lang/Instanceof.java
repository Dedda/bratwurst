package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 12/9/15.
 *
 * @author dedda
 */
public class Instanceof extends BWExpression {

    private final BWExpression expression;
    public final String className;
    private boolean isInstance;

    public Instanceof(int lineNumber, BWExpression expression, String className) {
        super(lineNumber);
        this.expression = expression;
        this.className = className;
    }

    @Override
    public BWObject getValue() {
        return isInstance ? new BWInteger(1) : new BWInteger(0);
    }

    @Override
    public int getIntValue() {
        return getValue().getIntValue();
    }

    @Override
    public String getValueType() {
        return null;
    }

    @Override
    public void run(Scope scope) {
        expression.run(scope);
        BWObject var = expression.getValue();
        String type = var.getValueType();
        if (type.equals("object")) {
            String className = var.getBwClass().name;
            isInstance = className.equals(this.className);
        } else {
            isInstance = type.equals(this.className);
        }
    }
}
