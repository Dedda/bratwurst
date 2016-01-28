package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWExpression;
import org.dedda.bratwurst.lang.GuiCommand;
import org.dedda.bratwurst.lang.PrintChar;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class GuiCommandParser extends ExpressionParser {

    @Override
    public GuiCommand parse(String data, int lineNumber) {
        data = data.substring(1, data.length() - 1);
        String[] args = data.split(":");
        Map<String, String> arguments = new HashMap<>();
        for (String arg : args) {
            String[] split = arg.split(",");
            arguments.put(split[0], split[1]);
        }
        GuiCommand guiCommand = new GuiCommand(lineNumber, arguments);
        return guiCommand;
    }
}
