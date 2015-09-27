package org.dedda.bratwurst.lang.instruction;

/**
 * Created by dedda on 9/27/15.
 *
 * @author dedda
 */
public abstract class VariableDeclaration<T> implements Instruction {

    private String variableName;
    private T value;

    public VariableDeclaration(final String variableName, final T value) {
        this.variableName = variableName;
        this.value = value;
    }
}
