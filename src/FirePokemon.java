public class FirePokemon extends Pokemon {

    public FirePokemon() {

    }

    public void uniqueAbility () { //O(1)
        int randomNum = Constants.RANDOM.nextInt(Constants.MAXIMUM_PERCENTAGE) + 1;
        if (randomNum <= Constants.SELF_ATTACK_PROBABILITY) {
            int selfDamageAmount = Constants.RANDOM.nextInt(Constants.MINIMUM_SELF_DAMAGE, Constants.MAXIMUM_SELF_DAMAGE + 1);
            int result = this.getCurrentHealth() - selfDamageAmount;
            this.setCurrentHealth(result);
            System.out.println("You damage yourself by " + selfDamageAmount + " points");
        }
    }

    public Pokemon createCopy() { //O(1)
        FirePokemon other = new FirePokemon();
        this.copyVariables(other);
        return other;
    }
    public boolean tryToKill(Pokemon other) { //O(n)
        boolean result = super.tryToKill(other);
        uniqueAbility();
        if(!result && this.getCurrentHealth() <=0){
            System.out.println("You killed yourself");
            result = true;
        }
        return result;
    }

    public int specialPower() { //O(1)
        int result = Constants.SPECIAL_POWER_FAILED;
        if (this.getCurrentHealth()/2>Constants.NO_HEALTH) {
            this.setCurrentHealth(this.getCurrentHealth()/2);
            this.setCurrentAttackPoints(Constants.NO_ATTACK_POINTS);
            result = Constants.SPECIAL_POWER_DOUBLE_DAMAGE;
        } else {
            System.out.println("You cant do special power because you will die");
        }
        return result;
    }

    public FirePokemon (String name, int level, int maximumHealth, int maximumAttack, Attack[] attacks) { //O(1)
        super(name,level,maximumHealth,maximumAttack, attacks);
    }

}
