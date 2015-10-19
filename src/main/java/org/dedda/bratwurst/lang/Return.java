package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class Return extends BWExpression {

    private BWExpression expression;
    private BWObject value;

    public Return(int lineNumber, BWExpression expression) {
        super(lineNumber);
        this.expression = expression;
    }

    @Override
    public BWObject getValue() {
        return value;
    }

    @Override
    public int getIntValue() {
        return value.getIntValue();
    }

    @Override
    public String getValueType() {
        return value.getValueType();
    }

    @Override
    public void run(Scope scope) {
        expression.run(scope);
        value = expression.getValue();
    }
}
