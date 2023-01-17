public abstract class Pokemon {
    private String name;
    private int level;
    private int maximumHealth;

    private int currentHealth;
    private int maximumAttackPoints;

    private int currentAttackPoints;
    private Attack[] attacks;

    private boolean tripleDamage;

    public abstract int specialPower();

    public abstract void uniqueAbility ();
    public abstract Pokemon createCopy();
    protected Pokemon(String name, int level, int maximumHealth, int maximumAttack, Attack[] attacks){
        this.name = name;
        this.level = level;
        this.maximumHealth = maximumHealth;
        this.maximumAttackPoints = maximumAttack;
        this.addAttacks(attacks);
        if (level == 1) {
            this.calculateStartGameStats();
        }
    }

    public Pokemon() {

    }

    protected void copyVariables(Pokemon other){
        other.name = this.name;
        other.level = this.level;
        other.maximumHealth = this.maximumHealth;
        other.maximumAttackPoints = this.maximumAttackPoints;
        other.attacks = this.attacks;
        other.currentHealth = this.currentHealth;
        other.currentAttackPoints = this.currentAttackPoints;
        other.tripleDamage = this.tripleDamage;
    }

    public String getName() {
        return name;
    }

    public int getMaximumHealth() {
        return maximumHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentAttackPoints(int currentAttackPoints) {
        this.currentAttackPoints = currentAttackPoints;
    }

    public int getMaximumAttackPoints() {
        return maximumAttackPoints;
    }

    public Attack[] getAttacks() {
        return attacks;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    private void calculateStartGameStats() {
        this.currentHealth = this.maximumHealth;
        this.currentAttackPoints = calculateStartAttackPoints(this.maximumAttackPoints);
        this.addAttacks(AttackArchive.KICK);
    }

    public void addAttacks (Attack[] newAttacks) {
        int arrayLength = 0;
        if (this.attacks != null) {
            arrayLength = this.attacks.length;
        }
        Attack[] largerArray = new Attack[arrayLength + newAttacks.length];
        for (int i = 0; i < arrayLength; i++) {
            largerArray[i] = attacks[i];
        }
        int currentIndex = arrayLength;
        int i = 0;
        do {
            largerArray[currentIndex] = newAttacks[i];
            currentIndex++;
            i++;
        } while (i != newAttacks.length);
        this.attacks = largerArray;
    }

    private int calculateStartAttackPoints (int maximumAttackPoints) {
        return (Constants.START_ATTACK_POINTS_PERCENTAGE*maximumAttackPoints)/Constants.MAXIMUM_PERCENTAGE;
    }

    public String toString(){
        String outPut = "";
        outPut += "Name: " + this.name;
        outPut += ", Lvl: " + this.level;
        outPut += ", Hp: " + this.currentHealth + "/" + this.maximumHealth;
        outPut += ", Attack Pts: " + this.currentAttackPoints + "/" + this.maximumAttackPoints;
        return outPut;
    }

    private String printAttacks() {
        String result = "";

        if (this.attacks != null) {
            for (int i = 0; i < attacks.length; i++) {
                int num = i+1;
                result += "\n" + num + ". " + attacks[i].toString() +  ((this.tripleDamage)? " (x3)" :  "");
            }
        }
        return result;
    }

    public boolean tryToKill(Pokemon other) {
        int userInput;
        do {
            userInput = chooseAttack();
        } while (!checkPoints(userInput));
        this.currentAttackPoints-= this.attacks[userInput-1].getAttackPointsCost();
        int damage = this.calculateDamage(this.attacks[userInput-1]);
        other.takeDamage(damage);
        boolean result = other.checkIfDead();
        if(result){
            System.out.println("Your opponent ("+ other.name + ") has died");
        }
        return result;
    }



    private boolean checkIfAttackExist (int userInput) {
        boolean result = false;
        if (this.attacks.length>=userInput && userInput>0) {
            result = true;
        } else {
            System.out.println("Please choose valid option");
        }
        return result;
    }

    private int chooseAttack () {
        int userInput;
        do {
            System.out.println(this.printAttacks());
            userInput = Constants.SCANNER.nextInt();
            Constants.SCANNER.nextLine();
        } while (!checkIfAttackExist(userInput));
        return userInput;
    }

    private boolean checkPoints (int userInput) {
        boolean result = false;
        if (this.currentAttackPoints>=this.attacks[userInput-1].getAttackPointsCost()) {
            result = true;
        } else {
            System.out.println("You dont have enough points");
        }
        return result;
    }

    protected void takeDamage (int damage) {
        removeBonus();
        this.setCurrentHealth(this.getCurrentHealth()-damage);
    }

    protected int calculateDamage(Attack attack){
        int damage = attack.randomizeDamage();
        if(this.tripleDamage){
            damage *= 3;
            this.tripleDamage = false;
        }
        return damage;
    }

    private void removeBonus () {
        for (int i = 0; i < this.attacks.length; i++) {
            this.attacks[i].setBonusDamage(0);
        }
    }

    private boolean checkIfDead () {
        boolean isDead = false;
        if (this.currentHealth<=0) {
            isDead = true;
        }
        return isDead;
    }

    public void skipTurn () {
        int bonus = Constants.RANDOM.nextInt(Constants.SKIP_BONUS_ONE, Constants.SKIP_BONUS_THREE+1);
        switch(bonus) {
            case Constants.SKIP_BONUS_ONE -> this.receiveHealth();
            case Constants.SKIP_BONUS_TWO -> this.receiveAttackPoints();
            case Constants.SKIP_BONUS_THREE -> this.receiveTripleDamage();
        }
    }

    private void receiveHealth () {
        int bonusHealth = Constants.RANDOM.nextInt(Constants.MINIMUM_BONUS_HEALTH, Constants.MAXIMUM_BONUS_HEALTH+1);
        bonusHealth = removeDifferenceFromMax(bonusHealth,currentHealth,maximumHealth);
        this.currentHealth += bonusHealth;
        System.out.println("You received " + bonusHealth + " Hp");
    }

    private void receiveAttackPoints () {
        int bonusAttackPoints = Constants.RANDOM.nextInt(Constants.MINIMUM_ATTACK_POINTS, Constants.MAXIMUM_ATTACK_POINTS+1);
        bonusAttackPoints = removeDifferenceFromMax(bonusAttackPoints,currentAttackPoints,maximumAttackPoints);
        this.currentAttackPoints += bonusAttackPoints;
        System.out.println("You received " + bonusAttackPoints + " Attack points");
    }

    private int removeDifferenceFromMax(int num, int currentPoints, int maxPoints){
        if(num + currentPoints > maxPoints){
            int difference = (num + currentPoints) - maxPoints;
            num -= difference;
        }
        return num;
    }

    private void receiveTripleDamage() {
        this.tripleDamage = true;
        System.out.println("You will have x3 damage for your next attack");
    }

    public boolean canEvolve (int minimumHealthRequired, int minimumAttackPointsRequired) {
        boolean result = false;
        if (this.currentHealth > minimumHealthRequired) {
            if (this.currentAttackPoints > minimumAttackPointsRequired) {
                result = true;
            } else {
                System.out.println("You dont have enough Attack points to evolve. min required: " + minimumAttackPointsRequired);
            }
        } else {
            System.out.println("You dont have enough Hp to evolve. min required: " + minimumHealthRequired);
        }
        return result;
    }

    public void getCurrents (Pokemon previousLevel) {
        this.currentHealth = previousLevel.currentHealth;
        this.currentAttackPoints = previousLevel.currentAttackPoints;
        this.addAttacks(previousLevel.attacks);
        this.tripleDamage = previousLevel.tripleDamage;
    }
    public boolean takeDoubleDamage (Pokemon current) {
        int index;
        int damage = 0;

        for (int i = 0; i < 2; i++) {
            index = Constants.RANDOM.nextInt(current.getAttacks().length);
            damage += calculateDamage(current.getAttacks()[index]);
        }
        System.out.println("You double attack your opponent and damaged him with " + damage + " points");
        this.takeDamage(damage);

        return this.checkIfDead();
    }

    public void receivePerksPerTurn() {
        int healthBoost = Constants.RANDOM.nextInt(Constants.MINIMUM_PERK_PER_TURN,Constants.MAXIMUM_PERK_PER_TURN);
        int attackBoost = Constants.RANDOM.nextInt(Constants.MINIMUM_PERK_PER_TURN,Constants.MAXIMUM_PERK_PER_TURN);
        healthBoost = removeDifferenceFromMax(healthBoost, this.currentHealth, this.maximumHealth);
        attackBoost = removeDifferenceFromMax(attackBoost, this.currentAttackPoints, this.maximumAttackPoints);
        this.currentHealth +=healthBoost;
        this.currentAttackPoints +=attackBoost;
        System.out.print("You received " + healthBoost + " Hp and " + attackBoost + " attack points for your next turn ");
    }
}
