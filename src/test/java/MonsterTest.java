import game.enemies.Monster;
import game.enemies.MonsterTypes;
import game.players.Player;
import game.players.characterclasses.CharacterClass;
import game.players.characterclasses.Warrior;
import game.players.characterclasses.characterSpecials.WarriorTypes;
import game.players.characterclasses.characterSpecials.WeaponTypes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MonsterTest {

    Monster monster;

    @Before
    public void before(){
        monster = new Monster(MonsterTypes.GOBLIN);
    }

    @Test
    public void canAttack(){
        CharacterClass characterClass = new Warrior(WarriorTypes.KNIGHT, WeaponTypes.BOW);
        Player player = new Player("Eric", characterClass);
        assertEquals("The Goblin does 1 points of damage. Eric is hurt! 29 hp left.", monster.attack(player));
    }
}
