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
public class Backup {
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * /
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author bruchemat
 * /
public class BadConsequence {
    
    // Atributos
    static final int MAXTREASURES = 10;
    private String text;
    private int levels, nVisibleTreasures, nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind>specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind>specificVisibleTreasures = new ArrayList();
    
    // Métodos
    public boolean isEmpty(){
        return nVisibleTreasures < 1 && nHiddenTreasures < 1 && specificHiddenTreasures.size() < 1 && specificVisibleTreasures.size() < 1;
    }
    
    public void substractVisibleTreasure(Treasure t){
        if (nVisibleTreasures < 1)
            specificVisibleTreasures.remove(t.getType());
        else if (nVisibleTreasures > 0)
            nVisibleTreasures--;
    }
    
    public void substractHiddenTreasure(Treasure t){
        if(nHiddenTreasures < 1)
            specificHiddenTreasures.remove(t.getType());
        else  if (nHiddenTreasures > 0)
            nHiddenTreasures--;
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        BadConsequence devolver = null;
        
        if(this.nHiddenTreasures > 0 || this.nVisibleTreasures > 0){
            devolver = new BadConsequence(text,levels,this.nVisibleTreasures,this.nHiddenTreasures);
            if(devolver.nHiddenTreasures > h.size()) devolver.nHiddenTreasures = h.size();
            if(devolver.nVisibleTreasures > v.size()) devolver.nVisibleTreasures = v.size();
        }
        else if(specificVisibleTreasures.size() > 0 || specificHiddenTreasures.size() > 0){
            ArrayList<TreasureKind> aux_v = new ArrayList();
            for(Treasure t : v)
                if(specificVisibleTreasures.contains(t.getType()))
                    aux_v.add(t.getType());
            
            ArrayList<TreasureKind> aux_h = new ArrayList();
            
            for(Treasure tr : h) 
                if(specificHiddenTreasures.contains(tr.getType()) && 
                    Collections.frequency(specificHiddenTreasures, tr.getType()) >= Collections.frequency(aux_h, tr.getType()))
                    aux_h.add(tr.getType());
            
            devolver = new BadConsequence(text, levels, aux_v, aux_h);
        }
        else if(death){
            devolver = new BadConsequence(text, this.death);
        }
                
        return devolver;
    }
    
    // Constructores
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.death = false;
        this.nHiddenTreasures = nHidden;
        this.nVisibleTreasures = nVisible;
        this.levels = levels;
    }
    public BadConsequence(String text, boolean death) {
        this.text = text;
        this.death = death;
        this.nHiddenTreasures = 0;
        this.nVisibleTreasures = 0;
        this.levels = 0;
    }
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,
ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.specificHiddenTreasures = tHidden;
        this.specificVisibleTreasures = tVisible;
        this.nHiddenTreasures = 0;
        this.nVisibleTreasures = 0;
    }

    // Getters ( getText() EXTRA)
    public String getText() {
        return text;
    }
    public int getLevels() {
        return levels;
    }
    public int getnVisibleTreasures() {
        return nVisibleTreasures;
    }
    public int getnHiddenTreasures() {
        return nHiddenTreasures;
    }
    public boolean isDeath() {
        return death;
    }
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    
    //toString EXTRA
    @Override
    public String toString(){
        return " Texto = " + text + "\n Niveles perdidos = " + Integer.toString(levels) + 
                "\n Tesoros visibles = " + Integer.toString(nVisibleTreasures) +
                "\n Tesoros ocultos = " + Integer.toString(nHiddenTreasures) +
                "\n Tesoros especificos visibles = " + specificVisibleTreasures.toString() +
                "\n Tesoros especificos ocultos = " + specificHiddenTreasures.toString() +
                "\n Muerto = " + Boolean.toString(death) + "\n";
    }
}

    
    // 1º
        BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura"
                + " visible y otra oculta", 0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2,1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, prize, badConsequence));
        
        // 2º
        badConsequence = new BadConsequence("Embobados con el lindo primigenio"
                + " te descartas de tu casco visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), 
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Tenochtitlan", 2, prize, badConsequence));
        
        // 3º
        badConsequence = new BadConsequence("El primordial bostezo " +
                "contagioso. Pierdes el calzado visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.SHOE)), 
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, prize, badConsequence));
        
        // 4º
        badConsequence = new BadConsequence("Te atrapan para llevarte " +
                "de fiesta y te dejan caer en mitad del " +
                "vuelo. Descarta 1 mano visible y 1 " +
                "mano oculta", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Demonios de Magaluf", 2, prize, badConsequence));
        
        // 5º
        badConsequence = new BadConsequence("Pierdes todos tus tesoros "
                + "visibles", 0, BadConsequence.MAXTREASURES, 0);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 13, prize, badConsequence));
        
        // 6º
        badConsequence = new BadConsequence("Pierdes la armadura " +
                "visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, prize, badConsequence));
        
        // 7º
        badConsequence = new BadConsequence("Sientes bichos bajo la " +
                "ropa. Descarta la armadura visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Necrófago", 13, prize, badConsequence));
        
        // 8º
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros "
                + "visibles", 5, 3, 0);
        prize = new Prize(3,2);
        unusedMonsters.add(new Monster("El rey de rosado", 11, prize, badConsequence));
        
        // 9º
        badConsequence = new BadConsequence("Toses los pulmones y " +
                "pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Flecher", 2, prize, badConsequence));
        
        // 10º
        badConsequence = new BadConsequence(
            "Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto.",
            true );
        prize = new Prize( 2, 1 );
        unusedMonsters.add( new Monster( "Los hondos", 8, prize, badConsequence) );
        
        // 11º
        badConsequence = new BadConsequence(
            "Pierdes 2 niveles y 2 tesoros ocultos.",
            2, 0, 2 );
        prize = new Prize( 2, 1 );
        unusedMonsters.add( new Monster( "Semillas Cthulhu", 4, prize, badConsequence) );
        
        // 12º
        badConsequence = new BadConsequence(
            "Te intentas escaquear. Pierdes un tesoro a una mano visible.",
            0,
            new ArrayList( Arrays.asList( TreasureKind.ONEHAND ) ),
            new ArrayList( ) );
        prize = new Prize( 2, 1 );
        unusedMonsters.add( new Monster( "Dameargo", 1, prize, badConsequence) );
        
        // 13º
        badConsequence = new BadConsequence(
            "Da mucho asquito. Pierdes 3 niveles.",
            3, 0, 0 );
        prize = new Prize( 2, 1 );
        unusedMonsters.add( new Monster( "Pollipólipo volante", 3, prize, badConsequence) );
        
        // 14º
        badConsequence = new BadConsequence(
            "No le hace gracia que pronuncien mal su nombre. Estás muerto.",
            true );
        prize = new Prize( 3, 1 );
        unusedMonsters.add( new Monster( "Yskhtihyssg-Goth", 14, prize, badConsequence) );
        
        // 15º
        badConsequence = new BadConsequence(
            "La familia te atrapa. Estás muerto.",
            true );
        prize = new Prize( 3, 1 );
        unusedMonsters.add( new Monster( "Familia feliz", 1, prize, badConsequence) );
        
        // 16º
        badConsequence = new BadConsequence(
            "La quinta directiva primaria te obliga a perder 2 niveles y un tesoro a 2 manos visible.",
            2,
            new ArrayList( Arrays.asList( TreasureKind.BOTHHANDS ) ),
            new ArrayList( ) );
        prize = new Prize( 2, 1 );
        unusedMonsters.add( new Monster( "Roboggoth", 8, prize, badConsequence) );
        
        // 17º
        badConsequence = new BadConsequence(
            "Te asusta en la noche. Pierdes un casco visible.",
            0,
            new ArrayList( Arrays.asList( TreasureKind.HELMET ) ),
            new ArrayList( ) );
        prize = new Prize( 1, 1 );
        unusedMonsters.add( new Monster( "El espía sordo", 5, prize, badConsequence) );
        
        // 18º
        badConsequence = new BadConsequence(
            "Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.",
            2, 5, 0 );
        prize = new Prize( 2, 1 );
        unusedMonsters.add( new Monster( "Tongue", 19, prize, badConsequence) );
        
        // 19º
        badConsequence = new BadConsequence("Te faltan manos para " +
                "tanta cabeza. Pierdes 3 niveles y tus " +
                "tesoros visibles de las manos.", 3, 
                new ArrayList( Arrays.asList( TreasureKind.BOTHHANDS ) ), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Bicéfalo", 21, prize, badConsequence));
        
        // 19º
        badConsequence = new BadConsequence("Te faltan manos para " +
                "tanta cabeza. Pierdes 3 niveles y tus " +
                "tesoros visibles de las manos.", 3, 
                new ArrayList( Arrays.asList( TreasureKind.BOTHHANDS ) ), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Bicéfalo", 21, prize, badConsequence));
        
        // 20º
        badConsequence = new BadConsequence("Pierdes 1 mano visible", 0, 
                new ArrayList( Arrays.asList( TreasureKind.ONEHAND ) ), 
                new ArrayList());
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, prize, badConsequence,-2));
        
        // 21º
        badConsequence = new BadConsequence("Pierdes tus tesoros visibles. Jajaja.", 0, 
                BadConsequence.MAXTREASURES, 0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos Oculares", 6, prize, badConsequence, 2));
        
        // 22º
        badConsequence = new BadConsequence("Hoy no es tu día de suerte. Mueres.", true);
        prize = new Prize(2,5);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, prize, badConsequence, 4));
        
        // 23º
        badConsequence = new BadConsequence("Tu gobierno te recorta 2 niveles.", 2, 
                new ArrayList(), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente Político", 8, prize, badConsequence, -2));
        
        // 24º
        badConsequence = new BadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.", 0, 
                new ArrayList( Arrays.asList( TreasureKind.HELMET, TreasureKind.ARMOR ) ), 
                new ArrayList( Arrays.asList(TreasureKind.BOTHHANDS, TreasureKind.ONEHAND, TreasureKind.ONEHAND)));
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, prize, badConsequence, 5));
        
        // 25º
        badConsequence = new BadConsequence("Pierdes 2 niveles.", 2, 
                new ArrayList(), 
                new ArrayList());
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("Shoggoth", 16, prize, badConsequence, -4));
        
        // 26º
        badConsequence = new BadConsequence("Pintalabios negro. Pierdes 2 niveles.", 2, 
                new ArrayList(), 
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, prize, badConsequence, 3));
    */
}
