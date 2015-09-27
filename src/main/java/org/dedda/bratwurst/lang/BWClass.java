package org.dedda.bratwurst.lang;

import java.util.List;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class BWClass {

    private String name;
    private List<BWVariable> variables;

    public BWClass() {
        this(null);
    }

    public BWClass(String name) {
        this.name = name;
    }



}
