package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 13.10.15.
 *
 * @author dedda
 */
public class BWVariable {

    private String name;

    private BWObject value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BWObject getValue() {
        return value;
    }

    public void setValue(BWObject value) {
        this.value = value;
    }
}
