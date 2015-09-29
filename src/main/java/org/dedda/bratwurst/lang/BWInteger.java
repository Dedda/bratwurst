package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.object.BWObject;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class BWInteger extends BWObject {

    private int value;

    public BWInteger(final int value) {
        super(new BWClass("integer"));
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
