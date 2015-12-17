package org.dedda.bratwurst.parse;

/**
 * Created by dedda on 12/17/15.
 *
 * @author dedda
 */
public class Emoji {

    public static final String GRINNING_FACE = forInt(0x1F600);
    public static final String GRINNING_FACE_SMILING_EYES = forInt(0x1F601);
    public static final String GRINNING_FACE_TEARS = forInt(0x1F602);
    public static final String COOL_FACE = forInt(0x1F30E);
    public static final String SMILE_HEART_EYES = forInt(0x1F60D);
    public static final String KISS_FACE_HEART = forInt(0x1F618);
    public static final String BLUSH_SMILING = forInt(0x263A);
    public static final String SMILING = forInt(0x1F642);
    public static final String ANGEL_FACE = forInt(0x1F607);
    public static final String NEUTRAL = forInt(0x1F610);
    public static final String MOUTHLESS = forInt(0x1F636);
    public static final String ROLLING_EYES = forInt(0x1F644);
    public static final String SMIRKING = forInt(0x1F60F);
    public static final String DOH = forInt(0x1F623);
    public static final String ZIPPER_MOUTH = forInt(0x1F910);
    public static final String SLEEPING_FACE = forInt(0x1F634);
    public static final String NERD = forInt(0x1F913);
    public static final String TONGUE_OUT_WINK = forInt(0x1F61C);
    public static final String UNAMUSED = forInt(0x1F641);
    public static final String MEH = forInt(0x1F615);
    public static final String UPSIDE_DOWN = forInt(0x1F643);
    public static final String DOCTOR_MASK = forInt(0x1F637);
    public static final String ILL_THERMOMETER = forInt(0x1F912);
    public static final String ILL_BANDAGE = forInt(0x1F915);
    public static final String MONEY_MOUTH = forInt(0x1F911);
    public static final String CRYING_HARD = forInt(0x1F62D);
    public static final String X_X = forInt(0x1F635);
    public static final String SKULL = forInt(0x1F480);
    public static final String SKULL_BONES = forInt(0x2620);
    public static final String GHOST = forInt(0x1F47B);
    public static final String ALIEN = forInt(0x1F47D);
    public static final String ROBOT_FACE = forInt(0x1F916);
    public static final String POOP = forInt(0x1F4A9);
    public static final String FLEX = forInt(0x1F4AA);
    public static final String SPOCK = forInt(0x1F596);
    public static final String METAL = forInt(0x1F918);
    public static final String ALL_OK = forInt(0x1F44C);
    public static final String HEART_BIG = forInt(0x2764);
    public static final String BOMB = forInt(0x1F4A3);

    public static String forInt(int code) {
        return String.valueOf(Character.toChars(code));
    }

}
