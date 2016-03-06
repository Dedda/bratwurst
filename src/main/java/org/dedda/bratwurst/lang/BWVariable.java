package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class BWVariable extends BWExpression {

    private final String name;
    private BWObject value = null;
    private BWExpression expression = null;

    public BWVariable(String name, BWObject value) {
        super(0);
        this.name = name;
        this.value = value;
    }

    public BWVariable(String name, BWExpression expression) {
        super(0);
        this.name = name;
        this.expression = expression;
    }

    public String getName() {
        return name;
    }

    public BWObject getValue() {
        return value;
    }

    public void setValue(BWObject value) {
        this.value = value;
    }

    public int getIntValue() {
        return (value instanceof BWInteger) ? value.getIntValue() : 0;
    }

    @Override
    public String getValueType() {
        return null;
    }

    @Override
    public void run(Scope scope) {
        if (expression != null) {
            expression.run(scope);
            value = expression.getValue();
        }
    }
}
