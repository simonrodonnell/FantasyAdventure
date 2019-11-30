package game.enemies;

import game.behaviours.Dice;
import game.players.Player;

public class Monster {

    private MonsterTypes type;
    private int hitPoints;

    public Monster(MonsterTypes type){
        this.type = type;
        this.hitPoints = type.getHitPoints();
    }

    public MonsterTypes getType() {
        return type;
    }

    public void setType(MonsterTypes type) {
        this.type = type;
        this.hitPoints = type.getHitPoints();
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String takeDamage(int damage) {
        hitPoints -= damage;
        if(hitPoints <= 0){
            return "You killed the "+ type.getName() +"!";
        } else {
            return "You hit the "+ type.getName() +"!";
        }
    }

    public String attack(Player activePlayer) {
        Dice dice = new Dice();
//        int monsterAttacks = dice.rollDice();
//        int playerDefends = dice.rollDice();
        int monsterAttacks = 10; // FIXED VALUE FOR TESTING
        int playerDefends = 5; // FIXED VALUE FOR TESTING
        if(monsterAttacks > playerDefends){
            String playerStatus = activePlayer.takeDamage(getDamage());
            return "The " + type.getName() + " does "+ getDamage() +" points of damage. " + activePlayer.getName() + " is " + playerStatus;
        } else {
            return "The "+ type.getName() +" missed!";
        }
    }

    public int getDamage() {
        int hitPoints = type.getHitPoints();
        if (hitPoints > 1){
            return hitPoints/2;
        } else {
            return hitPoints;
        }
    }
}
