/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.Random;

/**
 *
 * @author oiness
 */
public class CultistPlayer extends Player {
    private static int totalCultistPlayers = 0;
    private Cultist myCard;
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        this.myCard = c;
        totalCultistPlayers++;
    }
    
    @Override
    protected int getCombatLevel(){
        return (int) (1.2*super.getCombatLevel() + myCard.getGainedLevels()*totalCultistPlayers);
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    @Override
    protected Treasure giveMeATreasure(){
        Random m = new Random();
        return getVisibleTreasures().get(m.nextInt(getVisibleTreasures().size()));
    }
    
    @Override
    protected boolean canYouGiveMeATreasure(){
        return getVisibleTreasures().size() > 0;
    }

    public static int getTotalCultistPlayers() {
        return totalCultistPlayers;
    }
    
    
}
