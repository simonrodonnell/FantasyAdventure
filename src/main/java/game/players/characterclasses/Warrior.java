package game.players.characterclasses;

import game.behaviours.Dice;
import game.behaviours.IAttack;
import game.players.Player;
import game.players.characterclasses.characterSpecials.WeaponTypes;
import game.players.characterclasses.characterSpecials.WarriorTypes;
import game.monsters.Monster;

public class Warrior extends CharacterClass implements IAttack {

    private WarriorTypes type;
    private WeaponTypes weapon;

    public Warrior(WarriorTypes type, WeaponTypes weapon) {
        this.type = type;
        this.weapon = weapon;
    }

    public WarriorTypes getType() {
        return type;
    }

    public WeaponTypes getWeapon() {
        return weapon;
    }

    public String getWeaponName() {
        return weapon.getWeaponName();
    }

    public void changeWeapon(WeaponTypes newWeapon) {
        this.weapon = newWeapon;
    }

    public String attack(Player player, Monster monster, int playerAttackIndex) {
        Dice dice = new Dice();
        int playerAttacks = dice.rollDice();
        int enemyDefends = dice.rollDice();
//        int playerAttacks = 10; // FIXED VALUE FOR TESTING
//        int enemyDefends = 5; // FIXED VALUE FOR TESTING
        if (playerAttacks > enemyDefends) {
            return monster.takeDamage(player, weapon.getDamage());
        } else {
            return player.getName() + " misses!";
        }
    }
}
