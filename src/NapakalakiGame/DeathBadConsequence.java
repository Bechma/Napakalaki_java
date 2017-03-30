/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author oiness
 */
public class DeathBadConsequence extends NumericBadConsequence {
    private boolean death;

    public DeathBadConsequence(String text, boolean death) {
        super(text, 0, 0, 0);
        this.death = death;
    }
    
    @Override
    public boolean isEmpty(){
        return true;
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        BadConsequence devolver = null;
        devolver = new DeathBadConsequence(text, this.death);        
        return devolver;
    }
    
    public boolean isDeath() {
        return death;
    }
    
    @Override
    public String toString(){
        return " Texto = " + text + "\n Niveles perdidos = " + Integer.toString(levels) + 
                "\n Muerto = " + Boolean.toString(death) + "\n";
    }
}
