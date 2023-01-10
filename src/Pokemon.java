public abstract class Pokemon {
    private String name;
    private int level;
    private int maximumHealth;

    private int currentHealth;
    private int maximumAttackPoints;

    private int currentAttackPoints;
    private Attack[] attacks;

    public abstract int getType();

    public abstract void specialPower();

    public abstract void uniqueAbility ();
    protected Pokemon(String name, int level, int maximumHealth, int maximumAttack, Attack[] attacks){
        this.name = name;
        this.level = level;
        this.maximumHealth = maximumHealth;
        //this.currentHealth = maximumHealth;
        this.maximumAttackPoints = maximumAttack;
        this.addAttacks(attacks);
        //this.setCurrentAttackPoints();
        if (level == 1) {
            this.calculateStartGameStats();
        }
    }

    public Pokemon(Pokemon other){
        this.name = other.name;
        this.level = other.level;
        this.maximumHealth = other.maximumHealth;
        this.maximumAttackPoints = other.maximumAttackPoints;
        this.attacks = other.attacks;
        this.currentHealth = other.currentHealth;
        this.currentAttackPoints = other.currentAttackPoints;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getMaximumHealth() {
        return maximumHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaximumAttackPoints() {
        return maximumAttackPoints;
    }

    public Attack[] getAttacks() {
        return attacks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMaximumHealth(int maximumHealth) {
        this.maximumHealth = maximumHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setMaximumAttackPoints(int maximumAttackPoints) {
        //this.maximumAttackPoints = maximumAttackPoints;
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

    public int getCurrentAttackPoints() {
        return currentAttackPoints;
    }

    private int calculateStartAttackPoints (int maximumAttackPoints) {
        return (Constants.START_ATTACK_POINTS_PERCENTAGE*maximumAttackPoints)/Constants.MAXIMUM_ATTACK_POINTS_PERCENTAGE;
    }

    public String toString(){
        String outPut = "-------------------------------------------------";
        outPut += "\nName: " + this.name;
        outPut += ", Lvl: " + this.level;
        outPut += ", Hp: " + this.currentHealth + "/" + this.maximumHealth;
        outPut += ", Attack Pts: " + this.currentAttackPoints + "/" + this.maximumAttackPoints;
        outPut += printAttacks();
        outPut += "\n-------------------------------------------------";
        return outPut;
    }

    private String printAttacks() {
        String result = "";
        if (this.attacks != null) {
            for (int i = 0; i < attacks.length; i++) {
                int num = i+1;
                result += "\n" + num + ". " + attacks[i].toString();
            }
        }
        return result;
    }
}
