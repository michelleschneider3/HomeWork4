public class FirePokemon extends Pokemon {
    private int type;

    public void uniqueAbility () {

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
