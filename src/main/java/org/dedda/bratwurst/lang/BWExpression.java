package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public abstract class BWExpression extends BWInstruction {

    public BWExpression(int lineNumber) {
        super(lineNumber);
    }

    public abstract BWObject getValue();
    public abstract int getIntValue();
    public abstract ValueType getValueType();

}
