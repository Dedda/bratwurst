package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class BWInteger extends BWVariable<Integer> {

    public BWInteger(String name) {
        super(name);
    }

    public BWInteger(String name, Integer value) {
        super(name, value, "integer");
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
