import game.players.Player;
import game.players.characterclasses.CharacterClass;
import game.players.characterclasses.Warrior;
import game.players.characterclasses.characterSpecials.WarriorTypes;
import game.players.characterclasses.characterSpecials.WeaponTypes;
import game.monsters.Monster;
import game.monsters.MonsterTypes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player;
    CharacterClass characterClass;

    @Before
    public void before(){
        characterClass = new Warrior(WarriorTypes.KNIGHT, WeaponTypes.BOW);
        player = new Player("Eric", characterClass);
    }

    @Test
    public void playerHasName() {
        assertEquals("Eric", player.getName());
    }

    @Test
    public void playerHasCharacterClass(){
        assertEquals(characterClass, player.getCharacterClass());
    }

    @Test
    public void playerCanAttack(){
        int playerAttackIndex = 1;
        Monster monster = new Monster(MonsterTypes.GOBLIN);
        assertEquals("Eric hit the Goblin! It has 1 hp left.", player.getCharacterClass().attack(player, monster, playerAttackIndex));
    }

    @Test
    public void playHasHitPoints() {
        assertEquals(30, player.getHitPoints());
    }

    @Test
    public void playerHasGold() {
        assertEquals(0, player.getGold());
    }
}
