package org.dedda.bratwurst.lang.scope;

import org.dedda.bratwurst.lang.*;
import org.dedda.bratwurst.test.TestFileRunner;
import org.dedda.bratwurst.test.TestFunctionRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

/**
 * Created by dedda on 11/9/15.
 *
 * @author dedda
 */
public class Scope {

    private final Program program;

    private final Stack<StackElement> scopeStack;

    private TestFileRunner testFileRunner = null;
    private TestFunctionRunner testFunctionRunner = null;

    public Scope(Program program) {
        this.program = program;
        scopeStack = new Stack<>();
    }

    public Scope(Program program, TestFileRunner testFileRunner, TestFunctionRunner testFunctionRunner) {
        this(program);
        this.testFileRunner = testFileRunner;
        this.testFunctionRunner = testFunctionRunner;
    }

    public BWObject getCurrentObject() {
        return scopeStack.peek().getObject();
    }

    public BWObject getCurrentObjectR() {
        BWObject object;
        int index = scopeStack.size() - 1;
        while (index >= 0) {
            object = scopeStack.elementAt(index).getObject();
            if (object != null) {
                return object;
            }
            index--;
        }
        return null;
    }

    public boolean isInObject() {
        return getCurrentObjectR() != null;
    }

    public BWFunction getFunction(String name) {
        Optional<BWFunction> funcOpt;
        if (isInObject()) {
             funcOpt = Arrays.stream(getCurrentObjectR().getFunctions()).filter(f -> f.getName().equals(name)).findFirst();
            if (funcOpt.isPresent()) {
                return funcOpt.get();
            }
        }
        funcOpt = Arrays.stream(program.getFunctions()).filter(f -> f.getName().equals(name)).findFirst();
        if (funcOpt.isPresent()) {
            return funcOpt.get();
        }
        return null;
    }

    public BWFunction getFunction(String variableName, String functionName) {
        BWObject object = getVariable(variableName).getValue();
        Optional<BWFunction> funcOpt = Arrays.stream(object.getFunctions()).filter(f -> f.getName().equals(functionName)).findFirst();
        if (funcOpt.isPresent()) {
            return funcOpt.get();
        }
        return null;
    }

    public void registerClass(BWClass bwClass) {
        program.registerClass(bwClass);
    }

    public BWVariable getVariable(String name) {
        BWVariable var;
        int index = scopeStack.size() - 1;
        while(index >= 0) {
            var = scopeStack.elementAt(index).getVariable(name);
            if (var != null) {
                return var;
            }
            index--;
        }
        return program.hasVariable(name) ? program.getVariable(name) : null;
    }

    public void setVariable(BWVariable variable) {
        BWVariable var = getVariable(variable.getName());
        if (var != null) {
            var.setValue(variable.getValue());
        } else {
            BWObject obj = getCurrentObjectR();
            if (obj != null) {
                obj.addVariable(variable);
            } else {
                program.registerVariable(variable);
            }
        }
    }

    public void enterFunction(BWFunction function, List<BWVariable> arguments) {
        scopeStack.push(new StackElement(null, function, arguments));
    }

    public void enterFunction(BWObject object, BWFunction function, List<BWVariable> arguments) {
        scopeStack.push(new StackElement(object, function, arguments));
    }

    public void leaveFunction() {
        scopeStack.pop();
    }

    public Program getProgram() {
        return program;
    }

    public void push(BWObject object) {
        program.push(object);
    }

    public BWObject pop() {
        return program.pop();
    }

    public TestFileRunner getTestFileRunner() {
        return testFileRunner;
    }

    public TestFunctionRunner getTestFunctionRunner() {
        return testFunctionRunner;
    }

    public boolean isInTest() {
        return testFileRunner != null;
    }
}
