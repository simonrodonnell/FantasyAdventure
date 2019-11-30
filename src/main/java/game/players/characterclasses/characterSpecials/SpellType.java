package game.players.characterclasses.characterSpecials;

public enum SpellType {

    FIREBALL(15),
    LIGHTNINGBOLT(10),
    MAGICMISSILE(10),
    FREEZE(5);

    private int damage;

    private SpellType(int damage){
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
