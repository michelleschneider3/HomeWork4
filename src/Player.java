public class Player {
    private String name;
    private int level;
    private Pokemon[] pokemon;

    public Player(String name, Pokemon[] pokemon) {
        this.name = name;
        this.level = Constants.FIRST_LEVEL;
        this.pokemon = pokemon;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Pokemon[] getPokemon() {
        return pokemon;
    }

    public boolean levelUp () {
        boolean result = false;
        if (this.level < this.getPokemon().length) {
            if (this.pokemon[this.level-1].canEvolve(Constants.MINIMUM_HEALTH_REQUIRED_PER_LEVEL[this.level-1],
                    Constants.MINIMUM_ATTACK_POINTS_REQUIRED_PER_LEVEL[this.level-1])) {
                this.pokemon[this.level].getCurrents(this.pokemon[this.level-1]);
                this.level++;
                result = true;
                System.out.println("You have leveled up");
            }
        } else {
            System.out.println("You are at your max level");
        }
        return result;
    }

    public String toString(){
        return this.pokemon[this.level-1] + " (" + this.name + ")";
    }
}
