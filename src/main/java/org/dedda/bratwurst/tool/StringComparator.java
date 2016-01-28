package org.dedda.bratwurst.tool;

import org.dedda.bratwurst.lang.BWString;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class StringComparator implements Comparator<BWString> {

    @Override
    public boolean compare(BWString obj1, BWString obj2) {
        return obj1.getStringValue().equals(obj2.getStringValue());
    }
}
