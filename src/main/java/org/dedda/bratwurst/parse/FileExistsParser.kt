package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.io.file.FileExists

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
class FileExistsParser : ExpressionParser() {
    override fun parse(data: String, linenumber: Int): FileExists {
        val variableName = data.substring(1, data.length - 1)
        return FileExists(linenumber, variableName)
    }
}