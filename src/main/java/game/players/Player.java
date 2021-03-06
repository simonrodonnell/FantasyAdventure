package game.players;

import game.monsters.Monster;
import game.players.characterclasses.CharacterClass;
import game.players.characterclasses.characterSpecials.WeaponTypes;

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

    public String getExperienceReward(Monster monster) {
        int expGained = monster.getType().getHitPoints() * 10;
        experience += expGained;
        return "has gained " + expGained +" exp!";

    }

    public void setMaxHitPoints(int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public String takeTreasure(int treasure) {
        gold += treasure;
        return "has gained " + treasure + " gold";
    }

    public int getExperience() {
        return experience;
    }
}
