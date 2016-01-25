package org.dedda.bratwurst.lang.io.file;

import org.dedda.bratwurst.lang.*;
import org.dedda.bratwurst.lang.scope.Scope;

import java.io.File;

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
public class FileExists extends BWExpression {

    public final String variableName;
    private boolean exists;

    public FileExists(int lineNumber, String variableName) {
        super(lineNumber);
        this.variableName = variableName;
    }

    @Override
    public BWObject getValue() {
        return new BWInteger(getIntValue());
    }

    @Override
    public int getIntValue() {
        return exists ? 1 : 0;
    }

    @Override
    public String getValueType() {
        return "integer";
    }

    @Override
    public void run(Scope scope) {
        BWVariable variable = scope.getVariable(variableName);
        if (!(variable.getValue() instanceof BWString)) {
            throw new RuntimeException("variable not of type string!");
        }
        String fileName = ((BWString) variable.getValue()).getStringValue();
        File file = new File(fileName);
        this.exists = file.exists();
    }
}
