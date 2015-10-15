package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public abstract class BWExpression extends BWInstruction {

    public abstract BWObject getValue();
    public abstract int getIntValue();
    public abstract String getValueType();

}
