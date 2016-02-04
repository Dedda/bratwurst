package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dedda on 10/9/15.
 *
 * @author dedda
 */
public class BWFunction extends BWExpression {

    private final String name;
    private final BWInstruction[] instructions;
    private final List<BWVariable> variables = new ArrayList<>();
    private BWObject value = new BWInteger(0);

    public BWFunction(String name, BWInstruction[] instructions) {
        super(0);
        this.name = name;
        this.instructions = instructions;
    }

    @Override
    public BWObject getValue() {
        return value;
    }

    @Override
    public int getIntValue() {
        return value.getIntValue();
    }

    @Override
    public String getValueType() {
        return value.getValueType();
    }

    @Override
    public void run(Scope scope) {
        variables.addAll(Arrays.asList(getArguments()));
        for (BWVariable argument : getArguments()) {
            argument.run(scope);
        }
        for (BWInstruction instruction : instructions) {
            instruction.run(scope);
            if (instruction instanceof Return) {
                value = ((Return) instruction).getValue();
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public BWInstruction[] getInstructions() {
        return instructions;
    }

    public List<BWVariable> getVariables() {
        return variables;
    }
}
