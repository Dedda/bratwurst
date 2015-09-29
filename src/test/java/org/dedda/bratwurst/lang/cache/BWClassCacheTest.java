package org.dedda.bratwurst.lang.cache;

import org.dedda.bratwurst.lang.BWClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dedda on 29.09.15.
 *
 * @author dedda
 */
public class BWClassCacheTest {

    private BWClassCache instance;

    @Before
    public void setUp() throws Exception {
        this.instance = new BWClassCache();
    }

    @Test
    public void testIntegerInitialization() {
        BWClass integerClass = instance.getBWClass("integer");
        assertTrue(integerClass instanceof BWClass);
        assertEquals("integer", integerClass.getName());
    }

    @Test
    public void testRegisterAndGet() {
        BWClass bwClass = new BWClass("test");
        this.instance.registerClass(bwClass);
        assertEquals(bwClass, instance.getBWClass("test"));
    }

}