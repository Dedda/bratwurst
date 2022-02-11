package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class BWObject extends BWExpression {

    private final BWClass bwClass;
    private BWVariable[] variables = new BWVariable[0];
    private BWFunction[] functions;

    public BWObject(BWClass bwClass) {
        super(0);
        this.bwClass = bwClass;
        this.functions = bwClass.functions;
    }

    public BWVariable[] getVariables() {
        return variables;
    }

    public void addVariable(BWVariable variable) {
        List<BWVariable> variableList = Arrays.stream(variables).collect(Collectors.toList());
        Optional<BWVariable> variableOptional = variableList.stream().filter(v -> v.getName().equals(variable.getName())).findFirst();
        if (variableOptional.isPresent()) {
            variableOptional.get().setValue(variable.getValue());
        } else {
            variableList.add(variable);
        }
        variables = new BWVariable[variableList.size()];
        variableList.toArray(variables);
    }

    public BWFunction[] getFunctions() {
        return functions;
    }

    public void setFunctions(BWFunction[] functions) {
        this.functions = functions;
    }

    public BWClass getBwClass() {
        return bwClass;
    }

    @Override
    public BWObject getValue() {
        return this;
    }

    @Override
    public int getIntValue() {
        return 0;
    }

    @Override
    public ValueType getValueType() {
        return ValueType.OBJECT;
    }

    @Override
    public void run(Scope scope) {}
}
