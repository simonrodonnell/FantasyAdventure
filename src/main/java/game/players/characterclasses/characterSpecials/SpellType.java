package game.players.characterclasses.characterSpecials;

public enum SpellType {

    FIREBALL(20, "Fireball spell"),
    LIGHTNINGBOLT(10, "Lightning Bolt spell"),
    MAGICMISSILE(25, "Magic Missile spell"),
    FREEZE(15, "Freeze spell");

    private int damage;
    private String spellName;

    private SpellType(int damage, String spellName){
        this.damage = damage;
        this.spellName = spellName;
    }

    public int getDamage() {
        return damage;
    }

    public String getSpellName() {
        return spellName;
    }
}
