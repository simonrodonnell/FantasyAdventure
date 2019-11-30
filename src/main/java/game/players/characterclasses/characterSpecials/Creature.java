package game.players.characterclasses.characterSpecials;

import java.util.Random;

public enum Creature {

    OGRE,
    DRAGON,
    PEGASUS,
    FLYINGDOG,
    YOSHI;

    public static Creature randomCreature() {
        Creature[] allCreatures = values();
        Random randomNumber = new Random();
        int randomInt = randomNumber.nextInt(allCreatures.length + 1);
        return allCreatures[randomInt];
    }
}
