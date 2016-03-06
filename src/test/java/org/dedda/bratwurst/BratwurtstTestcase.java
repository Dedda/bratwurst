package org.dedda.bratwurst;

import org.dedda.bratwurst.lang.BWClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

/**
 * Created by dedda on 12/10/15.
 *
 * @author dedda
 */
public class BratwurtstTestcase {

    @BeforeMethod
    public final void __setUpBratwurstTestcase() throws Exception {
        BWClass.unregisterAll();
        this.setUp();
    }

    protected void setUp() throws Exception {}

}
