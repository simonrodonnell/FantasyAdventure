package game.players.characterclasses;

import game.monsters.Monster;
import game.players.Player;

public abstract class CharacterClass {


    public String attack(Player player, Monster monster, int playerAttackIndex){
        return "Attack!";
    }

}
