public class FirePokemon extends Pokemon implements FireAbility{

    public FirePokemon (String name, int level, int maximumHealth, int maximumAttack, Attack[] attack) {
        this.setName(name);
        this.setLevel(level);
        this.setMaximumHealth(maximumHealth);
        this.setCurrentHealth(maximumHealth);
        this.setMaximumAttackPoints(maximumAttack);
        this.addAttack(attack);
        this.setCurrentAttackPoints();
    }

    public void selfDamage () {

    }
}
