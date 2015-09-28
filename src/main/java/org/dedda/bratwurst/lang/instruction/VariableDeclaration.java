package org.dedda.bratwurst.lang.instruction;

import org.dedda.bratwurst.lang.Program;

/**
 * Created by dedda on 9/27/15.
 *
 * @author dedda
 */
public abstract class VariableDeclaration<T> implements Instruction {

    protected String variableName;
    protected T value;

    public VariableDeclaration(String variableName, T value) {
        this.variableName = variableName;
        this.value = value;
    }
}
