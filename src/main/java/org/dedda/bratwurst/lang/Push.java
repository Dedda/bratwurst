package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 12/8/15.
 *
 * @author dedda
 */
public class Push extends BWInstruction {

    private BWExpression argument;

    public Push(int lineNumber, BWExpression argument) {
        super(lineNumber);
        this.argument = argument;
    }

    @Override
    public void run(Scope scope) {
        argument.run(scope);
        scope.push(argument.getValue());
    }

    public BWExpression getArgument() {
        return argument;
    }
}
