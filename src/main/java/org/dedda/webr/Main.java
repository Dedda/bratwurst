package org.dedda.webr;

import org.dedda.bratwurst.lang.*;
import org.dedda.bratwurst.parse.Parser;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class Main {

    public static void main(String[] args) {
        weBr weBr = null;
        try {
            weBr = new weBr(9999);
        } catch (IOException e) {
            e.printStackTrace();
        }
        weBr.addRoute("/test", "test.bw");
        weBr.addRoute("/test2", "test2.bw");
    }

}
