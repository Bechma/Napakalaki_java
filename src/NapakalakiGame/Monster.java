/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author oiness
 */
public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence badConsequence;
    private int levelChangeAgainstCultistPlayer;

    public Monster(String name, int combatLevel, Prize prize, BadConsequence bc) {
        this.name = name;
        this.combatLevel = combatLevel;
        this.prize = prize;
        this.badConsequence = bc;
        this.levelChangeAgainstCultistPlayer = 0;
    }
    
    public Monster(String name, int combatLevel, Prize prize, BadConsequence bc, int ic) {
        this.name = name;
        this.combatLevel = combatLevel;
        this.prize = prize;
        this.badConsequence = bc;
        this.levelChangeAgainstCultistPlayer = ic;
    }

    public Prize getPrize() {
        return prize;
    }

    public int getLevelChangeAgainstCultistPlayer() {
        return levelChangeAgainstCultistPlayer;
    }
    
    public int getCombatLevelAgainstCultistPlayer() {
        return this.levelChangeAgainstCultistPlayer+combatLevel;
    }
    

    public String getName() {
        return name;
    }

    public int getCombatLevel() {
        return combatLevel;
    }

    public int getLevelsGained() {
        return prize.getLevel();
    }
    
    public int getTreasuresGained(){
        return prize.getTreasures();
    }

    public BadConsequence getBadConsequence() {
        return badConsequence;
    }
    
    public String toString(){
        return "\nNombre = " + name + 
                "\nNivel combate = " + Integer.toString(combatLevel) +
                "\nPremio:\n" + prize.toString() +
                "\nMal royo:\n" + badConsequence.toString();
    }
    
}
