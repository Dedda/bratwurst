package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class BWObjectFunction extends BWFunction {

    private BWObject object;

    public BWObjectFunction(String name, BWInstruction[] instructions, BWObject object) {
        super(name, instructions);
        this.object = object;
    }

    @Override
    public BWObject getValue() {
        return null;
    }

    @Override
    public int getIntValue() {
        return 0;
    }

    @Override
    public String getValueType() {
        return null;
    }

    @Override
    public void run(Scope scope) {

    }
}
