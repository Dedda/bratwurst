package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class Exit extends BWInstruction {

    public Exit(int lineNumber) {
        super(lineNumber);
    }

    @Override
    public void run(Scope scope) {
        Program.getInstance().stop(0);
    }
}
