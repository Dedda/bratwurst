package org.dedda.bratwurst.lang.io.file;

import org.dedda.bratwurst.FileSystemTestCase;
import org.dedda.bratwurst.lang.BWString;
import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.scope.Scope;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by dedda on 1/27/16.
 *
 * @author dedda
 */
public class FileCreateTest extends FileSystemTestCase {

    @Test
    public void testRun() throws Exception {
        final String filename = genericFileName();
        File file = new File(filename);
        removeFile(file);
        Scope scope = createEmptyScope();
        scope.setVariable(new BWVariable("var", new BWString(filename)));
        FileCreate fileCreate = new FileCreate(0, "var");
        fileCreate.run(scope);
        assertTrue("File was not created", file.exists());
        removeFile(file);
    }
}