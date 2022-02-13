package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.classes.BWClass;
import org.dedda.bratwurst.lang.scope.Scope;

import java.util.*;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class Program {

    private List<BWFunction> functions = new ArrayList<>();
    private List<BWClass> classes = new ArrayList<>();
    private List<BWVariable> variables = new ArrayList<>();
    private List<BWInstruction> instructions = new ArrayList<>();
    private boolean stopped = false;
    private int exitCode = 0;
    private final Deque<BWObject> global = new ArrayDeque<>();

    public void run() {
        Scope scope = new Scope(this);
        for (final BWInstruction instruction : instructions) {
            if (stopped) {
                return;
            }
            instruction.run(scope);
        }
    }

    public void stop(final int code) {
        stopped = true;
        exitCode = code;
    }

    public void push(final BWObject object) {
        global.push(object);
    }

    public BWObject pop() {
        return global.pop();
    }

    public int getExitCode() {
        return exitCode;
    }

    public void registerVariable(final BWVariable variable) {
        final Optional<BWVariable> variableOptional = variables.stream().filter(v -> v.getName().equals(variable.getName())).findFirst();
        if (variableOptional.isPresent()) {
            variableOptional.get().setValue(variable.getValue());
        } else {
            variables.add(variable);
        }
    }

    public void registerClass(final BWClass bwClass) {
        if (classes.stream().anyMatch(c -> c.getName().equals(bwClass.getName()))) {
            throw new RuntimeException("Class " + bwClass.getName() + " already registered!");
        }
        classes.add(bwClass);
    }

    public boolean isStopped() {
        return stopped;
    }

    public List<BWFunction> getFunctions() {
        return functions;
    }

    public void setFunctions(final List<BWFunction> functions) {
        this.functions = functions;
    }

    public List<BWClass> getClasses() {
        return classes;
    }

    public void setClasses(final List<BWClass> classes) {
        this.classes = classes;
    }

    public void setInstructions(final List<BWInstruction> instructions) {
        this.instructions = instructions;
    }

    public boolean hasVariable(final String name) {
        return variables.stream().anyMatch(v -> v.getName().equals(name));
    }

    public BWVariable getVariable(final String name) {
        return variables.stream()
                .filter(v -> v.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Variable " + name + " does not exist!"));
    }

    public void setVariables(final List<BWVariable> variables) {
        this.variables = variables;
    }
}
