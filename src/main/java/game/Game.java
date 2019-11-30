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

    public Game(){
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
        while(loopCount < combinedDifficulty)
        {
        room.addMonster(randomMonster());
        loopCount ++;
        }
    }

    public void addTreasureToRoom(Room room) {
        int loopCount = 0;
        int combinedDifficulty = difficulty * numberOfPlayers;
        while(loopCount < combinedDifficulty)
        {
        room.addTreasure(randomTreasure());
            loopCount ++;
        }
    }

    public void generateRooms() {
        int loopCount = 0;
        int combinedDifficulty = difficulty * numberOfPlayers;
        while(loopCount < combinedDifficulty)
        {
            Room room = new Room();
            rooms.add(room);
            loopCount ++;
        }
        for(Room room : rooms){
        addMonsterToRoom(room);
        addTreasureToRoom(room);
        }
    }

    public void setupGame(){
    Scanner inputScanner = new Scanner(System.in);
        System.out.println("Welcome to CodeClan Fantasy Adventure");
        System.out.println("Number of players?");
        String inputNumberOfPlayers = inputScanner.next();
        System.out.println("You have entered "+ inputNumberOfPlayers +" players.");

        //Get player name - needs to loop for inputNumberOfPlayers times
        System.out.println("Character Name?");
        String playerName = inputScanner.next();
        //Get player type:
        System.out.println("Character Class? Select number:");
        CharacterClassSelection[] allCharacterClasses = CharacterClassSelection.values();
        int index = 1;
        for(CharacterClassSelection characterClassSelector: allCharacterClasses) {
            String option = "    " + index + ". " + characterClassSelector.getName();
            System.out.println(option);
            index ++;
        }
            int playerClassInput = inputScanner.nextInt();
            CharacterClass playerClass = classSelector(playerClassInput);
            Player newPlayer = new Player(playerName, playerClass);
            String playerType = allCharacterClasses[playerClassInput - 1].getName();
            System.out.println("You have created " + playerName + " the " + playerType + ".");



        System.out.println("Difficulty level?");
        String inputDifficulty = inputScanner.next();
        System.out.println("Difficulty set to "+ inputDifficulty +".");

        this.difficulty = Integer.parseInt(inputDifficulty);
        this.numberOfPlayers = Integer.parseInt(inputNumberOfPlayers);
        generateRooms();
    }

    public CharacterClass classSelector(int playerClassInput) {
        if(playerClassInput == 1)
        {
            return new Warrior(WarriorTypes.DWARF, WeaponTypes.randomWeapon());
        }
        else if (playerClassInput == 2)
        {
            return new Warrior(WarriorTypes.BARBARIAN, WeaponTypes.randomWeapon());
        }
        else if (playerClassInput == 3)
        {
            return new Warrior(WarriorTypes.BARBARIAN, WeaponTypes.randomWeapon());
        }
        else if (playerClassInput == 4)
        {
            return new Cleric(HealingTool.randomHealingTool());
        }
        else if (playerClassInput == 5)
        {
            return new MagicUser(MagicUserType.WIZARD, SpellType.LIGHTNINGBOLT, Creature.randomCreature() );
        }
        else if (playerClassInput == 6)
        {
            return new MagicUser(MagicUserType.WARLOCK, SpellType.FIREBALL, Creature.randomCreature() );
        }
        else if (playerClassInput == 7)
        {
            return new MagicUser(MagicUserType.SORCERER, SpellType.FREEZE, Creature.randomCreature() );
        }
        else
        {
            return new MagicUser(MagicUserType.MAGE, SpellType.MAGICMISSILE, Creature.OGRE);
        }
    }

    public void quest(){
        int roomIndex = 0;
        while(roomIndex < getRooms().size()){
            Room room = rooms.get(roomIndex);
            // fight monsters & get treasure
            room.killAllMonsters(); // n.b method just for testing purposes
            room.removeAllTreasure(); // n.b method just for testing purposes
            roomIndex ++;
        }
        System.out.println("Well done, you have completed the quest!");
    }

    public void selectMonsterToFight(Room room, int monsterIndex){
        if(monsterIndex < room.getMonsters().size()){
        Monster monster = room.getMonsters().get(monsterIndex);
            System.out.println("A "+ monster.getName() + " has appeared!");
        combat(players, monster, room, monsterIndex);
        } else {
        roomCompleted();
        }
    }

    private void roomCompleted() {
        System.out.println("All the monsters are defeated. The room is complete!");
    }

    public void combat(ArrayList<Player> players, Monster monster, Room room, int monsterIndex) {
        int playerIndex = 0;
        while(playerIndex < players.size()){
            Player activePlayer = players.get(playerIndex);
            String playerAttack = activePlayer.getCharacterClass().attack(activePlayer, monster);
            System.out.println(playerAttack);
           if(monster.isNotDead())
           {String monsterAttack = monster.attack(activePlayer);
           System.out.println(monsterAttack);
           playerIndex ++;
           } else {
               System.out.println("The monster has been defeated.");
               int treasure  = room.getTreasure().get(monsterIndex).getGoldValue();
               activePlayer.takeTreasure(treasure);
               activePlayer.getExperienceReward(monster);
//               room.removeMonster(monster);
//               room.removeTreasure();
               monsterIndex ++;
               selectMonsterToFight(room, monsterIndex);
               break;
           }
        } playerIndex ++;
    }
}
