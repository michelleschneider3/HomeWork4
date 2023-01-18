public class ElectricPokemon extends Pokemon {
    private int electricity;

    private boolean isSpecialPowerUsed;

    public ElectricPokemon() {
        super();
    }

    public void uniqueAbility () { //O(n)
        for (int i = 0; i < this.getAttacks().length; i++) {
            this.getAttacks()[i].setBonusDamage(this.electricity);
        }
    }


    public Pokemon createCopy() { //O(1)
        ElectricPokemon other = new ElectricPokemon();
        this.copyVariables(other);
        return other;
    }

    public void skipTurn(){ //O(1)
        super.skipTurn();
        this.calculateElectricity();
    }

    private void calculateElectricity () { //O(1)
        this.electricity += Constants.ELECTRICITY_BOOST;
    }

    protected void takeDamage (int damage) { //O(n)
        super.takeDamage(damage);
        if(checkIfNearDeath()){
            this.electricity = 0;
        }
    }

    private boolean checkIfNearDeath () { //O(1)
        boolean result = false;
        int nearDeathNumber = (this.getMaximumHealth()*Constants.NEAR_DEATH_PERCENTAGE)/Constants.MAXIMUM_PERCENTAGE;
        if (this.getCurrentHealth()<=nearDeathNumber) {
            result = true;
        }
        return result;
    }

    public boolean tryToKill(Pokemon other) { //O(n)
        this.uniqueAbility();
        boolean result = super.tryToKill(other);
        this.calculateElectricity();
        return result;
    }

    public int specialPower() { //O(1)
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

    public ElectricPokemon (String name, int level, int maximumHealth, int maximumAttack, Attack[] attacks) { //O(1)
        super(name,level,maximumHealth,maximumAttack, attacks);
    }

    public void getCurrents(Pokemon previousLevel) { //O(1)
        super.getCurrents(previousLevel);
        this.electricity = ((ElectricPokemon) previousLevel).electricity;
        this.isSpecialPowerUsed = ((ElectricPokemon) previousLevel).isSpecialPowerUsed;
        this.calculateElectricity();
    }

    public String toString () { //O(1)
        return super.toString() + " Electricity: " + this.electricity;
    }

}
