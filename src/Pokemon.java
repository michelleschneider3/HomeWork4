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
        return (Constants.START_ATTACK_POINTS_PERCENTAGE*maximumAttackPoints)/Constants.MAXIMUM_PERCENTAGE;
    }

    public String toString(){
        String outPut = "-------------------------------------------------";
        outPut += "\nName: " + this.name;
        outPut += ", Lvl: " + this.level;
        outPut += ", Hp: " + this.currentHealth + "/" + this.maximumHealth;
        outPut += ", Attack Pts: " + this.currentAttackPoints + "/" + this.maximumAttackPoints;
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

    public boolean makeAttack (Pokemon other) {
        int userInput;
        do {
            userInput = chooseAttack();
        } while (!checkPoints(userInput));
        this.currentAttackPoints-= this.attacks[userInput-1].getAttackPointsCost();
        this.takeDamage(this.attacks[userInput-1], other);
        return this.checkIfDead(other);
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

    private void takeDamage (Attack attack, Pokemon other) {
        int damage = attack.randomizeDamage();
        other.setCurrentHealth(other.getCurrentHealth()-damage);
    }

    protected void charge ()

    private boolean checkIfDead (Pokemon other) {
        boolean isDead = false;
        if (other.currentHealth<=0) {
            isDead = true;
        }
        return isDead;
    }
}
