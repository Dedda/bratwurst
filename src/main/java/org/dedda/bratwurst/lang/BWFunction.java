package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/9/15.
 *
 * @author dedda
 */
public class BWFunction extends BWExpression {

    private String name;
    private BWInstruction[] instructions;

    public BWFunction(String name, BWInstruction[] instructions) {
        this.name = name;
        this.instructions = instructions;
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

    public String getName() {
        return name;
    }

    public BWInstruction[] getInstructions() {
        return instructions;
    }

}
