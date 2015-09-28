package org.dedda.bratwurst.lang.instruction;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
public class Print implements Instruction {

    public final String message;

    public Print(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(message);
    }
}
