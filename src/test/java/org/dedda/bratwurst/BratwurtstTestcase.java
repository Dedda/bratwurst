package org.dedda.bratwurst;

import org.dedda.bratwurst.lang.BWClass;
import org.junit.Before;

/**
 * Created by dedda on 12/10/15.
 *
 * @author dedda
 */
public class BratwurtstTestcase {

    @Before
    public final void __setUpBratwurstTestcase() throws Exception {
        BWClass.unregisterAll();
        this.setUp();
    }

    protected void setUp() throws Exception {}

}
