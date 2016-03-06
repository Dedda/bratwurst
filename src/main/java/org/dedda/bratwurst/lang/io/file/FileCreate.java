package org.dedda.bratwurst.lang.io.file;

import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.BWString;
import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.scope.Scope;

import java.io.File;
import java.io.IOException;

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
public class FileCreate extends BWInstruction {

    private final String variableName;

    public FileCreate(int lineNumber, String variableName) {
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
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                file.delete();
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
