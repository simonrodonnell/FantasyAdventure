package game.players.characterclasses.characterSpecials;

public enum HealingTool {

    POTIONS (20),
    HERBS (15),
    OINTMENTS (10),
    MAGICPIPES (50);

    private int healingFactor;

    private HealingTool(int healingFactor){
        this.healingFactor = healingFactor;
    }

    public int getHealingFactor() {
        return healingFactor;
    }
}
