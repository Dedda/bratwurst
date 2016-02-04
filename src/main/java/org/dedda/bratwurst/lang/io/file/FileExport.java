package org.dedda.bratwurst.lang.io.file;

import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.BWString;
import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.scope.Scope;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
public class FileExport extends BWInstruction {

    private final String sourceVariableName;
    private final String destinationVariableName;

    public FileExport(int lineNumber, String sourceVariableName, String destinationVariableName) {
        super(lineNumber);
        this.sourceVariableName = sourceVariableName;
        this.destinationVariableName = destinationVariableName;
    }

    @Override
    public void run(Scope scope) {
        BWVariable sourceVariable = scope.getVariable(sourceVariableName);
        BWVariable destinationVariable = scope.getVariable(destinationVariableName);
        if (!(sourceVariable.getValue() instanceof BWString)) {
            throw new RuntimeException("variable not of type string!");
        }
        if (!(destinationVariable.getValue() instanceof BWString)) {
            throw new RuntimeException("variable not of type string!");
        }
        String fileName = ((BWString) destinationVariable.getValue()).getStringValue();
        File file = new File(fileName);
        if (!file.exists()) {
            throw new RuntimeException("file " + fileName + " does not exists!");
        }
        String data = ((BWString) sourceVariable.getValue()).getStringValue();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(data);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
