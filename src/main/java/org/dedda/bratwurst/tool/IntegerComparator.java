package org.dedda.bratwurst.tool;

import org.dedda.bratwurst.lang.BWInteger;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class IntegerComparator implements Comparator<BWInteger>{

    @Override
    public boolean compare(BWInteger obj1, BWInteger obj2) {
        return obj1.getIntValue() == obj2.getIntValue();
    }

    public int compareLge(BWInteger obj1, BWInteger obj2) {
        return Integer.compare(obj1.getIntValue(), obj2.getIntValue());
    }
}
