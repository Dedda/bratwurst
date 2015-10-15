package org.dedda.bratwurst.lang;

import java.util.Arrays;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public abstract class BWInstruction {

    public abstract void run(Scope scope);

    public BWObject substituteVariableName(String variableName) {
        BWObject object = null;
        if (Arrays.stream(Program.getInstance().getVariables()).filter(v -> v.getName().equals(variableName)).findFirst().isPresent()) {
            object = Arrays.stream(Program.getInstance().getVariables()).filter(v -> v.getName().equals(variableName)).findFirst().get().getValue();
        }
        return object;
    }

}
