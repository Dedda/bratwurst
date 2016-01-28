package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.BWExpression;
import org.dedda.bratwurst.lang.BWInteger;
import org.dedda.bratwurst.lang.BWObject;
import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.scope.Scope;
import org.dedda.bratwurst.tool.IntegerComparator;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class IntegerComparison extends BWExpression {

    private String varName1;
    private String varName2;
    private int comparison;

    public IntegerComparison(int lineNumber, String varName1, String varName2) {
        super(lineNumber);
        this.varName1 = varName1;
        this.varName2 = varName2;
    }

    @Override
    public BWObject getValue() {
        return new BWInteger(comparison);
    }

    @Override
    public int getIntValue() {
        return comparison;
    }

    @Override
    public String getValueType() {
        return "integer";
    }

    @Override
    public void run(Scope scope) {
        BWVariable var1 = scope.getVariable(varName1);
        BWVariable var2 = scope.getVariable(varName2);
        if (!(var1.getValue() instanceof BWInteger && var2.getValue() instanceof BWInteger)) {
            comparison = 0;
            return;
        }
        IntegerComparator comparator = new IntegerComparator();
        comparison = comparator.compareLge((BWInteger) var1.getValue(), (BWInteger) var2.getValue());
    }
}
