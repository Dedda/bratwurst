package org.dedda.bratwurst.lang.bcd;

import java.net.ServerSocket;

/**
 * Created by dedda on 12/9/15.
 *
 * @author dedda
 */
public class BCDServer extends BCDClient {

    private boolean run = false;
    private ServerSocket serverSocket;

    public BCDServer() {

    }


    @Override
    public boolean isServer() {
        return true;
    }

}
