package game.players.characterclasses;

public enum CharacterClassSelection {

    // ## WARRIORS ##
    DWARF("Dwarf"),
    BARBARIAN("Barbarian"),
    KNIGHT("Knight"),
    // ## HEALERS ##
    CLERIC("Cleric"),
    // ## MAGIC USERS ##
    WIZARD("Wizard"),
    WARLOCK("Warlock"),
    SORCERER("Sorcerer"),
    MAGE("Mage");

    String name;

    private CharacterClassSelection(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CharacterClassSelection[] getCharacterClassOptions(){
        CharacterClassSelection[] allCharacterClassOptions = values();
        return allCharacterClassOptions;
    }

}
