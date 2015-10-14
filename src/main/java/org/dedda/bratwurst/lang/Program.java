package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/14/15.
 */
public class Program {
    private static Program ourInstance = new Program();

    public static Program getInstance() {
        return ourInstance;
    }

    private Program() {
    }
}
