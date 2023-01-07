public abstract class Pokemon {
    private String name;
    private int level;
    private int maximumHealth;

    private int currentHealth;
    private int maximumAttackPoints;

    private int currentAttackPoints;
    private Attack[] attacks;

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
        this.maximumAttackPoints = maximumAttackPoints;
    }

    public void addAttack (Attack[] attack) {
        int arrayLength = 0;
        if (this.attacks != null) {
            arrayLength = this.attacks.length;
        }
        Attack[] largerArray = new Attack[arrayLength + attack.length];
        for (int i = 0; i < arrayLength; i++) {
            largerArray[i] = attacks[i];
        }
        int currentIndex = arrayLength;
        int i = 0;
        do {
            largerArray[currentIndex] = attack[i];
            currentIndex++;
            i++;
        } while (i != attack.length);
        this.attacks = largerArray;
    }

    public int getCurrentAttackPoints() {
        return currentAttackPoints;
    }

    public void setCurrentAttackPoints() {
        this.currentAttackPoints = calculateStartAttackPoints();
    }

    protected int calculateStartAttackPoints () {
        return (Constants.START_ATTACK_POINTS_PERCENTAGE*this.maximumAttackPoints)/Constants.MAXIMUM_ATTACK_POINTS_PERCENTAGE;
    }
}
