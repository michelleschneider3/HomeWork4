public class Main {
    private static Pokemon[] currentPlayer = assignNewPokemon();

    private static Pokemon[] otherPlayer = assignNewPokemon();

    private static String currentPlayerName = Constants.PLAYER1NAME;

    private static int currentPlayerLevel = 1;

    private static int otherPlayerLevel = 1;
    public static void main(String[] args) {
        welcomeMessage();
        fightMenu();

//        System.out.println(firstPlayer[0]);
//        System.out.println(secondPlayer[1]);
    }

    private static void fightMenu() {
        int userInput;
        boolean endLoop = false;
        do {
            System.out.println(currentPlayer[currentPlayerLevel-1] + " (" + currentPlayerName + ")");
            switchPlayerName();
            System.out.println(otherPlayer[otherPlayerLevel-1] + " (" + currentPlayerName + ")");
            switchPlayerName();
            System.out.println("Current player: " + currentPlayer[currentPlayerLevel-1].getName() + " (" + currentPlayerName+ ")");
            System.out.println("""
                Choose from the options below
                1. Choose Attack
                2. Skip turn
                3. Level up
                4. Special power
                """);
            userInput = Constants.SCANNER.nextInt();
            Constants.SCANNER.nextLine();

            switch (userInput) {
                case 1 -> {
                    if (currentPlayer[currentPlayerLevel-1].makeAttack(otherPlayer[otherPlayerLevel-1])) {
                        System.out.println(otherPlayer[otherPlayerLevel-1].getName() + " is Dead");
                        endLoop = true;
                    } else {
                        switchPlayer();
                    }
                }

                case 2 -> {
                   currentPlayer[currentPlayerLevel-1].skipTurn();
                    switchPlayer();
                }

                case 3 -> {
                    levelUp();
                }
                default -> System.out.println("Please choose a valid option");
            }
        } while (!endLoop);
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
        Pokemon[] temp = currentPlayer;
        currentPlayer = otherPlayer;
        otherPlayer = temp;
        switchPlayerName();
        switchLevel();
    }

    private static void switchLevel () {
        int temp = currentPlayerLevel;
        currentPlayerLevel = otherPlayerLevel;
        otherPlayerLevel = temp;
    }

    private static void switchPlayerName () {
        if (currentPlayerName.equals(Constants.PLAYER1NAME)) {
            currentPlayerName = Constants.PLAYER2NAME;
        } else {
            currentPlayerName = Constants.PLAYER1NAME;
        }
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

    private static void levelUp () {
        if (currentPlayerLevel<currentPlayer.length) {
            int[] minimumHealthRequired = {20, 30};
            int[] minimumAttackPoints = {25, 40};
            if (currentPlayer[currentPlayerLevel-1].canEvolve(minimumHealthRequired[currentPlayerLevel-1], minimumAttackPoints[currentPlayerLevel-1])) {
                currentPlayer[currentPlayerLevel].getCurrents(currentPlayer[currentPlayerLevel-1]);
                currentPlayerLevel++;
                switchPlayer();
            }
        } else {
            System.out.println("You are at your max level");
        }
    }

}