package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
public class BWString extends BWObject {

    private String value;

    public BWString(String value) {
        super(new BWStringClass());
        this.value = value;
    }

    public String getStringValue() {
        return value;
    }

    @Override
    public String getValueType() {
        return "string";
    }

    @Override
    public int getIntValue() {
        if (value.matches("\\-?\\d+")) {
            return Integer.parseInt(value);
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BWString bwString = (BWString) o;

        return !(value != null ? !value.equals(bwString.value) : bwString.value != null);

    }

}
