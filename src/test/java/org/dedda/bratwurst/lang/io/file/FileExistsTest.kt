package org.dedda.bratwurst.lang.io.file

import org.dedda.bratwurst.FileSystemTestCase
import org.dedda.bratwurst.lang.BWString
import org.dedda.bratwurst.lang.BWVariable
import org.testng.AssertJUnit
import org.testng.annotations.Test
import java.io.File

/**
 * Created by dedda on 1/27/16.
 *
 * @author dedda
 */
class FileExistsTest : FileSystemTestCase() {
    @Test
    @Throws(Exception::class)
    fun testRun() {
        val filename = genericFileName()
        val file = File(filename)
        createFile(file)
        val scope = createEmptyScope()
        scope.setVariable(BWVariable("var", BWString(filename)))
        val fileExists = FileExists(0, "var")
        fileExists.run(scope)
        AssertJUnit.assertEquals("File not found", 1, fileExists.intValue)
        removeFile(file)
        fileExists.run(scope)
        AssertJUnit.assertEquals("File found", 0, fileExists.intValue)
    }
}