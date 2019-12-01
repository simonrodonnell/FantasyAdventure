package game;

import game.players.Player;
import game.players.characterclasses.*;
import game.players.characterclasses.characterSpecials.*;
import game.rooms.Room;
import game.rooms.TreasureTypes;
import game.monsters.Monster;
import game.monsters.MonsterTypes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private ArrayList<Player> players;
    private ArrayList<Room> rooms;
    private int difficulty;
    private int numberOfPlayers;

    public Game() {
        this.players = new ArrayList<Player>();
        this.rooms = new ArrayList<Room>();
        this.difficulty = 1;
        this.numberOfPlayers = 1;
    }

    // GETTERS

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    // SETTERS

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    // GAME SETUP

    public Monster randomMonster() {
        MonsterTypes[] monsterArray = MonsterTypes.values();
        Random random = new Random();
        int index = random.nextInt(monsterArray.length);
        MonsterTypes randomMonsterType = monsterArray[index];
        return new Monster(randomMonsterType);
    }

    public TreasureTypes randomTreasure() {
        TreasureTypes[] treasureArray = TreasureTypes.values();
        Random random = new Random();
        int index = random.nextInt(treasureArray.length);
        return treasureArray[index];

    }

    public void addMonsterToRoom(Room room) {
        int loopCount = 0;
        int combinedDifficulty = difficulty * numberOfPlayers;
        while (loopCount < combinedDifficulty) {
            room.addMonster(randomMonster());
            loopCount++;
        }
    }

    public void addTreasureToRoom(Room room) {
        int loopCount = 0;
        int combinedDifficulty = difficulty * numberOfPlayers;
        while (loopCount < combinedDifficulty) {
            room.addTreasure(randomTreasure());
            loopCount++;
        }
    }

    public void generateRooms() {
        int loopCount = 0;
        int combinedDifficulty = difficulty * numberOfPlayers;
        while (loopCount < combinedDifficulty) {
            Room room = new Room();
            rooms.add(room);
            loopCount++;
        }
        for (Room room : rooms) {
            addMonsterToRoom(room);
            addTreasureToRoom(room);
        }
    }

    public void setupGame() {
        Scanner inputScanner = new Scanner(System.in);

        // set to defaults
        players.clear();
        rooms.clear();
        difficulty = 1;
        numberOfPlayers = 1;

        // INTRODUCTION

        System.out.println("############# WELCOME TO CODECLAN FANTASY ADVENTURE #############");
        System.out.println("             _____\n" +
                "             \\   /\n" +
                "             |   |\n" +
                ".__.         |   |_____________________________________________\n" +
                "|  |_________|   |                                              \\\n" +
                "|  |         |   |________________________________________________\\\n" +
                "|  |_________|   |                                                /\n" +
                "|__|         |   |_____________________________________________ /\n" +
                "             |   |\n" +
                "             |   |\n" +
                "             /___\\\n");
        System.out.println("===================================================================");
        System.out.println("\n");
        // SETUP NUMBER OF PLAYERS

        System.out.println("Number of players?");
        String inputNumberOfPlayers = inputScanner.next();
        System.out.println("You have entered " + inputNumberOfPlayers + " players.");
        this.numberOfPlayers = Integer.parseInt(inputNumberOfPlayers);
        int playerNumber = 1;
        while (players.size() < numberOfPlayers) {
            // SETUP PLAYER

            //input player name
            System.out.println("\n");
            System.out.println("Set up player " + playerNumber);
            System.out.println("Character Name?");
            String playerName = inputScanner.next();

            //input player class
            System.out.println("Character Class? Select number:");
            CharacterClassSelection[] allCharacterClasses = CharacterClassSelection.values();
            int index = 1;
            for (CharacterClassSelection characterClassSelector : allCharacterClasses) {
                String option = "    " + index + ". " + characterClassSelector.getName();
                System.out.println(option);
                index++;
            }

            // create new player & add to game
            int playerClassInput = inputScanner.nextInt();
            CharacterClass playerClass = classSelector(playerClassInput);
            Player newPlayer = new Player(playerName, playerClass);
            players.add(newPlayer);

            // print out to user
            String playerType = allCharacterClasses[playerClassInput - 1].getName();
            System.out.println("You have created " + playerName + " the " + playerType + ".");

            playerNumber ++;
        }
        // SETUP DIFFICULTY LEVEL

        System.out.println("Difficulty level?");
        String inputDifficulty = inputScanner.next();
        this.difficulty = Integer.parseInt(inputDifficulty);
        System.out.println("Difficulty set to " + inputDifficulty + ".");
        System.out.println("===================================================================");
        System.out.println("\n");
        // FINISH SETUP
        generateRooms();
        System.out.println("The adventure begins...");
        System.out.println("\n");
        quest();
    }

    public CharacterClass classSelector(int playerClassInput) {
        int index = playerClassInput - 1;
        CharacterClassSelection[] allCharacterClasses = CharacterClassSelection.values();
//        System.out.println(allCharacterClasses[index].getName());
        return allCharacterClasses[index].getCharacterClassSetup();
    }

    public void quest() {
        for (Room activeRoom : rooms) {
            System.out.println("A new room");
            combat(players, activeRoom, 0);
        }
        System.out.println("Well done, you have completed the quest!");
    }

    private void roomCompleted() {
        System.out.println("All the monsters are defeated. The room is complete!");
    }

    public void combat(ArrayList<Player> players, Room room, int monsterIndex) {
        // Select monster todo => room complete
        Monster monster = room.getMonsters().get(monsterIndex);
        System.out.println("A " + monster.getName() + " appears!");
        // continue until monster is dead
        while (monster.getHitPoints() > 0) {
            // Loop through players
            for (Player activePlayer : players) {
                if (activePlayer.getHitPoints() > 0) {
                    System.out.println(activePlayer.getName() + " attacks");
                    String playerAttack = activePlayer.getCharacterClass().attack(activePlayer, monster);
                    System.out.println(playerAttack);

                    if (monster.isNotDead()) {
                        System.out.println(monster.getName() + " attacks");
                        String monsterAttack = monster.attack(activePlayer);
                        System.out.println(monsterAttack);
                        // check if player is dead
                        if (allPlayersAreDead()) {
                            gameOver();
                        }
                    } else {
                        System.out.println("The monster has been defeated.");
                        int treasure = room.getTreasure().get(monsterIndex).getGoldValue();
                        String newTreasure = activePlayer.takeTreasure(treasure);
                        System.out.println(activePlayer.getName() + " " + newTreasure);
                        String newExperience = activePlayer.getExperienceReward(monster);
                        System.out.println(activePlayer.getName() + " " + newExperience);

                        if (monsterIndex < room.getMonsters().size() - 1) {
                            monsterIndex++;
                            combat(players, room, monsterIndex);
                        } else {
                            roomCompleted();
                        }

                    }
                }

            }
        }
    }

    private boolean allPlayersAreDead() {
        int totalHitpoints = 0;
        for(Player player : players){
            totalHitpoints += player.getHitPoints();
        }
        return totalHitpoints <= 0;
    }

    public void gameOver() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("The quest is over.");
        System.out.println("===================================================================");
        System.out.println("\n");
        System.out.println("Play again? (y/n)");
        String playAgain = inputScanner.next();
        if (playAgain.equals("y")) {
            setupGame();
        }
        System.exit(0);
    }
}
