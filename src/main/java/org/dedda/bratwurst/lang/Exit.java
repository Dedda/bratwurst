package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class Exit implements BWInstruction {

    @Override
    public void run(Scope scope) {
        System.exit(scope.getArguments().length > 0 ? scope.getArguments()[0].getIntValue() : 0);
    }
}
