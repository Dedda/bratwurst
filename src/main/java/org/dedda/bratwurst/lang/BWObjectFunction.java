package org.dedda.bratwurst.lang;

import java.util.Arrays;

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

    @Override
    public BWObject substituteVariableName(String variableName) {
        BWObject object = null;
        if (Arrays.stream(object.getVariables()).filter(v -> v.getName().equals(variableName)).findFirst().isPresent()) {
            object = Arrays.stream(object.getVariables()).filter(v -> v.getName().equals(variableName)).findFirst().get().getValue();
        }
        return object;
    }
}
