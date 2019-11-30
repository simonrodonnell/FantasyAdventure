import game.Game;
import game.players.Player;
import game.players.characterclasses.CharacterClass;
import game.players.characterclasses.MagicUser;
import game.players.characterclasses.Warrior;
import game.players.characterclasses.characterSpecials.*;
import game.rooms.Room;
import game.rooms.TreasureTypes;
import game.monsters.Monster;
import game.monsters.MonsterTypes;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game;
    Room room;
    Player player1;
    Player player2;

    @Before
    public void before(){

        game = new Game();

        TreasureTypes treasure1 = TreasureTypes.GOLD;
        TreasureTypes treasure2 = TreasureTypes.GEMS;
        TreasureTypes treasure3 = TreasureTypes.ARTIFACTS;

        Monster monster1 = new Monster(MonsterTypes.GOBLIN);
        Monster monster2 = new Monster(MonsterTypes.ORC);
        Monster monster3 = new Monster(MonsterTypes.SKELETON);

        room = new Room();

        room.addMonster(monster1);
        room.addMonster(monster2);
        room.addMonster(monster3);
        room.addTreasure(treasure1);
        room.addTreasure(treasure2);
        room.addTreasure(treasure3);

        CharacterClass characterClass1 = new Warrior(WarriorTypes.KNIGHT, WeaponTypes.BOW);
        CharacterClass characterClass2 = new MagicUser(MagicUserType.WIZARD, SpellType.FIREBALL, Creature.YOSHI);
        player1 = new Player("Eric", characterClass1);
        player2 = new Player("Ethan", characterClass2);

    }

    @Test
    public void getDifficulty() {
        assertEquals(1, game.getDifficulty());
    }

    @Test
    public void getNumberOfPlayers() {
        assertEquals(1, game.getNumberOfPlayers());
    }

    @Test
    public void setDifficulty() {
        game.setDifficulty(3);
        assertEquals(3, game.getDifficulty());
    }

    @Test
    public void addMonsters() {
        game.addMonsterToRoom(room);
        assertEquals(4, room.getMonsters().size());
    }

    @Test
    public void addTreasure() {
        game.addTreasureToRoom(room);
        assertEquals(4, room.getTreasure().size());
    }

    @Test
    public void difficultyChangesContentsOfRoom() {
        game.setDifficulty(3);
        game.addMonsterToRoom(room);
        game.addTreasureToRoom(room);
        assertEquals(6, room.getMonsters().size());
        assertEquals(6, room.getTreasure().size());
    }

    @Test
    public void canGenerateRoomsBasedOnPlayersAndDifficulty(){
        game.setDifficulty(3);
        game.setNumberOfPlayers(2);
        game.generateRooms();
        assertEquals(6, game.getRooms().size());
        assertEquals(6, game.getRooms().get(0).getMonsters().size());
        assertEquals(6, game.getRooms().get(0).getTreasure().size());
    }

    @Test
    public void canQuest() {
        game.generateRooms();
        game.quest();
        assertEquals(0, game.getRooms().get(0).getMonsters().size());
    }

    @Test
    public void canHaveFight(){
        game.setDifficulty(2);
        game.setNumberOfPlayers(2);
        game.generateRooms();
        Room room = game.getRooms().get(0);
        ArrayList<Player> players = game.getPlayers();
        players.add(player1);
        players.add(player2);
        Monster monster1 = new Monster(MonsterTypes.GOBLIN);
        game.combat(players, monster1, room, 0);
    }

    @Test
    public void canSelectMonstersForFighting(){
        game.setDifficulty(2);
        game.setNumberOfPlayers(2);
        game.generateRooms();
        Room room = game.getRooms().get(0);
        ArrayList<Player> players = game.getPlayers();
        players.add(player1);
        players.add(player2);
        game.selectMonsterToFight(room, 0);
    }

    @Test
    public void userCanInputPlayerDetails(){
        CharacterClass playerInput = game.classSelector(1);
        System.out.println(playerInput);
    }
}
