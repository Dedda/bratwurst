package org.dedda.bratwurst.lang.function;

import org.dedda.bratwurst.lang.object.BWObject;

/**
 * Created by dedda on 10/12/15.
 *
 * @author dedda
 */
public class BWParameter {

    public final String name;
    public final BWObject value;

    public BWParameter(String name, BWObject value) {
        this.name = name;
        this.value = value;
    }
}
