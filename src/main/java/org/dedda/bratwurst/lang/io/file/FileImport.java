package org.dedda.bratwurst.lang.io.file;

import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.BWString;
import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.scope.Scope;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
public class FileImport extends BWInstruction {

    private final String variableName;

    public FileImport(int lineNumber, String variableName) {
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
        if (!file.exists()) {
            throw new RuntimeException("file " + fileName + " does not exists!");
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String data = "";
            String buffer;
            while ((buffer = reader.readLine()) != null) {
                data += buffer;
            }
            reader.close();
            variable.setValue(new BWString(data));
            scope.setVariable(variable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
