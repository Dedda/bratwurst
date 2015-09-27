package org.dedda.bratwurst.lang.instruction;

/**
 * Created by dedda on 9/27/15.
 *
 * @author dedda
 */
public class IntDeclaration extends VariableDeclaration<Integer> {

    public IntDeclaration(final String variableName, final int value) {
        super(variableName, value);
    }
}
