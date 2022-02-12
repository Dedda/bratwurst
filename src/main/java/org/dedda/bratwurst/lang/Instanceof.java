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
    public ValueType getValueType() {
        return ValueType.INTEGER;
    }

    @Override
    public void run(Scope scope) {
        expression.run(scope);
        final BWObject var = expression.getValue();
        final ValueType type = var.getValueType();
        if (type.equals(ValueType.OBJECT)) {
            String className = var.getBwClass().getName();
            isInstance = className.equals(this.className);
        } else {
            isInstance = type.getValue().equals(this.className);
        }
    }
}
