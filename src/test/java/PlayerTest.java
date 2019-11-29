import game.players.Player;
import game.players.characterclasses.CharacterClass;
import game.players.characterclasses.Warrior;
import game.players.characterclasses.types.WarriorTypes;
import game.players.characterclasses.types.WeaponTypes;
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
    public void playHasHitPoints() {
        assertEquals(20, player.getHitPoints());
    }

    @Test
    public void playerHasGold() {
        assertEquals(0, player.getGold());
    }
}
