package org.dedda.bratwurst.lang.io.file;

import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.BWString;
import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.scope.Scope;

import java.io.File;

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
public class FileRemove extends BWInstruction {

    public final String variableName;

    public FileRemove(int lineNumber, String variableName) {
        super(lineNumber);
        this.variableName = variableName;
    }

    @Override
    public void run(Scope scope) {
        BWVariable variable = scope.getVariable(variableName);
        if (!(variable.getValue() instanceof BWString)) {
            throw new RuntimeException("variable not of type string!");
        }
        String fileName = ((BWString) variable.getValue()).getStringValue();
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }
}
