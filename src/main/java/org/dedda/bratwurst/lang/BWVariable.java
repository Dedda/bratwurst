package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class BWVariable extends AbstractVariable {

    private String name;
    private BWObject value;

    public BWVariable(String name, BWObject value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public BWObject getValue() {
        return value;
    }

    public void setValue(BWObject value) {
        this.value = value;
    }

    public int getIntValue() {
        return (value instanceof BWInteger) ? ((BWInteger) value).getIntValue() : 0;
    }

    @Override
    public String getValueType() {
        return null;
    }

    @Override
    public void run(Scope scope) {}
}
