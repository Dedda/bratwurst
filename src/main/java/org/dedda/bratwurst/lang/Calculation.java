package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
public class Calculation implements BWExpression {

    private BWExpression leftSide;
    private BWExpression rightSide;

    @Override
    public BWObject getValue() {
        return null;
    }

    @Override
    public int getIntValue() {
        return 0;
    }

    @Override
    public String getValueType() {
        return null;
    }

    @Override
    public void run(Scope scope) {

    }
}
