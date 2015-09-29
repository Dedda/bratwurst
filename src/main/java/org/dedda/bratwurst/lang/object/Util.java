package org.dedda.bratwurst.lang.object;

import org.dedda.bratwurst.lang.BWInteger;

/**
 * Created by dedda on 29.09.15.
 *
 * @author dedda
 */
public final class Util {

    private Util() {}

    public static String typeOf(BWObject object) {
        return object.getBwClass().getName();
    }

    public static boolean isInt(BWObject object) {
        return object instanceof BWInteger;
    }

}
