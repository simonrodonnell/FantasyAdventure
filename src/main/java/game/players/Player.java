package game.players;

import game.monsters.Monster;
import game.players.characterclasses.CharacterClass;

public class Player {

    private String name;
    private int hitPoints;
    private int gold;
    private int experience;
    private CharacterClass characterClass;
    private int maxHitPoints;

    public Player(String name, CharacterClass characterClass){
        this.name = name;
        this.characterClass = characterClass;
        this.maxHitPoints = 30;
        this.hitPoints = maxHitPoints;
        this.gold = 0;
        this.experience = 0;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getGold() {
        return gold;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void heal(int healingFactor) {
        this.hitPoints += healingFactor;
        if(hitPoints > maxHitPoints){
            hitPoints = maxHitPoints;
        }
    }

    public String takeDamage(int damage) {
        hitPoints -= damage;
        if(hitPoints <= 0){
            return "dead!";
        } else {
            return "hurt!";
        }
    }

    public void getExperienceReward(Monster monster) {
        int rating = monster.getType().getHitPoints();
        experience += rating * 10;
    }

    public void takeTreasure(int treasure) {
        gold += treasure;
    }
}
