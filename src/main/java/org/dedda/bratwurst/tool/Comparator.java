package org.dedda.bratwurst.tool;

import org.dedda.bratwurst.lang.BWObject;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public interface Comparator<T extends BWObject> {

    boolean compare(T obj1, T obj2);

}
