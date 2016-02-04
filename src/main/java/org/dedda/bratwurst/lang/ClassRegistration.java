package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class ClassRegistration extends BWInstruction {

    private final BWClass bwClass;

    public ClassRegistration(BWClass bwClass) {
        super(0);
        this.bwClass = bwClass;
    }

    @Override
    public void run(Scope scope) {
        scope.registerClass(bwClass);
    }
}
