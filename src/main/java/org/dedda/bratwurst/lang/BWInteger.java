package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class BWInteger extends BWObject {

    private int value;

    public BWInteger(int value) {
        super(BWClass.getClassForName("integer"), new BWVariable[0], new BWFunction[0]);
        this.value = value;
    }

    public void setIntValue(int value) {
        this.value = value;
    }

    @Override
    public int getIntValue() {
        return value;
    }

    @Override
    public String getValueType() {
        return "integer";
    }

}
