package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/9/15.
 *
 * @author dedda
 */
public class BWFunction extends AbstractFunction {

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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BWInstruction[] getInstructions() {
        return instructions;
    }

}
