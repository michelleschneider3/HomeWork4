import java.util.Random;

public class FirePokemon extends Pokemon {
    private int type;

    public void uniqueAbility () {
        int randomNum = Constants.RANDOM.nextInt(Constants.MAXIMUM_PERCENTAGE) + 1;
        if (randomNum <= Constants.SELF_ATTACK_PROBABILITY) {
            int selfDamageAmount = Constants.RANDOM.nextInt(Constants.MINIMUM_SELF_DAMAGE, Constants.MAXIMUM_SELF_DAMAGE + 1);
            int result = this.getCurrentHealth() - selfDamageAmount;
            this.setCurrentHealth(result);
            System.out.println("You damage yourself by " + selfDamageAmount + " points");
        }
    }

    public boolean makeAttack (Pokemon other) {
        uniqueAbility();
        return super.makeAttack(other);
    }

    public void specialPower() {

    };
    public FirePokemon (String name, int level, int maximumHealth, int maximumAttack, Attack[] attacks) {
        super(name,level,maximumHealth,maximumAttack, attacks);
        this.type = Constants.FIRE_TYPE;
    }

    public int getType() {
        return type;
    }

    public FirePokemon (Pokemon other) {
        super(other);
    }

    public void selfDamage () {

    }
}
