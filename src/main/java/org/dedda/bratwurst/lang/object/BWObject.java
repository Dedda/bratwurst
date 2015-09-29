package org.dedda.bratwurst.lang.object;

import org.dedda.bratwurst.lang.BWClass;
import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.cache.BWClassCache;
import org.dedda.bratwurst.lang.cache.BWFunctionCache;
import org.dedda.bratwurst.lang.cache.BWVariableCache;

import java.util.HashMap;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
public class BWObject {

    private BWClass bwClass;
    private BWVariableCache variables;
    private BWFunctionCache functions;

    public BWObject(BWClass bwClass) {
        this.bwClass = bwClass;
        this.variables = new BWVariableCache();
        this.functions = new BWFunctionCache();
    }

    public BWClass getBwClass() {
        return bwClass;
    }

    public boolean isInt() {
        return false;
    }

}
