package org.dedda.bratwurst

import org.dedda.bratwurst.lang.BWClass
import org.testng.annotations.BeforeMethod

/**
 * Created by dedda on 12/10/15.
 *
 * @author dedda
 */
open class BratwurtstTestcase {
    @BeforeMethod
    @Throws(Exception::class)
    fun __setUpBratwurstTestcase() {
        BWClass.unregisterAll()
        setUp()
    }

    @Throws(Exception::class)
    protected open fun setUp() {
    }
}