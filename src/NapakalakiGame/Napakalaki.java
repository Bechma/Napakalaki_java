/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;


/**
 *
 * @author bruchemat
 */
public class Napakalaki {
    
    private static Napakalaki instance = null;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer = null;
    private Monster currentMonster;
        
    private Napakalaki(){
        dealer = null;
        currentMonster = null;
        currentPlayer = null;
        players = new ArrayList();
    }
    
    private void initPlayers(ArrayList<String> names ){
        for( String m : names){
            Player x = new Player(m);
            players.add(x);
        }
    }
    
    private Player nextPlayer(){
        if(currentPlayer == null){
            Random primer_jugador = new Random();
            int numero = primer_jugador.nextInt(players.size());
            currentPlayer = players.get(numero);
        }
        else{
            int contador;
            boolean encontrado = false;
            for(contador = 0; contador < players.size() && !encontrado; contador++)
                if(players.get(contador) == currentPlayer){
                    encontrado = true;
                }
            currentPlayer = players.get(contador % players.size());
        }
        
        return currentPlayer;
    }
    
    private boolean nextTurnAllowed(){
        if(currentPlayer == null)
            return true;
        return currentPlayer.validState();
    }
    
    private void setEnemies(){
        int i = 0;
        while(i < players.size()){
            Random enemigo = new Random();
            int numero_enemigo = enemigo.nextInt(players.size());
            if(numero_enemigo != i){
                players.get(i).setEnemy(players.get(numero_enemigo));
                i++;
            }
        }
    }

    public static Napakalaki getInstance() {
        if (instance == null) {
            instance = new Napakalaki();
        }
        return instance;
    }
    
    public CombatResult developCombat(){
        CombatResult a = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        if(a == CombatResult.LOSEANDCONVERT){
            CultistPlayer culto = new CultistPlayer(currentPlayer,dealer.nextCultist());
            
            for(int i = 0; i < players.size(); i++){
                if(players.get(i) == currentPlayer)
                    players.set(i, culto);
                
                if(players.get(i).enemy == currentPlayer)
                    players.get(i).setEnemy(culto);
            }
            currentPlayer = culto;
        }
        return a;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for( Treasure treasure : treasures){
            currentPlayer.discardVisibleTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        for( Treasure treasure : treasures){
            currentPlayer.discardHiddenTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        treasures.forEach(currentPlayer::makeTreasureVisible);
    }
    
    public void initGame(ArrayList<String> names ){
        dealer = CardDealer.getInstance();
        this.initPlayers(names);
        this.setEnemies();
        dealer.initCards();
        this.nextTurn();
        
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Monster getCurrentMonster() {
        return currentMonster;
    }
    
    public boolean nextTurn(){
        boolean stateOK = this.nextTurnAllowed();
        if(stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            if(currentPlayer.isDead())
                currentPlayer.initTreasures();
        }
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINGAME;
    }
    
}
