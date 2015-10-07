package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.cache.BWClassCache;
import org.dedda.bratwurst.lang.instruction.Instruction;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class Program {

    private BWClassCache bwClasses;
    private List<BWVariable> variables;

    private List<Instruction> instructions;

    private Program() {
        this.bwClasses = new BWClassCache();
        this.variables = new LinkedList<>();
        this.instructions = new LinkedList<>();
    }

    public void registerVariable(BWVariable variable) {
        BWVariable registered = variables.stream().filter(v -> v.getName().equals(variable.getName())).findFirst().get();
        if (registered == null) {
            variables.add(variable);
        } else {
            variables.remove(registered);
            variables.add(variable);
        }
    }

    public void registerClass(BWClass bwClass) {
        bwClasses.registerClass(bwClass);
    }

    public void addInstruction(Instruction instruction) {
        this.instructions.add(instruction);
    }

    public void run() {
        instructions.stream().forEachOrdered(i -> i.run());
    }

    private static Program instance = null;

    public static void init() {
        instance = new Program();
    }

    public static Program getInstance() {
        if (instance == null) {
            init();
        }
        return instance;
    }

}
