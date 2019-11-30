package game.players.characterclasses;

import game.enemies.Monster;
import game.players.Player;

public abstract class CharacterClass {


    public String attack(Player player, Monster monster){
        return "Attack!";
    }

}
