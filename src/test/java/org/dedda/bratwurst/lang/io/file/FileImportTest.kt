package org.dedda.bratwurst.lang.io.file

import org.dedda.bratwurst.FileSystemTestCase
import org.dedda.bratwurst.lang.BWString
import org.dedda.bratwurst.lang.BWVariable
import org.testng.Assert
import org.testng.annotations.Test
import java.io.File

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
class FileImportTest : FileSystemTestCase() {
    @Test
    @Throws(Exception::class)
    fun testRun() {
        val filename = genericFileName()
        val content = "Some content to test"
        val file = File(filename)
        createFile(file, content)
        val scope = createEmptyScope()
        scope.setVariable(BWVariable("var", BWString(filename)))
        val fileImport = FileImport(0, "var")
        fileImport.run(scope)
        val `var` = scope.getVariable("var")
        val bwString = `var`.value as BWString
        Assert.assertEquals(content, bwString.stringValue)
        removeFile(file)
    }
}