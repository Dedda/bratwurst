package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;
import org.dedda.bratwurst.tool.IntegerComparator;
import org.dedda.bratwurst.tool.ObjectComparator;
import org.dedda.bratwurst.tool.StringComparator;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class Comparison extends BWExpression {

    private String varName1;
    private String varName2;
    private boolean equals;

    public Comparison(int lineNumber, String varName1, String varName2) {
        super(lineNumber);
        this.varName1 = varName1;
        this.varName2 = varName2;
    }

    @Override
    public BWObject getValue() {
        return new BWInteger(getIntValue());
    }

    @Override
    public int getIntValue() {
        return equals ? 1 : 0;
    }

    @Override
    public String getValueType() {
        return "integer";
    }

    @Override
    public void run(Scope scope) {
        BWVariable var1 = scope.getVariable(varName1);
        BWVariable var2 = scope.getVariable(varName2);
        if (!var1.getValue().getClass().equals(var2.getValue().getClass())) {
            equals = false;
            return;
        }
        if (var1.getValue() instanceof BWInteger) {
            equals = new IntegerComparator().compare((BWInteger) var1.getValue(), (BWInteger) var2.getValue());
        } else if (var1.getValue() instanceof BWString) {
            equals = new StringComparator().compare((BWString) var1.getValue(), (BWString) var2.getValue());
        } else {
            equals = new ObjectComparator().compare(var1.getValue(), var2.getValue());
        }
    }
}
