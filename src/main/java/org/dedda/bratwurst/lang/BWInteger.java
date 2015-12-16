package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class BWInteger extends BWObject {

    private int value;

    public BWInteger(int value) {
        super(BWClass.getClassForName("integer"));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BWInteger bwInteger = (BWInteger) o;

        return value == bwInteger.value;

    }
}
