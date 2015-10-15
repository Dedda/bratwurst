package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class PrintChar implements BWInstruction {

    private char toPrint;

    public PrintChar(char toPrint) {
        this.toPrint = toPrint;
    }

    @Override
    public void run(Scope scope) {
        System.out.println(toPrint);
    }

}
