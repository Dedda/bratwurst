package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.instruction.Instruction;
import org.dedda.bratwurst.lang.object.BWFunction;
import org.dedda.bratwurst.lang.object.BWObject;

import java.util.HashMap;
import java.util.List;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class BWClass {

    private String name;
    private List<Instruction> instructions;

    public BWClass() {
        this(null);
    }

    public BWClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BWObject instantiate() {
        BWObject object = new BWObject(this);
        
        return object;
    }

}
