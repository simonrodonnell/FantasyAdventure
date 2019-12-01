package game.players.characterclasses.characterSpecials;

public enum SpellType {

    FIREBALL(15, "Fireball"),
    LIGHTNINGBOLT(10, "Lightning Bolt"),
    MAGICMISSILE(10, "Magic Missile"),
    FREEZE(5, "Freeze");

    private int damage;
    private String spellName;

    private SpellType(int damage, String spellName){
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public String getSpellName() {
        return spellName;
    }
}
