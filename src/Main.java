public class Main {
    public static void main(String[] args) {
      Pokemon[] firstPlayer = assignNewPokemon();
      Pokemon[] secondPlayer = assignNewPokemon();
      Pokemon[] currentPlayer = firstPlayer;
        welcomeMessage();
//        System.out.println(firstPlayer[0]);
//        System.out.println(secondPlayer[1]);
    }

    private static void fightMenu(Pokemon[] currentPlayer) {
        System.out.println("""
                Choose from the options below
                1. Choose Attack
                2. Skip turn
                3. Level up
                4. Special power
                """);
    }
    private static void welcomeMessage () {
        System.out.println("""
                Welcome to our Pokemon fight game!!!,
                Here is a little info about our game:
                It is a player against player type of game, each turn the current player switches
                Upon running the game you and your opponent were assigned with a random pokemon from our database
                After starting you will see info about your and opponents pokemon
                First player will start the game and will be able to choose from the options bellow

                PRESS ENTER TO START""");
        Constants.SCANNER.nextLine();
        System.out.println("start");
    }
    private static Pokemon[] switchPlayer (Pokemon[] firstPlayer, Pokemon[] secondPlayer, Pokemon[] currentPlayer) {
        if (currentPlayer == firstPlayer) {
            currentPlayer = secondPlayer;
        } else {
            currentPlayer = firstPlayer;
        }
        return currentPlayer;
    }

    private static Pokemon[] assignNewPokemon () {
        return deepCopyPokemonArray(PokemonRoster.allPokemons[Constants.RANDOM.nextInt(0,PokemonRoster.allPokemons.length-1)]);
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