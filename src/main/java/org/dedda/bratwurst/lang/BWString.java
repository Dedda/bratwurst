package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
public class BWString extends BWObject {

    private String value;

    public BWString(String value) {
        super(new BWClass("string", new AbstractFunction[0]), new BWVariable[0], new BWObjectFunction[0]);
        this.value = value;
    }

    public String getStringValue() {
        return value;
    }

    public void setStringValue(String value) {
        this.value = value;
    }
}
