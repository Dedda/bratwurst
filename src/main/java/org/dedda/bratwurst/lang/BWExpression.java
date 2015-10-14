package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public interface BWExpression extends BWInstruction {

    BWObject getValue();
    int getIntValue();
    String getValueType();

}
