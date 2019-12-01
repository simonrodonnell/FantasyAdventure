package game.players.characterclasses;

import game.behaviours.Dice;
import game.behaviours.IAttack;
import game.players.Player;
import game.players.characterclasses.characterSpecials.SpellType;
import game.players.characterclasses.characterSpecials.Creature;
import game.players.characterclasses.characterSpecials.MagicUserType;
import game.monsters.Monster;
import game.players.characterclasses.characterSpecials.WeaponTypes;

public class MagicUser extends CharacterClass implements IAttack {

    private MagicUserType type;
    private SpellType spell;
    private Creature creature;


    public MagicUser(MagicUserType type, SpellType spell, Creature creature) {
        this.type = type;
        this.spell = spell;
        this.creature = creature;
    }

    public MagicUserType getType() {
        return type;
    }

    public SpellType getSpell() {
        return spell;
    }

    public Creature getCreature() {
        return creature;
    }

    public void setSpell(SpellType spell) {
        this.spell = spell;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public String attack(Player player, Monster monster, int playerAttackIndex) {
        Dice dice = new Dice();
//        int playerAttacks = 10; // for testing
//        int enemyDefends = 5; // for testing
        int playerAttacks = dice.rollDice();
        int enemyDefends = dice.rollDice() + playerAttackIndex;
        if (playerAttacks > enemyDefends) {
            return monster.takeDamage(player, (spell.getDamage() * playerAttackIndex));
        } else {
            return player.getName() + " misses!";
        }
    }


    public String getWeaponName() {
        return spell.getSpellName();
    }

}
