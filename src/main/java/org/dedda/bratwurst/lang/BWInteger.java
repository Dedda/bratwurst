package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.parse.Emoji;

import static org.dedda.bratwurst.parse.Emoji.*;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class BWInteger extends BWObject {

    public static final String INTEGER_CLASS_NAME = CROWN + POLICE + SPAGHETTI + BEER + PALM;

    private int value;

    public BWInteger(int value) {
        super(BWClass.getClassForName(INTEGER_CLASS_NAME));
        this.value = value;
    }

    @Override
    public int getIntValue() {
        return value;
    }

    @Override
    public String getValueType() {
        return INTEGER_CLASS_NAME;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BWInteger bwInteger = (BWInteger) o;

        return value == bwInteger.value;

    }
}
