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
public class NumericBadConsequence extends BadConsequence{
    private int nVisibleTreasures, nHiddenTreasures;

    public NumericBadConsequence(String text, int levels, int nVisibleTreasures, int nHiddenTreasures) {
        super(text, levels);
        this.nVisibleTreasures = nVisibleTreasures;
        this.nHiddenTreasures = nHiddenTreasures;
    }
    
    @Override
    public boolean isEmpty(){
        return nVisibleTreasures == 0 && nHiddenTreasures == 0;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        if (nVisibleTreasures > 0)
            nVisibleTreasures--;
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        if (nHiddenTreasures > 0)
            nHiddenTreasures--;
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        NumericBadConsequence devolver = null;
        
        devolver = new NumericBadConsequence(text,levels,this.nVisibleTreasures,this.nHiddenTreasures);
        if(devolver.nHiddenTreasures > h.size()) devolver.nHiddenTreasures = h.size();
        if(devolver.nVisibleTreasures > v.size()) devolver.nVisibleTreasures = v.size();
        
        return devolver;
    }
    
    public int getnVisibleTreasures() {
        return nVisibleTreasures;
    }
    public int getnHiddenTreasures() {
        return nHiddenTreasures;
    }
    
    @Override
    public String toString(){
        return " Texto = " + text + "\n Niveles perdidos = " + Integer.toString(levels) + 
                "\n Tesoros visibles = " + Integer.toString(nVisibleTreasures) +
                "\n Tesoros ocultos = " + Integer.toString(nHiddenTreasures);
    }
}
