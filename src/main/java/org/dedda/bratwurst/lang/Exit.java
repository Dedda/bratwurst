package org.dedda.bratwurst.lang;

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
        System.exit(0);
    }
}
