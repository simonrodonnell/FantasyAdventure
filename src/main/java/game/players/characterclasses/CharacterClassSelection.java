package game.players.characterclasses;

import game.players.characterclasses.characterSpecials.*;

public enum CharacterClassSelection {

    // ## WARRIORS ##
    DWARF("Dwarf", new Warrior(WarriorTypes.DWARF, WeaponTypes.AXE) ),
    BARBARIAN("Barbarian", new Warrior(WarriorTypes.BARBARIAN, WeaponTypes.MACE ) ),
    KNIGHT("Knight", new Warrior(WarriorTypes.KNIGHT, WeaponTypes.SWORD) ),
    // ## HEALERS ##
    CLERIC("Cleric", new Cleric(HealingTool.randomHealingTool())),
    // ## MAGIC USERS ##
    WIZARD("Wizard", new MagicUser( MagicUserType.WIZARD, SpellType.LIGHTNINGBOLT, Creature.FLYINGDOG ) ),
    WARLOCK("Warlock", new MagicUser( MagicUserType.WARLOCK, SpellType.FREEZE, Creature.PEGASUS ) ),
    SORCERER("Sorcerer", new MagicUser(MagicUserType.SORCERER, SpellType.FIREBALL, Creature.YOSHI ) ),
    MAGE("Mage", new MagicUser(MagicUserType.MAGE, SpellType.MAGICMISSILE, Creature.OGRE));

    private final String name;
    private final CharacterClass characterClass;

    private CharacterClassSelection(String name, CharacterClass characterClass){
        this.name = name;
        this.characterClass = characterClass;
    }

    public String getName() {
        return name;
    }

    public CharacterClass getCharacterClassSetup(){
        return characterClass;
    }

}
