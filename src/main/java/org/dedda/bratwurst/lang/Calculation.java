package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
public class Calculation extends BWExpression {

    private BWExpression leftSide;
    private BWExpression rightSide;
    private char operator;
    private int value = 0;

    public Calculation(BWExpression leftSide, BWExpression rightSide, char operator) {
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
    public String getValueType() {
        return "integer";
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
                throw new IllegalArgumentException("Operator " + operator + " not known!");
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
