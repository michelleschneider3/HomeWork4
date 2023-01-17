import java.util.Random;
import java.util.Scanner;

public class Constants {
    public static final int START_ATTACK_POINTS_PERCENTAGE = 75;
    public static final int MAXIMUM_PERCENTAGE = 100;

    public static final int SELF_ATTACK_PROBABILITY = 25;

    public static final int MINIMUM_SELF_DAMAGE = 3;

    public static final int MAXIMUM_SELF_DAMAGE = 10;

    public static final int NEAR_DEATH_PERCENTAGE = 20;

    public static final int ELECTRICITY_BOOST = 5;

    public static final int SKIP_BONUS_ONE = 1;

    public static final int SKIP_BONUS_TWO = 2;

    public static final int SKIP_BONUS_THREE = 3;

    public static final int MINIMUM_BONUS_HEALTH = 5;

    public static final int MAXIMUM_BONUS_HEALTH = 30;

    public static final int MINIMUM_ATTACK_POINTS = 0;

    public static final int MAXIMUM_ATTACK_POINTS = 40;

    public static final int SPECIAL_POWER_FAILED = -1;

    public static final int SPECIAL_POWER_SUCCESSFUL = 1;

    public static final int SPECIAL_POWER_DOUBLE_DAMAGE = 2;

    public static final int MINIMUM_PERK_PER_TURN = 0;

    public static final int MAXIMUM_PERK_PER_TURN = 4;

    public static final int NO_HEALTH = 0;

    public static final int NO_ATTACK_POINTS = 0;

    public static final int[] MINIMUM_HEALTH_REQUIRED_PER_LEVEL = {20, 30};

    public static final int[] MINIMUM_ATTACK_POINTS_REQUIRED_PER_LEVEL = {25, 40};

    public static final int CHOOSE_ATTACK = 1;

    public static final int SKIP_TURN = 2;

    public static final int LEVEL_UP = 3;

    public static final int SPECIAL_POWER = 4;

    public static final int FIRST_LEVEL = 1;
    public static final Random RANDOM = new Random();

    public static final Scanner SCANNER = new Scanner(System.in);
}
