package org.dedda.bratwurst.lang.scope;

import org.dedda.bratwurst.lang.BWFunction;
import org.dedda.bratwurst.lang.BWObject;
import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.Program;
import org.dedda.bratwurst.lang.classes.BWClass;
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

    public Scope(final Program program, final TestFileRunner testFileRunner, final TestFunctionRunner testFunctionRunner) {
        this(program);
        this.testFileRunner = testFileRunner;
        this.testFunctionRunner = testFunctionRunner;
    }

    public BWObject getCurrentObjectR() {
        BWObject object;
        int index = scopeStack.size() - 1;
        while (index >= 0) {
            object = scopeStack.elementAt(index).getObj();
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

    public BWFunction getFunction(final String name) {
        Optional<BWFunction> funcOpt;
        if (isInObject()) {
             funcOpt = Arrays.stream(getCurrentObjectR().getFunctions()).filter(f -> f.getName().equals(name)).findFirst();
            if (funcOpt.isPresent()) {
                return funcOpt.get();
            }
        }
        funcOpt = program.getFunctions().stream()
                .filter(f -> f.getName().equals(name))
                .findFirst();
        return funcOpt.orElse(null);
    }

    public BWFunction getFunction(final String variableName, final String functionName) {
        BWObject object = getVariable(variableName).getValue();
        return Arrays.stream(object.getFunctions())
                .filter(f -> f.getName().equals(functionName))
                .findFirst()
                .orElse(null);
    }

    public void registerClass(final BWClass bwClass) {
        program.registerClass(bwClass);
    }

    public BWVariable getVariable(final String name) {
        BWVariable variable;
        int index = scopeStack.size() - 1;
        while(index >= 0) {
            variable = scopeStack.elementAt(index).getVariable(name);
            if (variable != null) {
                return variable;
            }
            index--;
        }
        return program.hasVariable(name) ? program.getVariable(name) : null;
    }

    public void setVariable(final BWVariable variable) {
        BWVariable foundVariable = getVariable(variable.getName());
        if (foundVariable != null) {
            foundVariable.setValue(variable.getValue());
        } else {
            BWObject obj = getCurrentObjectR();
            if (obj != null) {
                obj.addVariable(variable);
            } else {
                program.registerVariable(variable);
            }
        }
    }

    public void enterFunction(final BWFunction function, final List<BWVariable> arguments) {
        enterFunction(null, function, arguments);
    }

    public void enterFunction(final BWObject object, final BWFunction function, final List<BWVariable> arguments) {
        scopeStack.push(new StackElement(object, function, arguments));
    }

    public void leaveFunction() {
        scopeStack.pop();
    }

    public Program getProgram() {
        return program;
    }

    public void push(final BWObject object) {
        program.push(object);
    }

    public BWObject pop() {
        return program.pop();
    }

    public TestFunctionRunner getTestFunctionRunner() {
        return testFunctionRunner;
    }

    public boolean isInTest() {
        return testFileRunner != null;
    }
}
