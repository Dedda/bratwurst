package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class Program {
    private static Program instance = new Program();

    public static Program getInstance() {
        return instance;
    }

    private BWFunction[] functions = new BWFunction[0];
    private BWClass[] classes = new BWClass[0];
    private ArrayList<BWVariable> variables = new ArrayList<>();
    private BWInstruction[] instructions = new BWInstruction[0];
    private boolean stopped = false;
    private int exitCode = 0;

    private Program() {

    }

    public void run() {
        Scope scope = new Scope();
        for (int i = 0; i < instructions.length; i++) {
            if (stopped) {
                return;
            }
            instructions[i].run(scope);
        }
    }

    public void stop(int code) {
        stopped = true;
        exitCode = code;
    }

    public int getExitCode() {
        return exitCode;
    }

    public void registerVariable(BWVariable variable) {
        variables.stream().collect(Collectors.toList());
        Optional<BWVariable> variableOptional = variables.stream().filter(v -> v.getName().equals(variable.getName())).findFirst();
        if (variableOptional.isPresent()) {
            variableOptional.get().setValue(variable.getValue());
        } else {
            variables.add(variable);
        }
    }

    public void registerClass(BWClass bwClass) {
        List<BWClass> classList = Arrays.stream(Program.getInstance().getClasses()).collect(Collectors.toList());
        if (classList.stream().filter(c -> c.name.equals(bwClass.name)).findFirst().isPresent()) {
            throw new RuntimeException("Class " + bwClass.name + " already registered!");
        }
        classList.add(bwClass);
        classList.toArray(classes);
    }

    public BWFunction[] getFunctions() {
        return functions;
    }

    public void setFunctions(BWFunction[] functions) {
        this.functions = functions;
    }

    public BWClass[] getClasses() {
        return classes;
    }

    public void setClasses(BWClass[] classes) {
        this.classes = classes;
    }

    public void setInstructions(BWInstruction[] instructions) {
        this.instructions = instructions;
    }

    public boolean hasVariable(String name) {
        return variables.stream().filter(v -> v.getName().equals(name)).findFirst().isPresent();
    }

    public BWVariable getVariable(String name) {
        Optional<BWVariable> variable = variables.stream().filter(v -> v.getName().equals(name)).findFirst();
        if (variable.isPresent()) {
            return variable.get();
        }
        throw new RuntimeException("Variable " + name + " does not exist!");
    }

    public ArrayList<BWVariable> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<BWVariable> variables) {
        this.variables = variables;
    }
}
