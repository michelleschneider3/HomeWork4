public class ElectricPokemon extends Pokemon implements ElectricAbilities {
    private int electricity;

    public ElectricPokemon (String name, int level, int maximumHealth, int maximumAttack, Attack[] attacks) {
        super(name,level,maximumHealth,maximumAttack, attacks);
    }

    public void charge() {

    }

}
