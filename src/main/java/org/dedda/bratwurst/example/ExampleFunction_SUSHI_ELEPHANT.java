package org.dedda.bratwurst.example;

import org.dedda.bratwurst.lang.BWFunction;
import org.dedda.bratwurst.lang.BWInstruction;

import static org.dedda.bratwurst.parse.Emoji.ELEPHANT;
import static org.dedda.bratwurst.parse.Emoji.SUSHI;

/**
 * Created by dedda on 12/21/15.
 *
 * @author dedda
 */
public class ExampleFunction_SUSHI_ELEPHANT extends BWFunction {
    public ExampleFunction_SUSHI_ELEPHANT() {
        super(SUSHI + ELEPHANT, new BWInstruction[]{

        });
    }
}
