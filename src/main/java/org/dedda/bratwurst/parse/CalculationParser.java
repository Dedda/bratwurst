package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.Calculation;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class CalculationParser extends ExpressionParser {

    public Calculation parse(String line, int lineNumber) {
        line = line.trim();
        String[] parts = line.split("[\\*/]", 2);
        char operand;
        if (parts.length == 2) {
            int mulIndex = line.indexOf('*');
            mulIndex = mulIndex < 0 ? Integer.MAX_VALUE : mulIndex;
            int divIndex = line.indexOf('/');
            divIndex = divIndex < 0 ? Integer.MAX_VALUE : divIndex;
            operand = mulIndex < divIndex ? '*' : '/';
            return new Calculation(lineNumber, new ExpressionParser().parse(parts[0].trim(), lineNumber), new ExpressionParser().parse(parts[1].trim(), lineNumber), operand);
        }
        parts = line.split("[\\+\\-]", 2);
        if (parts.length == 2) {
            int addIndex = line.indexOf('+');
            addIndex = addIndex < 0 ? Integer.MAX_VALUE : addIndex;
            int subIndex = line.indexOf('-');
            subIndex = subIndex < 0 ? Integer.MAX_VALUE : subIndex;
            operand = addIndex < subIndex ? '+' : '-';
            return new Calculation(lineNumber, new ExpressionParser().parse(parts[0].trim(), lineNumber), new ExpressionParser().parse(parts[1].trim(), lineNumber), operand);
        }
        return null;
    }

}
