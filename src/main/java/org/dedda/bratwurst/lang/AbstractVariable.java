package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public abstract class AbstractVariable extends BWExpression {

    private String name;
    private BWExpression toEvaluate;

    public BWVariable getVariable(Scope scope) {
        toEvaluate.run(scope);
        return new BWVariable(name, toEvaluate.getValue());
    }

}
