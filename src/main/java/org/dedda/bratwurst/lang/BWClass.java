package org.dedda.bratwurst.lang;

import java.util.HashMap;
import java.util.List;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class BWClass {

    private String name;
    private List<BWVariable> variables;
    private List<BWFunction> functions;

    public BWClass() {
        this(null);
    }

    public BWClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BWObject instantiate() {
        HashMap<String, BWVariable> variables = new HashMap<>();
        HashMap<String, BWFunction> functions = new HashMap<>();
        BWObject object = new BWObject(this, variables, functions);
        return object;
    }

}
