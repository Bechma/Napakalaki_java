/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author oiness
 */
public class SpecificBadConsequence extends BadConsequence{
    private ArrayList<TreasureKind>specificVisibleTreasures = new ArrayList();
    private ArrayList<TreasureKind>specificHiddenTreasures = new ArrayList();

    public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> v, ArrayList<TreasureKind> h) {
        super(text, levels);
        this.specificVisibleTreasures = v;
        this.specificHiddenTreasures = h;
    }
    
    
    
    @Override
    public boolean isEmpty(){
        return specificHiddenTreasures.size() < 1 && specificVisibleTreasures.size() < 1;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        specificVisibleTreasures.remove(t.getType());
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        specificHiddenTreasures.remove(t.getType());
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        SpecificBadConsequence devolver = null;
        
        ArrayList<TreasureKind> aux_v = new ArrayList();
        for(Treasure t : v)
            if(specificVisibleTreasures.contains(t.getType()))
                aux_v.add(t.getType());
            
        ArrayList<TreasureKind> aux_h = new ArrayList();
            
        for(Treasure tr : h) 
            if(specificHiddenTreasures.contains(tr.getType()) && 
                Collections.frequency(specificHiddenTreasures, tr.getType()) >= Collections.frequency(aux_h, tr.getType()))
                aux_h.add(tr.getType());
            
        devolver = new SpecificBadConsequence(text, levels, aux_v, aux_h);
        
        return devolver;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    
    @Override
    public String toString(){
        return " Texto = " + text + "\n Niveles perdidos = " + Integer.toString(levels) + 
                "\n Tesoros especificos visibles = " + specificVisibleTreasures.toString() +
                "\n Tesoros especificos ocultos = " + specificHiddenTreasures.toString();
    }
}
