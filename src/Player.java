public class Player {
    private String name;
    private int level;
    private Pokemon[] pokemon;

    public Player(String name, int level, Pokemon[] pokemon) {
        this.name = name;
        this.level = level;
        this.pokemon = pokemon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Pokemon[] getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon[] pokemon) {
        this.pokemon = pokemon;
    }

    public boolean levelUp () {
        boolean result = false;
        if (this.level < this.getPokemon().length) {
            int[] minimumHealthRequired = {20, 30};
            int[] minimumAttackPoints = {25, 40};
            if (this.pokemon[this.level-1].canEvolve(minimumHealthRequired[this.level-1], minimumAttackPoints[this.level-1])) {
                this.pokemon[this.level].getCurrents(this.pokemon[this.level-1]);
                this.level++;
                result = true;
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
