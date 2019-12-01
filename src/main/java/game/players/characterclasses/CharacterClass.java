package game.players.characterclasses;

import game.monsters.Monster;
import game.players.Player;
import game.players.characterclasses.characterSpecials.WeaponTypes;

public abstract class CharacterClass {


    public String attack(Player player, Monster monster, int playerAttackIndex){
        return "Attack!";
    }

    public abstract String getWeaponName();
}
