package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class ClassRegistration extends BWInstruction {

    private BWClass bwClass;

    public ClassRegistration(int lineNumber, BWClass bwClass) {
        super(lineNumber);
        this.bwClass = bwClass;
    }

    @Override
    public void run(Scope scope) {
        scope.registerClass(bwClass);
    }
}
