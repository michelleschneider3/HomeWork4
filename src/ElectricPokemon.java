public class ElectricPokemon extends Pokemon {
    private int electricity;
    private int type;

    public void uniqueAbility () {

    }

    public void specialPower() {

    };

    public ElectricPokemon (String name, int level, int maximumHealth, int maximumAttack, Attack[] attacks) {
        super(name,level,maximumHealth,maximumAttack, attacks);
        this.type = Constants.ELECTRIC_TYPE;
    }

    public int getType() {
        return type;
    }

    public ElectricPokemon(Pokemon other) {
        super(other);
    }


    public void charge() {

    }

}
