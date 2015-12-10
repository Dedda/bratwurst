package org.dedda.bratwurst.lang.bcd;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by dedda on 12/9/15.
 *
 * @author dedda
 */
public class BCDClient extends Thread {

    private Socket socket = null;
    private boolean run = false;

    public BCDClient() {

    }

    public void start(int port) {
        run = true;
        connectTo(port);
    }

    public void stopMe() {
        run = false;
    }

    @Override
    public void run() {
        while (run) {

        }
    }

    private Socket connectTo(int port) {
        Socket socket = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), port);
        } catch (IOException e) {
            return null;
        }
        return socket;
    }

    public boolean isServer() {
        return false;
    }

}
