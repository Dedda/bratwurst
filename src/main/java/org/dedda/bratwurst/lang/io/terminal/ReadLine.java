package org.dedda.bratwurst.lang.io.terminal;

import org.dedda.bratwurst.lang.BWExpression;
import org.dedda.bratwurst.lang.BWObject;
import org.dedda.bratwurst.lang.BWString;
import org.dedda.bratwurst.lang.scope.Scope;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class ReadLine extends BWExpression {

    private String read;

    public ReadLine(int lineNumber) {
        super(lineNumber);
    }

    @Override
    public BWObject getValue() {
        return new BWString(read);
    }

    @Override
    public int getIntValue() {
        return getValue().getIntValue();
    }

    @Override
    public String getValueType() {
        return "string";
    }

    @Override
    public void run(Scope scope) {
        Scanner scanner = new Scanner(System.in);
        read = scanner.nextLine();
    }
}
