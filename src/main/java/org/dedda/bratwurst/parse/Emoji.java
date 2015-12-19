package org.dedda.bratwurst.parse;

import java.io.FileOutputStream;

/**
 * Created by dedda on 12/17/15.
 *
 * @author dedda
 */
public class Emoji {

    // Faces:
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
    public static final String CAT_HEART_EYES = forInt(0x1F63B);
    public static final String BOY = forInt(0x1F466);
    public static final String GIRL = forInt(0x1F467);
    public static final String MAN = forInt(0x1F468);
    public static final String WOMAN = forInt(0x1F469);
    public static final String GRAND_PA = forInt(0x1F474);
    public static final String GRAND_MA = forInt(0x1F475);
    public static final String BABY = forInt(0x1F476);
    public static final String POLICE = forInt(0x1F46E);
    public static final String TURBAN = forInt(0x1F473);
    public static final String SANTA = forInt(0x1F385);
    public static final String FLEX = forInt(0x1F4AA);
    public static final String SPOCK = forInt(0x1F596);
    public static final String METAL = forInt(0x1F918);
    public static final String ALL_OK = forInt(0x1F44C);
    public static final String HEART_BIG = forInt(0x2764);
    public static final String BOMB = forInt(0x1F4A3);
    public static final String EXPLOSION = forInt(0x1F4A5);
    public static final String SQUIRT = forInt(0x1F4A6);
    public static final String CROWN = forInt(0x1F451);
    public static final String DIAMOND = forInt(0x1F48E);

    // Animals:
    public static final String MONKEY_FACE = forInt(0x1F435);
    public static final String POODLE = forInt(0x1F429);
    public static final String TIGER = forInt(0x1F405);
    public static final String UNICORN = forInt(0x1F984);
    public static final String PIG = forInt(0x1F416);
    public static final String ELEPHANT = forInt(0x1F418);
    public static final String BABY_CHICK = forInt(0x1F425);
    public static final String SNAKE = forInt(0x1F40D);
    public static final String OCTOPUS = forInt(0x1F419);
    public static final String LADY_BUG = forInt(0x1F41E);
    public static final String SPIDER = forInt(0x1F577);

    // Plants and fungi:
    public static final String ROSE = forInt(0x1F339);
    public static final String TULIP = forInt(0x1F337);
    public static final String SUNFLOWER = forInt(0x1F33B);
    public static final String EVERGREEN = forInt(0x1F332);
    public static final String TREE_REGULAR = forInt(0x1F333);
    public static final String PALM = forInt(0x1F334);
    public static final String CACTUS = forInt(0x1F335);
    public static final String CLOVER = forInt(0x1F340);
    public static final String WATER_MELON = forInt(0x1F349);
    public static final String LEMON = forInt(0x1F34B);
    public static final String BANANA = forInt(0x1F34C);
    public static final String PINEAPPLE = forInt(0x1F34D);
    public static final String APPLE_GREEN = forInt(0x1F34F);
    public static final String PEAR = forInt(0x1F350);
    public static final String CHERRIES = forInt(0x1F352);
    public static final String STRAWBERRY = forInt(0x1F353);
    public static final String AUBERGINE = forInt(0x1F346);
    public static final String CORN = forInt(0x1F33D);
    public static final String MUSHROOM = forInt(0x1F344);

    // Food:
    public static final String BREAD = forInt(0x1F35E);
    public static final String CHEESE = forInt(0x1F9C0);
    public static final String POULTRY_LEG = forInt(0x1F357);
    public static final String HAMBURGER = forInt(0x1F354);
    public static final String FRIES = forInt(0x1F35F);
    public static final String SLICE_PIZZA = forInt(0x1F355);
    public static final String HOT_DOG = forInt(0x1F32D);
    public static final String POPCORN = forInt(0x1F37F);
    public static final String SOUP_BOWL_STEAMING = forInt(0x1F35C);
    public static final String SPAGHETTI = forInt(0x1F35D);
    public static final String SUSHI = forInt(0x1F363);
    public static final String FRIED_SHRIMP = forInt(0x1F364);
    public static final String SOFT_ICE = forInt(0x1F366);
    public static final String DONUT = forInt(0x1F369);
    public static final String COOKIE = forInt(0x1F36A);
    public static final String BIRTHDAY_CAKE = forInt(0x1F382);
    public static final String CAKE_PIECE = forInt(0x1F370);
    public static final String CHOCOLATE = forInt(0x1F36B);
    public static final String CANDY = forInt(0x1F36C);
    public static final String LOLLIPOP = forInt(0x1F36D);
    public static final String BABY_BOTTLE = forInt(0x1F37C);
    public static final String CHAMPAGNE = forInt(0x1F37E);
    public static final String WINE = forInt(0x1F377);
    public static final String COCKTAIL = forInt(0x1F378);
    public static final String BEER = forInt(0x1F37A);
    public static final String TWO_BEERS = forInt(0x1F37B);

    public static String forInt(int code) {
        return String.valueOf(Character.toChars(code));
    }

}
