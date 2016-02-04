package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 10/19/15.
 *
 * @author dedda
 */
public class PrintInt extends BWInstruction {

    private final String message;

    public PrintInt(int lineNumber, String message) {
        super(lineNumber);
        this.message = message;
    }

    @Override
    public void run(Scope scope) {
        if (message.matches("\\-?\\d+")) {
            System.out.print(message);
        } else {
            BWVariable variable = scope.getVariable(message);
            System.out.print(variable.getIntValue());
        }
    }
}
