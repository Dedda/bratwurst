package org.dedda.bratwurst.lang.scope;

import org.dedda.bratwurst.lang.BWFunction;
import org.dedda.bratwurst.lang.BWObject;
import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.Program;

import java.util.List;
import java.util.Stack;

/**
 * Created by dedda on 11/9/15.
 *
 * @author dedda
 */
public class Scope {

    private Stack<StackElement> scopeStack;

    public Scope() {
        scopeStack = new Stack<>();
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

    public BWFunction getCurrentFunction() {
        return scopeStack.peek().getFunction();
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
        return Program.getInstance().hasVariable(name) ? Program.getInstance().getVariable(name) : null;
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
                Program.getInstance().registerVariable(variable);
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

}
