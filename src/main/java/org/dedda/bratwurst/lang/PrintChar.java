package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class PrintChar extends BWInstruction {

    private char toPrint;

    public PrintChar(int lineNumber, char toPrint) {
        super(lineNumber);
        this.toPrint = toPrint;
    }

    @Override
    public void run(Scope scope) {
        System.out.print(toPrint);
    }

    public char getToPrint() {
        return toPrint;
    }
}
