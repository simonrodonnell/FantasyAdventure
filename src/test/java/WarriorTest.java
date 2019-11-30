import game.players.Player;
import game.players.characterclasses.Warrior;
import game.players.characterclasses.characterSpecials.WarriorTypes;
import game.players.characterclasses.characterSpecials.WeaponTypes;
import game.enemies.Monster;
import game.enemies.MonsterTypes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WarriorTest {

    Warrior warrior;
    Monster monster;
    Player player;

    @Before
    public void before(){
        warrior = new Warrior(WarriorTypes.KNIGHT, WeaponTypes.BOW);
        monster = new Monster(MonsterTypes.GOBLIN);
        player = new Player("Eric", warrior);
    }

    @Test
    public void canAttack(){
        String result = warrior.attack(player, monster);
        assertEquals("Eric hit the Goblin!", result);
        assertEquals(1, monster.getHitPoints());

    }
}
