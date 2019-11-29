package game.rooms;

import game.rooms.enemies.Monster;

import java.util.ArrayList;

public class Room {

    private ArrayList<Monster> monsters;
    private ArrayList<TreasureTypes> treasure;

    public Room(ArrayList<Monster> monsters, ArrayList<TreasureTypes> treasure){
        this.monsters = monsters;
        this.treasure = treasure;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public ArrayList<TreasureTypes> getTreasure() {
        return treasure;
    }

    public TreasureTypes takeTreasure(){
        TreasureTypes foundTreasure = treasure.get(0);
        treasure.remove(0);
        return foundTreasure;
    }

    public void removeEnemy(Monster monster){
        int index = monsters.indexOf(monster);
        monsters.remove(index);
    }

    public boolean IsRoomComplete() {
        return (monsters.isEmpty() && treasure.isEmpty());
    }

    public void addMonster(Monster newMonster) {
        monsters.add(newMonster);
    }
}
