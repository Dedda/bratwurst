package org.dedda.bratwurst.example;

import org.dedda.bratwurst.lang.BWClass;
import org.dedda.bratwurst.lang.BWFunction;

import static org.dedda.bratwurst.parse.Emoji.*;

/**
 * Created by dedda on 12/21/15.
 *
 * @author dedda
 */
public class ExampleClass_TULIP_BABY_BEER extends BWClass {

    public ExampleClass_TULIP_BABY_BEER() {
        super(TULIP + BABY + BEER, new BWFunction[]{
                new ExampleFunction_TULIP_BABY_BEER___MEH_DONUT(),
                new ExampleFunction_TULIP_BABY_BEER___SPOCK_SPIDER()
        });
    }
}
