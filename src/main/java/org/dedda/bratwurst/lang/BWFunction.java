package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/9/15.
 *
 * @author dedda
 */
public class BWFunction extends BWExpression {

    private String name;
    private BWInstruction[] instructions;
    private BWObject value = new BWInteger(0);

    public BWFunction(String name, BWInstruction[] instructions) {
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
        for (BWVariable variable : getArguments()) {
            scope.registerVariable(variable);
        }
        for (int i = 0; i < instructions.length; i++) {
            BWInstruction instruction = instructions[i];
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
}
