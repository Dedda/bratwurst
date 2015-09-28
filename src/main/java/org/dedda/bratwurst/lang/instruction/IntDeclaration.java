package org.dedda.bratwurst.lang.instruction;

import org.dedda.bratwurst.lang.BWInteger;
import org.dedda.bratwurst.lang.Program;

/**
 * Created by dedda on 9/27/15.
 *
 * @author dedda
 */
public class IntDeclaration extends VariableDeclaration<Integer> {

    public IntDeclaration(final String variableName, final int value) {
        super(variableName, value);
    }

    @Override
    public void run() {
        Program.getInstance().registerVariable(new BWInteger(variableName, value));
    }
}
