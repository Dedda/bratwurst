package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
public class BWString extends BWObject {

    private String value;

    public BWString(String value) {
        super(BWClass.getClassForName("string"), new BWFunction[0]);
        this.value = value;
    }

    public String getStringValue() {
        return value;
    }

    public void setStringValue(String value) {
        this.value = value;
    }

    @Override
    public String getValueType() {
        return "string";
    }
}
