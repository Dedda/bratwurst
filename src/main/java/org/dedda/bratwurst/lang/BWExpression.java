package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.object.BWObject;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public interface BWExpression {

    BWObject getValue();
    int getIntValue();

}
