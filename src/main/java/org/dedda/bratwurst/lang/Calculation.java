package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
public class Calculation extends BWExpression {

    private final BWExpression leftSide;
    private final BWExpression rightSide;
    private final char operator;
    private int value = 0;

    public Calculation(int lineNumber, BWExpression leftSide, BWExpression rightSide, char operator) {
        super(lineNumber);
        this.leftSide = leftSide;
        this.rightSide = rightSide;
        this.operator = operator;
    }

    @Override
    public BWObject getValue() {
        return new BWInteger(value);
    }

    @Override
    public int getIntValue() {
        return value;
    }

    @Override
    public ValueType getValueType() {
        return ValueType.INTEGER;
    }

    @Override
    public void run(Scope scope) {
        leftSide.run(scope);
        int left = leftSide.getIntValue();
        rightSide.run(scope);
        int right = rightSide.getIntValue();
        switch (operator) {
            case '+':
                value = left + right;
                break;
            case '-':
                value = left - right;
                break;
            case '*':
                value = left * right;
                break;
            case '/':
                value = left / right;
                break;
            default:
                throw new IllegalArgumentException(getLineNumber() + ": Operator " + operator + " not known!");
        }
    }

    public char getOperator() {
        return operator;
    }

    public BWExpression getLeftSide() {
        return leftSide;
    }

    public BWExpression getRightSide() {
        return rightSide;
    }
}
