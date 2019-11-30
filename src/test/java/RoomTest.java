import game.rooms.Room;
import game.rooms.TreasureTypes;
import game.enemies.Monster;
import game.enemies.MonsterTypes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    Room room;
    Monster monster1;
    Monster monster2;
    Monster monster3;

    @Before
    public void before(){
        TreasureTypes treasure1 = TreasureTypes.GOLD;
        TreasureTypes treasure2 = TreasureTypes.GEMS;
        TreasureTypes treasure3 = TreasureTypes.ARTIFACTS;
        monster1 = new Monster(MonsterTypes.GOBLIN);
        monster2 = new Monster(MonsterTypes.ORC);
        monster3 = new Monster(MonsterTypes.SKELETON);

        this.room = new Room();

        room.addMonster(monster1);
        room.addMonster(monster2);
        room.addMonster(monster3);
        room.addTreasure(treasure1);
        room.addTreasure(treasure2);
        room.addTreasure(treasure3);
    }

    @Test
    public void canTakeTreasure(){
        TreasureTypes foundTreasure = room.takeTreasure();
        assertEquals(TreasureTypes.GOLD, foundTreasure);
    }

    @Test
    public void hasEnemies() {
        assertEquals(3, room.getMonsters().size());
    }

    @Test
    public void hasTreasure(){
        assertEquals(3, room.getTreasure().size());
    }

    @Test
    public void canRemoveEnemy(){
        room.removeEnemy(monster1);
        assertEquals(2, room.getMonsters().size());
    }

    @Test
    public void roomIsComplete(){
        room.removeEnemy(monster1);
        room.removeEnemy(monster2);
        room.removeEnemy(monster3);
        room.takeTreasure();
        room.takeTreasure();
        room.takeTreasure();
        assertEquals(true, room.IsRoomComplete());
    }


}
