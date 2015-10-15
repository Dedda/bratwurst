package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class BWInteger extends BWObject {

    private int value;

    public BWInteger(int value) {
        super(new BWClass("integer", new AbstractFunction[0]), new BWVariable[0], new BWObjectFunction[0]);
        this.value = value;
    }

    public void setIntValue(int value) {
        this.value = value;
    }

    public int getIntValue() {
        return value;
    }

}
