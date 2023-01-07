public class ElectricPokemon extends Pokemon implements ElectricAbility {
    private int electricity;

    public ElectricPokemon (String name, int level, int maximumHealth, int maximumAttack, Attack[] attacks) {
        this.setName(name);
        this.setLevel(level);
        this.setMaximumHealth(maximumHealth);
        this.setCurrentHealth(maximumHealth);
        this.setMaximumAttackPoints(maximumAttack);
        this.addAttack(attacks);
        this.setCurrentAttackPoints();
    }

    public void charge() {

    }
}
