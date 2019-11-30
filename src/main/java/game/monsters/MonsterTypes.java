package game.monsters;

public enum MonsterTypes {
    KOBOLD("Kobold", 1),
    SKELETON("Skeleton", 2),
    GOBLIN("Goblin", 3),
    ORC("Orc", 4),
    ZOMBIE("Zombie", 5),
    HOBGOBLIN("Hobgoblin", 6),
    GNOLL("Gnoll", 7),
    GHOUL("Ghoul", 8),
    WIGHT("Wight", 9),
    OGRE("Ogre", 10),
    GARGOYLE("Gargoyle", 11),
    LYCANTHROPE("Lycanthrope", 12),
    WRAITH("Wraith", 13),
    MEDUSA("Medusa", 14),
    MINOTAUR("Minotaur", 15),
    COCKATRICE("Cockatrice", 16),
    MUMMIE("Mummie", 17),
    TROLL("Troll", 18),
    GIANT("Giant", 19),
    BASILISK("Basilisk", 20),
    MANTICORE("Manticore", 21),
    SPECTRE("Spectre", 22),
    WYVERN("Wyvern", 23),
    HYDRA("Hydra", 24),
    CHIMERA("Chimera", 25),
    VAMPIRE("Vampire", 26),
    GORGON("Gorgon", 27),
    DRAGON("Dragon", 28),
    BALROG("Balrog", 29),
    PURPLEWORM("Purple Worm", 30);

    private final int hitPoints;
    private final String name;

    MonsterTypes(String name, int hitPoints){
        this.hitPoints = hitPoints;
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String getName() {
        return name;
    }
}
