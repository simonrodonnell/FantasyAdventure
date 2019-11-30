package game.players.characterclasses.characterSpecials;

public enum WeaponTypes {

    SWORD(3),
    AXE(5),
    STAFF(2),
    BOW(2),
    MACE(3);

    private int damage;

    WeaponTypes(int damage){
        this.damage = damage;
    }

    public int getDamage(){
        return this.damage;
    }
}
