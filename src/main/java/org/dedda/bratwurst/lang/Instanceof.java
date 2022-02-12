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
    public void run(final Scope scope) {
        expression.run(scope);
        final BWObject value = expression.getValue();
        final ValueType type = value.getValueType();
        if (type.equals(ValueType.OBJECT)) {
            final String objectClassName = value.getBwClass().getName();
            isInstance = objectClassName.equals(this.className);
        } else {
            isInstance = type.getValue().equals(this.className);
        }
    }
}
