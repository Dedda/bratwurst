package org.dedda.bratwurst.tool;

import org.dedda.bratwurst.lang.BWObject;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class ObjectComparator implements Comparator {

    @Override
    public boolean compare(BWObject obj1, BWObject obj2) {
        return obj1.getBwClass().getName().equals(obj2.getBwClass().getName());
    }
}
