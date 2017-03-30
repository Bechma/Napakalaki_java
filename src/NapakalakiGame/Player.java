/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Random;
import GUI.Dice;

/**
 *
 * @author oiness
 */
public class Player {
    static final int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead, canISteal;
    protected Player enemy;
    private BadConsequence pendingBadConsequence;
    private ArrayList<Treasure> hiddenTreasures, visibleTreasures;

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", level=" + level + '}';
    }

    public BadConsequence getPendingBadConsequence() {
        return pendingBadConsequence;
    }

    public String getEnemyName(){
        return enemy.getName();
    }
    
    public Player(String name) {
        this.name = name;
        level = 1;
        hiddenTreasures = new ArrayList();
        visibleTreasures = new ArrayList();
        dead = true;
        canISteal = true;
    }
    
    private void bringToLife(){
        dead = false;
    }
    private void incrementLevels(int l){
        if(level + l >= MAXLEVEL)
            level = MAXLEVEL;
        else
            level += l;
    }
    private void decrementLevels(int l){
        if( level - l < 1)
            level = 1;
        else
            level -= l;
    }
    private void setPendingBadConsequence(BadConsequence b){
        this.pendingBadConsequence = b;
    }
    private void applyPrize(Monster m){
        incrementLevels(m.getLevelsGained());
        int nTreasures = m.getTreasuresGained();
        if( nTreasures > 0){
            CardDealer dealer = CardDealer.getInstance();
            for(int i = 0; i < nTreasures; i++)
                hiddenTreasures.add(dealer.nextTreasure());
        }
    }
    private void applyBadConsequence(Monster m){
        BadConsequence badConsequence = m.getBadConsequence();
        int nLevels = badConsequence.getLevels();
        decrementLevels(nLevels);
        this.setPendingBadConsequence(badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures));
    }
    
    protected int getCombatLevel(){
        int devolver = level;
        
        for(Treasure m : visibleTreasures)
               devolver += m.getBonus();
        
        return devolver;
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        boolean devolver = true;
        switch(t.getType()){
            case ARMOR: case HELMET: case SHOE:
                for( Treasure m : visibleTreasures){
                    devolver = !(m.getType() == t.getType());
                    if(!devolver)
                        break;
                }
                break;
                
            case ONEHAND:
                int contador = 0;
                for( Treasure x : visibleTreasures){
                    if(x.getType() == t.getType())
                        contador++;
                    if(x.getType() == TreasureKind.BOTHHANDS){
                        contador+=BadConsequence.MAXTREASURES;
                        break;
                    }
                }
                devolver = (contador < 2);
                break;
                
            case BOTHHANDS:
                for(Treasure y : visibleTreasures){
                    devolver = (y.getType() != t.getType() && y.getType() != TreasureKind.ONEHAND);
                    if(!devolver) break;
                }
                break;
        }
        
        return devolver;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        int devolver = 0;
        for(Treasure m : visibleTreasures)
            if(m.getType() == tKind)
                devolver++;
        
        return devolver;
    }
    
    private void dieIfNoTreasures(){
        if( hiddenTreasures.size() < 1 && visibleTreasures.size() < 1)
            dead = true;
    }
    
    public CombatResult combat(Monster m){
        int myLevel = this.getCombatLevel();
        int monsterLevel = this.getOponentLevel(m);
        
        if(!canISteal){
            Dice dice = Dice.getInstance();
            int number = dice.nextNumber();
            if(number < 3){
                int enemyLevel = enemy.getCombatLevel();
                monsterLevel += enemyLevel;
            }
        }
        CombatResult devolver;
        if(myLevel > monsterLevel){
            this.applyPrize(m);
            devolver = (this.level >= MAXLEVEL) ? CombatResult.WINGAME : CombatResult.WIN;
        }
        else{
            this.applyBadConsequence(m);
            devolver = this.shouldConvert() ? CombatResult.LOSEANDCONVERT : CombatResult.LOSE;
        }
            
        return devolver;
    }
    
    public void makeTreasureVisible(Treasure t){
        if(this.canMakeTreasureVisible(t)){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        if(this.pendingBadConsequence != null)
            if(!(this.pendingBadConsequence.isEmpty()))
                this.pendingBadConsequence.substractVisibleTreasure(t);
        this.dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        if(this.pendingBadConsequence != null)
            if(!(this.pendingBadConsequence.isEmpty()))
                this.pendingBadConsequence.substractHiddenTreasure(t);
        this.dieIfNoTreasures();
    }
    
    public boolean validState(){
        if(this.pendingBadConsequence == null)
            return hiddenTreasures.size() <= 4;
        return pendingBadConsequence.isEmpty() && hiddenTreasures.size() <= 4;
    }
    
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        this.bringToLife();
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        int number = dice.nextNumber();
        if(number > 1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        if(number == 6){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    
    public Treasure stealTreasure(){
        Treasure treasure = null;
        if(canISteal())
            if(enemy.canYouGiveMeATreasure()){
                treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                haveStolen();
            }
        return treasure;
    }
    
    protected Treasure giveMeATreasure(){
        Random m = new Random();
        return hiddenTreasures.get(m.nextInt(hiddenTreasures.size()));
    }
    
    protected boolean canYouGiveMeATreasure(){
        return hiddenTreasures.size() > 0;
    }
    
    private void haveStolen(){
        canISteal = false;
    }
    
    public void discardAllTreasures(){
        ArrayList<Treasure> v = new ArrayList(visibleTreasures);
        ArrayList<Treasure> h = new ArrayList(hiddenTreasures);
        CardDealer dealer = CardDealer.getInstance();
        
        v.forEach(dealer::giveTreasureBack);
        h.forEach(dealer::giveTreasureBack);
        
        v.forEach(this::discardVisibleTreasure);
        h.forEach(this::discardHiddenTreasure);
    }
    
    public String getName() {
        return name;
    }
    
    public int getLevel() {
        return level;
    }

    public boolean isDead() {
        return dead;
    }

    public boolean canISteal() {
        return canISteal;
    }

    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }

    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }

    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }
    
    
    
    
    public Player(Player p){
        this.name = p.name;
        this.level = p.level;
        this.dead = p.dead;
        this.canISteal = p.canISteal;
        this.enemy = p.enemy;
        this.pendingBadConsequence = p.pendingBadConsequence;
        this.hiddenTreasures = p.hiddenTreasures;
        this.visibleTreasures = p.visibleTreasures;
    }
    
    protected int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    protected boolean shouldConvert(){
        return Dice.getInstance().nextNumber() == 1;
    }
    
    
}
