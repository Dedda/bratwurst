package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.object.BWObject;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class BWVariable implements BWExpression {

    protected String name;
    protected BWObject value;

    public BWVariable(String name) {
        this.name = name;
    }

    public BWVariable(String name, BWObject value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    @Override
    public BWObject getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(BWObject value) {
        this.value = value;
    }

    @Override
    public int getIntValue() {
        return value instanceof BWInteger ? ((BWInteger) value).getValue() : 0;
    }
}
