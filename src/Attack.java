public class Attack {
    private String name;
    private int attackPointsCost;
    private int minimumDamage;
    private int maximumDamage;

    public Attack (String name, int attackPointsCost, int minimumDamage, int maximumDamage) {
        this.name = name;
        this.attackPointsCost = attackPointsCost;
        this.minimumDamage = minimumDamage;
        this.maximumDamage = maximumDamage;
    }

    public int randomizeDamage () {
        int result;
        if (this.minimumDamage == this.maximumDamage) {
            result = this.maximumDamage;
        } else {
            result = Constants.RANDOM.nextInt(this.minimumDamage, this.maximumDamage);
        }
        return result;
    }

}
