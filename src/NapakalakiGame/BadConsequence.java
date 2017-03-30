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
 * @author bruchemat
 */
public abstract class BadConsequence {
    
    // Atributos
    static final int MAXTREASURES = 10;
    protected String text;
    protected int levels;
    
    
    // Métodos
    public abstract boolean isEmpty();
    
    public abstract void substractVisibleTreasure(Treasure t);
    
    public abstract void substractHiddenTreasure(Treasure t);
    
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h);
    
    // Constructores
    public BadConsequence(String text, int levels){
        this.text = text;
        this.levels = levels;
    }

    // Getters ( getText() EXTRA)
    public String getText() {
        return text;
    }
    public int getLevels() {
        return levels;
    }
    
    
    
    
    /*
    @Override
    public String toString(){
        return " Texto = " + text + "\n Niveles perdidos = " + Integer.toString(levels) + 
                "\n Tesoros visibles = " + Integer.toString(nVisibleTreasures) +
                "\n Tesoros ocultos = " + Integer.toString(nHiddenTreasures) +
                "\n Tesoros especificos visibles = " + specificVisibleTreasures.toString() +
                "\n Tesoros especificos ocultos = " + specificHiddenTreasures.toString() +
                "\n Muerto = " + Boolean.toString(death) + "\n";
    }
*/
}
