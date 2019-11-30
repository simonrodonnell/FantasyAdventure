package game.behaviours;

import game.enemies.Monster;
import game.players.Player;

public interface IAttack {

    public String attack(Player player, Monster monster);

}
