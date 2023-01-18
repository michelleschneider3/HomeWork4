public class Main {

    private static Player currentPlayer = new Player("Player1", assignNewPokemon());
    private static Player otherPlayer = new Player("Player2", assignNewPokemon());

    public static void main(String[] args) {
        welcomeMessage();
        fightMenu();
    }

    private static void fightMenu() {  //O(n)
        int userInput;
        boolean endLoop = false;
        do {
            printStats();
            userInput = Constants.SCANNER.nextInt();
            Constants.SCANNER.nextLine();

            switch (userInput) {
                case Constants.CHOOSE_ATTACK -> {
                    if (currentPlayer.getPokemon()[currentPlayer.getLevel()-1].tryToKill(otherPlayer.getPokemon()[otherPlayer.getLevel()-1])) {
                        endLoop = true;
                    } else {
                        switchPlayer();
                    }
                }
                case Constants.SKIP_TURN -> {
                   currentPlayer.getPokemon()[currentPlayer.getLevel()-1].skipTurn();
                    switchPlayer();
                }
                case Constants.LEVEL_UP -> {
                    if(currentPlayer.levelUp()){
                        switchPlayer();
                    }
                }
                case Constants.SPECIAL_POWER -> {
                   switch(currentPlayer.getPokemon()[currentPlayer.getLevel()-1].specialPower()){
                       case Constants.SPECIAL_POWER_FAILED -> System.out.println("Special power failed");
                       case Constants.SPECIAL_POWER_SUCCESSFUL -> switchPlayer();
                       case Constants.SPECIAL_POWER_DOUBLE_DAMAGE -> {
                           if (otherPlayer.getPokemon()[otherPlayer.getLevel()-1].takeDoubleDamage(currentPlayer.getPokemon()[currentPlayer.getLevel()-1])) {
                               System.out.println(otherPlayer.getPokemon()[otherPlayer.getLevel()-1].getName() + " ("+ otherPlayer.getName() +") is dead");
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

    private static void printStats(){ //O(1)
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
    private static void welcomeMessage () { //O(1)
        System.out.println("""
                Welcome to our Pokemon fight game!!!,
                Here is a little info about our game:
                It is a player against player type of game, each turn the current player switches
                Upon running the game you and your opponent were assigned with a random pokemon from our database
                After starting you will see info about your and opponents pokemon
                After each turn you will get from 0 to 4 health and attack points
                If you want to level up keep in mind that its not free, here is the costs """
                +  printLevelUpCosts() + "\n" + """
                Each type of pokemon has a special power
                Electric ones can max out their hp and attack points (can only use once)
                Fire ones can double attack the opponent (attacks will be chosen randomly and will cost half of hp and all of attack points)
                In addition Electirc types will have Electricity that will boost their attack with the same percentage as their value (Electricity drops to 0 if you hae less then 20% of hp left)
                
                First player will start the game and will be able to choose from the options bellow

                PRESS ENTER TO START""");
        Constants.SCANNER.nextLine();
    }

    private static String printLevelUpCosts(){ //O(1)
        String output = "";
        for (int i = 1; i <= Constants.MINIMUM_ATTACK_POINTS_REQUIRED_PER_LEVEL.length; i++) {
            output += "\nLevel "+ (i)  + " to level " + (i+1) + " - " + Constants.MINIMUM_ATTACK_POINTS_REQUIRED_PER_LEVEL[i-1] + " attack points";
            output += " and " + Constants.MINIMUM_HEALTH_REQUIRED_PER_LEVEL[i-1] + " hp";
        }

        return output;
    }
    private static void switchPlayer () { //O(1)
        currentPlayer.getPokemon()[currentPlayer.getLevel()-1].receivePerksPerTurn();
        System.out.print("(" + currentPlayer.getName() + ")\n");
        Player temp = currentPlayer;
        currentPlayer = otherPlayer;
        otherPlayer = temp;
    }

    private static Pokemon[] assignNewPokemon () { //(O(n)
        return deepCopyPokemonArray(PokemonRoster.allPokemons[Constants.RANDOM.nextInt(0,PokemonRoster.allPokemons.length)]);
    }

    private static Pokemon[] deepCopyPokemonArray(Pokemon[] pokemon) { //O(n)
        Pokemon[] copyArray = new Pokemon[pokemon.length];
        for (int i = 0; i < copyArray.length; i++) {
            copyArray[i] = pokemon[i].createCopy();
        }
        return copyArray;
    }
}