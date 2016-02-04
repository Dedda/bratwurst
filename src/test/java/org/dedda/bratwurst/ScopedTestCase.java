package org.dedda.bratwurst;

import org.dedda.bratwurst.lang.Program;
import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 1/24/16.
 *
 * @author dedda
 */
public class ScopedTestCase extends BratwurtstTestcase {

    protected Scope createEmptyScope() {
        Program program = new Program();
        return new Scope(program);
    }

}
