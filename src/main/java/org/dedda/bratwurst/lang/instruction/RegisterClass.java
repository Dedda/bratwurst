package org.dedda.bratwurst.lang.instruction;

import org.dedda.bratwurst.lang.BWClass;
import org.dedda.bratwurst.lang.Program;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
public class RegisterClass implements Instruction {

    private BWClass bwClass;

    public RegisterClass(BWClass bwClass) {
        this.bwClass = bwClass;
    }

    @Override
    public void run() {
        Program.getInstance().registerClass(bwClass);
    }
}
