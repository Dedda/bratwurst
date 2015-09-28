package org.dedda.bratwurst.lang;

import java.util.HashMap;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
public class BWObject {

    private BWClass bwClass;
    private HashMap<String, BWVariable> variables;
    private HashMap<String, BWFunction> functions;

    public BWObject(BWClass bwClass, HashMap<String, BWVariable> variables, HashMap<String, BWFunction> functions) {
        this.bwClass = bwClass;
        this.variables = variables;
        this.functions = functions;
    }
}
