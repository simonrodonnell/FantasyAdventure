package game.players.characterclasses;

import game.behaviours.Dice;
import game.behaviours.IAttack;
import game.players.characterclasses.types.SpellType;
import game.players.characterclasses.types.Creature;
import game.players.characterclasses.types.MagicUserType;
import game.rooms.enemies.Monster;

public class MagicUser extends CharacterClass implements IAttack {

    private MagicUserType type;
    private SpellType spell;
    private Creature creature;


    public MagicUser(MagicUserType type, SpellType spell, Creature creature){
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

    public String attack(Monster monster){
        Dice dice = new Dice();
        int playerAttacks = 10; // for testing
//        int playerAttacks = dice.rollDice();
        int enemyDefends = 5; // for testing
//        int enemyDefends = dice.rollDice();
        if(playerAttacks > enemyDefends){
            return monster.takeDamage(spell.getDamage());
        } else {
            return "You killed the enemy!";
        }
    }

}
