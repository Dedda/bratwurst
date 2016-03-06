package org.dedda.bratwurst.lang.io.file;

import org.dedda.bratwurst.FileSystemTestCase;
import org.dedda.bratwurst.lang.BWString;
import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.scope.Scope;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class FileImportTest extends FileSystemTestCase {

    @Test
    public void testRun() throws Exception {
        String filename = genericFileName();
        String content = "Some content to test";
        File file = new File(filename);
        createFile(file, content);
        Scope scope = createEmptyScope();
        scope.setVariable(new BWVariable("var", new BWString(filename)));
        FileImport fileImport = new FileImport(0, "var");
        fileImport.run(scope);
        BWVariable var = scope.getVariable("var");
        BWString bwString = (BWString) var.getValue();
        assertEquals(content, bwString.getStringValue());
        removeFile(file);
    }
}