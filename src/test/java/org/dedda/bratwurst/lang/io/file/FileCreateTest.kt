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
class FileCreateTest : FileSystemTestCase() {
    @Test
    @Throws(Exception::class)
    fun testRun() {
        val filename = genericFileName()
        val file = File(filename)
        removeFile(file)
        val scope = createEmptyScope()
        scope.setVariable(BWVariable("var", BWString(filename)))
        val fileCreate = FileCreate(0, "var")
        fileCreate.run(scope)
        AssertJUnit.assertTrue("File was not created", file.exists())
        removeFile(file)
    }
}