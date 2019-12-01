import game.players.Player;
import game.players.characterclasses.characterSpecials.SpellType;
import game.players.characterclasses.MagicUser;
import game.players.characterclasses.characterSpecials.Creature;
import game.players.characterclasses.characterSpecials.MagicUserType;
import game.monsters.Monster;
import game.monsters.MonsterTypes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagicUserTest {

    MagicUser magicUser;
    Monster monster;
    Player player;

    @Before
    public void before(){
        magicUser = new MagicUser(MagicUserType.WARLOCK, SpellType.FIREBALL, Creature.YOSHI);
        monster = new Monster(MonsterTypes.GOBLIN);
        player = new Player("Ethan", magicUser);
    }

    // N.B. GOBLIN HAS 3 HP
    // N.B. FIREBALL DOES 15 DAMAGE

    @Test
    public void canAttack(){
        int playerAttackIndex = 1;
        String result = magicUser.attack(player, monster, playerAttackIndex);
        assertEquals("Ethan killed the Goblin!", result);
        assertEquals(-12, monster.getHitPoints() );
    }

}
