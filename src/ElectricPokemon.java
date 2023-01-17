public class ElectricPokemon extends Pokemon {
    private int electricity;

    private boolean isSpecialPowerUsed;

    public ElectricPokemon() {
        super();
    }

    public void uniqueAbility () {
        for (int i = 0; i < this.getAttacks().length; i++) {
            this.getAttacks()[i].setBonusDamage(this.electricity);
        }
    }


    public Pokemon createCopy() {
        ElectricPokemon other = new ElectricPokemon();
        this.copyVariables(other);
        return other;
    }

    public void skipTurn(){
        super.skipTurn();
        this.calculateElectricity();
    }

    private void calculateElectricity () {
        this.electricity += Constants.ELECTRICITY_BOOST;
    }

    protected void takeDamage (int damage) {
        super.takeDamage(damage);
        if(checkIfNearDeath()){
            this.electricity = 0;
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

    public boolean tryToKill(Pokemon other) {
        this.uniqueAbility();
        boolean result = super.tryToKill(other);
        this.calculateElectricity();
        return result;
    }

    public int specialPower() {
        int result=Constants.SPECIAL_POWER_FAILED;
        if (!isSpecialPowerUsed) {
            this.setCurrentHealth(this.getMaximumHealth());
            this.setCurrentAttackPoints(this.getMaximumAttackPoints());
            isSpecialPowerUsed = true;
            result = Constants.SPECIAL_POWER_SUCCESSFUL;
            this.calculateElectricity();
            System.out.println("You have boosted your health and attack points to maximum");
        } else {
            System.out.println("You have already used your special power");
        }
        return result;
    }

    public ElectricPokemon (String name, int level, int maximumHealth, int maximumAttack, Attack[] attacks) {
        super(name,level,maximumHealth,maximumAttack, attacks);
    }

    public void getCurrents(Pokemon previousLevel) {
        super.getCurrents(previousLevel);
        this.electricity = ((ElectricPokemon) previousLevel).electricity;
        this.isSpecialPowerUsed = ((ElectricPokemon) previousLevel).isSpecialPowerUsed;
        this.calculateElectricity();
    }

    public String toString () {
        return super.toString() + " Electricity: " + this.electricity;
    }

}
