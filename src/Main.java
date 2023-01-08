public class Main {
    public static void main(String[] args) {
      Pokemon[] firstPlayer = deepCopyPokemonArray(Constants.PIKACHU);
      Pokemon[] secondPlayer = deepCopyPokemonArray(Constants.PIKACHU);
      firstPlayer[0].calculateStartGameStats();
        System.out.println(firstPlayer[1]);
        System.out.println(secondPlayer[0]);
    }

    private static Pokemon[] deepCopyPokemonArray(Pokemon[] pokemon) {
        Pokemon[] copyArray = new Pokemon[pokemon.length];
        for (int i = 0; i < copyArray.length; i++) {
            if (pokemon[i].getType() == Constants.ELECTRIC_TYPE) {
                copyArray[i] = new ElectricPokemon(pokemon[i]); // Create a new instance of ElectricPokemon using the copy constructor
            } else if (pokemon[i].getType() == Constants.FIRE_TYPE) {
                copyArray[i] = new FirePokemon(pokemon[i]); // Create a new instance of FirePokemon using the copy constructor
            }
        }
        return copyArray;
    }
}