package org.dedda.bratwurst.lang.action;

import org.dedda.bratwurst.lang.BWExpression;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public interface Action {

    void act(BWExpression... parameters);

}
