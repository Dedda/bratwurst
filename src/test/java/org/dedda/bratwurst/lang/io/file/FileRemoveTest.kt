package org.dedda.bratwurst.lang.io.file

import org.dedda.bratwurst.FileSystemTestCase
import org.dedda.bratwurst.lang.BWString
import org.dedda.bratwurst.lang.BWVariable
import org.testng.AssertJUnit
import org.testng.annotations.Test
import java.io.File

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
class FileRemoveTest : FileSystemTestCase() {
    @Test
    @Throws(Exception::class)
    fun testRun() {
        val filename = genericFileName()
        val file = File(filename)
        createFile(file)
        val scope = createEmptyScope()
        scope.setVariable(BWVariable("var", BWString(filename)))
        val fileRemove = FileRemove(0, "var")
        fileRemove.run(scope)
        AssertJUnit.assertFalse("File was not removed", file.exists())
        removeFile(file)
    }
}