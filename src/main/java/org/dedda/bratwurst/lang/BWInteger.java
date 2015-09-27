package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class BWInteger extends BWVariable<Integer> {

    private int value;

    public BWInteger(final int value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public int getIntValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
