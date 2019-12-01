package game.players.characterclasses.characterSpecials;

import java.util.ArrayList;
import java.util.Random;

public enum WeaponTypes {

    SWORD(3, "Sword"),
    AXE(5, "Axe"),
    STAFF(2, "Staff"),
    BOW(2, "Bow"),
    MACE(3, "Mace");

    private int damage;
    private String weaponName;

    WeaponTypes(int damage, String weaponName) {
        this.damage = damage;
        this.weaponName = weaponName;
    }

    public static WeaponTypes randomWeapon() {
        WeaponTypes[] allWeapons = values();
        Random randomNumber = new Random();
        int randomInt = randomNumber.nextInt(allWeapons.length);
        return allWeapons[randomInt];
    }

    public int getDamage() {
        return this.damage;
    }

    public String getWeaponName() {
        return weaponName;
    }
}
