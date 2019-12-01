package game.behaviours;

import game.monsters.Monster;
import game.players.Player;

public interface IAttack {

    public String attack(Player player, Monster monster, int playerAttackIndex);

}
