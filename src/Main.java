public class Main {

    private static Player currentPlayer = new Player("Player1",1,assignNewPokemon());
    private static Player otherPlayer = new Player("Player2",1,assignNewPokemon());

    public static void main(String[] args) {
        welcomeMessage();
        fightMenu();
    }

    private static void fightMenu() {
        int userInput;
        boolean endLoop = false;
        do {
            printStats();
            userInput = Constants.SCANNER.nextInt();
            Constants.SCANNER.nextLine();

            switch (userInput) {
                case 1 -> {
                    if (currentPlayer.getPokemon()[currentPlayer.getLevel()-1].tryToKill(otherPlayer.getPokemon()[otherPlayer.getLevel()-1])) {
                        endLoop = true;
                    } else {
                        switchPlayer();
                    }
                }
                case 2 -> {
                   currentPlayer.getPokemon()[currentPlayer.getLevel()-1].skipTurn();
                    switchPlayer();
                }
                case 3 -> {
                    if(currentPlayer.levelUp()){
                        switchPlayer();
                    }
                }
                case 4 -> {
                   switch(currentPlayer.getPokemon()[currentPlayer.getLevel()-1].specialPower()){
                       case Constants.SPECIAL_POWER_FAILED -> System.out.println("Special power failed");
                       case Constants.SPECIAL_POWER_SUCCESSFUL -> switchPlayer();
                       case Constants.SPECIAL_POWER_DOUBLE_DAMAGE -> {
                           if (otherPlayer.getPokemon()[otherPlayer.getLevel()-1].takeDoubleDamage(currentPlayer.getPokemon()[currentPlayer.getLevel()-1])) {
                               System.out.println(otherPlayer.getPokemon()[otherPlayer.getLevel()-1].getName() + " is dead");
                               endLoop = true;
                           } else {
                               switchPlayer();
                           }
                       }
                   }
                }
                default -> System.out.println("Please choose a valid option");
            }
        } while (!endLoop);
    }

    private static void printStats(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("------------------------------------CURRENT------------------------------------");
        System.out.println(currentPlayer);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(otherPlayer);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
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
    private static void switchPlayer () {
        Player temp = currentPlayer;
        currentPlayer = otherPlayer;
        otherPlayer = temp;
    }

    private static Pokemon[] assignNewPokemon () {
        return deepCopyPokemonArray(PokemonRoster.allPokemons[Constants.RANDOM.nextInt(0,PokemonRoster.allPokemons.length)]);
    }

    private static Pokemon[] deepCopyPokemonArray(Pokemon[] pokemon) {
        Pokemon[] copyArray = new Pokemon[pokemon.length];
        for (int i = 0; i < copyArray.length; i++) {
            copyArray[i] = pokemon[i].createCopy();
        }
        return copyArray;
    }
}