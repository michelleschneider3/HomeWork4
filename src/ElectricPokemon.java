public class ElectricPokemon extends Pokemon {
    private int electricity;
    private int type;

    public void uniqueAbility () {
        if (checkIfNearDeath()) {
            this.electricity = 0;
        } else {
            this.electricity += Constants.ELECTRICITY_BOOST;
        }
        for (int i = 0; i < this.getAttacks().length; i++) {
            this.getAttacks()[i].setBonusDamage(this.electricity);
        }
    }

    private boolean checkIfNearDeath () {
        boolean result = false;
        int nearDeathNumber = (this.getMaximumHealth()*Constants.NEAR_DEATH_PERCENTAGE)/Constants.MAXIMUM_PERCENTAGE;
        if (this.getCurrentHealth()<=nearDeathNumber) {
            result = true;
        }
        return result;
    }

    public boolean makeAttack(Pokemon other) {
        this.uniqueAbility();
        return super.makeAttack(other);
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

    public String toString () {
        return super.toString() + " Electricity: " + this.electricity;
    }

}
