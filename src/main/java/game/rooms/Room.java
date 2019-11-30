package game.rooms;

import game.enemies.Monster;

import java.util.ArrayList;

public class Room {

    private ArrayList<Monster> monsters;
    private ArrayList<TreasureTypes> treasure;

    public Room(){
        this.monsters = new ArrayList<Monster>();
        this.treasure = new ArrayList<TreasureTypes>();
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

    public void addTreasure(TreasureTypes newTreasure) {
        treasure.add(newTreasure);
    }

    // n.b method just for testing purposes
    public void killAllMonsters() {
        this.monsters.clear();
    }

    // n.b method just for testing purposes
    public void removeAllTreasure() {
        this.treasure.clear();
    }
}
