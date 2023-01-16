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
        boolean result = super.makeAttack(other);
        uniqueAbility();
        return result;
    }

    public int specialPower() {
        int result = Constants.SPECIAL_POWER_FAILED;
        if (this.getCurrentHealth()/2>0) {
            this.setCurrentHealth(this.getCurrentHealth() / 2);
            this.setCurrentAttackPoints(0);
            result = Constants.SPECIAL_POWER_DOUBLE_DAMAGE;
        }
        return result;
    };

    public boolean giveDoubleDamage (Pokemon other) {
        int index;
        int damage=0;
        boolean isDead=false;
        for (int i = 0; i < 2; i++) {
            index = Constants.RANDOM.nextInt(this.getAttacks().length);
            damage += calculateDamage(this.getAttacks()[index]);
        }
        other.setCurrentHealth(other.getCurrentHealth()-damage);
        if (other.getCurrentHealth()<=0) {
            isDead=true;
        }
        return isDead;
    }
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
