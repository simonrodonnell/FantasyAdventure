package game.players.characterclasses.characterSpecials;

import java.util.ArrayList;
import java.util.Random;

public enum WeaponTypes {

    SWORD(3),
    AXE(5),
    STAFF(2),
    BOW(2),
    MACE(3);

    private int damage;

    WeaponTypes(int damage){
        this.damage = damage;
    }

    public static WeaponTypes randomWeapon() {
        WeaponTypes[] allWeapons = values();
        Random randomNumber = new Random();
        int randomInt = randomNumber.nextInt(allWeapons.length);
        return allWeapons[randomInt];
    }

    public int getDamage(){
        return this.damage;
    }
}
