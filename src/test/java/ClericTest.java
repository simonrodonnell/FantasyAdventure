import game.players.Player;
import game.players.characterclasses.CharacterClass;
import game.players.characterclasses.Cleric;
import game.players.characterclasses.characterSpecials.HealingTool;
import game.players.characterclasses.Warrior;
import game.players.characterclasses.characterSpecials.WarriorTypes;
import game.players.characterclasses.characterSpecials.WeaponTypes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClericTest {

    Cleric cleric;
    Player player;
    CharacterClass characterClass;

    @Before
    public void before(){
        cleric = new Cleric(HealingTool.MAGICPIPES);
        characterClass = new Warrior(WarriorTypes.KNIGHT, WeaponTypes.BOW);
        player = new Player("Eric", characterClass);
    }

    @Test
    public void canChangeHealingTool() {
        HealingTool newHealingTool = HealingTool.HERBS;
        cleric.setHealingTool(newHealingTool);
        assertEquals(newHealingTool, cleric.getHealingTool());
    }

    @Test
    public void canHeal(){
        String result = cleric.healPlayer(player);
        assertEquals("Eric has been healed by 50 points", result);

    }
}
