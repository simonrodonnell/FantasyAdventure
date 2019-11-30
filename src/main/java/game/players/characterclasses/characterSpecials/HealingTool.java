package game.players.characterclasses.characterSpecials;

import java.util.Random;

public enum HealingTool {

    POTIONS (20),
    HERBS (15),
    OINTMENTS (10),
    MAGICPIPES (50);

    private int healingFactor;

    private HealingTool(int healingFactor){
        this.healingFactor = healingFactor;
    }

    public static HealingTool randomHealingTool() {
        HealingTool[] allHealingTools = values();
        Random randomNumber = new Random();
        int randomInt = randomNumber.nextInt(allHealingTools.length + 1);
        return allHealingTools[randomInt];
    }

    public int getHealingFactor() {
        return healingFactor;
    }
}
