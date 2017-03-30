/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 *
 * @author oiness
 */
public class CardDealer {
    private static CardDealer instance = null;
    private ArrayList<Monster> unusedMonsters = new ArrayList(), usedMonsters = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList(), usedTreasures = new ArrayList();
    private ArrayList<Cultist> unusedCultists = new ArrayList();
    
    private CardDealer(){
        
    }

    public static CardDealer getInstance() {
        if (instance == null) {
            instance = new CardDealer();
        }
        return instance;
    }
    
    private void initTreasureCardDeck(){
        unusedTreasures.add(new Treasure("¡Sí, mi amo!", 4, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigación", 3, TreasureKind.SHOE));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia ácida", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora ACME", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la ETSIIT", 1, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de raíl ferroviario", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alópodo", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistórica", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato místico", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metálica", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-comicón", 1, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-gnomicón", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necro-playboycón", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentácula de pega", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOE));
    }
    
    private void initMonsterCardDeck(){
        // 1º
        BadConsequence badConsequence = new SpecificBadConsequence("Pierdes tu armadura"
                + " visible y otra oculta", 0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2,1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, prize, badConsequence));
        
        // 2º
        badConsequence = new SpecificBadConsequence("Embobados con el lindo primigenio"
                + " te descartas de tu casco visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), 
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Tenochtitlan", 2, prize, badConsequence));
        
        // 3º
        badConsequence = new SpecificBadConsequence("El primordial bostezo " +
                "contagioso. Pierdes el calzado visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.SHOE)), 
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, prize, badConsequence));
        
        // 4º
        badConsequence = new SpecificBadConsequence("Te atrapan para llevarte " +
                "de fiesta y te dejan caer en mitad del " +
                "vuelo. Descarta 1 mano visible y 1 " +
                "mano oculta", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Demonios de Magaluf", 2, prize, badConsequence));
        
        // 5º
        badConsequence = new NumericBadConsequence("Pierdes todos tus tesoros "
                + "visibles", 0, BadConsequence.MAXTREASURES, 0);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 13, prize, badConsequence));
        
        // 6º
        badConsequence = new SpecificBadConsequence("Pierdes la armadura " +
                "visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, prize, badConsequence));
        
        // 7º
        badConsequence = new SpecificBadConsequence("Sientes bichos bajo la " +
                "ropa. Descarta la armadura visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Necrófago", 13, prize, badConsequence));
        
        // 8º
        badConsequence = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros "
                + "visibles", 5, 3, 0);
        prize = new Prize(3,2);
        unusedMonsters.add(new Monster("El rey de rosado", 11, prize, badConsequence));
        
        // 9º
        badConsequence = new NumericBadConsequence("Toses los pulmones y " +
                "pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Flecher", 2, prize, badConsequence));
        
        // 10º
        badConsequence = new DeathBadConsequence(
            "Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto.",
            true );
        prize = new Prize( 2, 1 );
        unusedMonsters.add( new Monster( "Los hondos", 8, prize, badConsequence) );
        
        // 11º
        badConsequence = new NumericBadConsequence(
            "Pierdes 2 niveles y 2 tesoros ocultos.",
            2, 0, 2 );
        prize = new Prize( 2, 1 );
        unusedMonsters.add( new Monster( "Semillas Cthulhu", 4, prize, badConsequence) );
        
        // 12º
        badConsequence = new SpecificBadConsequence(
            "Te intentas escaquear. Pierdes un tesoro a una mano visible.",
            0,
            new ArrayList( Arrays.asList( TreasureKind.ONEHAND ) ),
            new ArrayList( ) );
        prize = new Prize( 2, 1 );
        unusedMonsters.add( new Monster( "Dameargo", 1, prize, badConsequence) );
        
        // 13º
        badConsequence = new NumericBadConsequence(
            "Da mucho asquito. Pierdes 3 niveles.",
            3, 0, 0 );
        prize = new Prize( 2, 1 );
        unusedMonsters.add( new Monster( "Pollipólipo volante", 3, prize, badConsequence) );
        
        // 14º
        badConsequence = new DeathBadConsequence(
            "No le hace gracia que pronuncien mal su nombre. Estás muerto.",
            true );
        prize = new Prize( 3, 1 );
        unusedMonsters.add( new Monster( "Yskhtihyssg-Goth", 14, prize, badConsequence) );
        
        // 15º
        badConsequence = new DeathBadConsequence(
            "La familia te atrapa. Estás muerto.",
            true );
        prize = new Prize( 3, 1 );
        unusedMonsters.add( new Monster( "Familia feliz", 1, prize, badConsequence) );
        
        // 16º
        badConsequence = new SpecificBadConsequence(
            "La quinta directiva primaria te obliga a perder 2 niveles y un tesoro a 2 manos visible.",
            2,
            new ArrayList( Arrays.asList( TreasureKind.BOTHHANDS ) ),
            new ArrayList( ) );
        prize = new Prize( 2, 1 );
        unusedMonsters.add( new Monster( "Roboggoth", 8, prize, badConsequence) );
        
        // 17º
        badConsequence = new SpecificBadConsequence(
            "Te asusta en la noche. Pierdes un casco visible.",
            0,
            new ArrayList( Arrays.asList( TreasureKind.HELMET ) ),
            new ArrayList( ) );
        prize = new Prize( 1, 1 );
        unusedMonsters.add( new Monster( "El espía sordo", 5, prize, badConsequence) );
        
        // 18º
        badConsequence = new NumericBadConsequence(
            "Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.",
            2, 5, 0 );
        prize = new Prize( 2, 1 );
        unusedMonsters.add( new Monster( "Tongue", 19, prize, badConsequence) );
        
        // 19º
        badConsequence = new SpecificBadConsequence("Te faltan manos para " +
                "tanta cabeza. Pierdes 3 niveles y tus " +
                "tesoros visibles de las manos.", 3, 
                new ArrayList( Arrays.asList( TreasureKind.BOTHHANDS ) ), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Bicéfalo", 21, prize, badConsequence));
        
        // 19º
        badConsequence = new SpecificBadConsequence("Te faltan manos para " +
                "tanta cabeza. Pierdes 3 niveles y tus " +
                "tesoros visibles de las manos.", 3, 
                new ArrayList( Arrays.asList( TreasureKind.BOTHHANDS ) ), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Bicéfalo", 21, prize, badConsequence));
        
        // 20º
        badConsequence = new SpecificBadConsequence("Pierdes 1 mano visible", 0, 
                new ArrayList( Arrays.asList( TreasureKind.ONEHAND ) ), 
                new ArrayList());
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, prize, badConsequence,-2));
        
        // 21º
        badConsequence = new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja.", 0, 
                BadConsequence.MAXTREASURES, 0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos Oculares", 6, prize, badConsequence, 2));
        
        // 22º
        badConsequence = new DeathBadConsequence("Hoy no es tu día de suerte. Mueres.", true);
        prize = new Prize(2,5);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, prize, badConsequence, 4));
        
        // 23º
        badConsequence = new SpecificBadConsequence("Tu gobierno te recorta 2 niveles.", 2, 
                new ArrayList(), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente Político", 8, prize, badConsequence, -2));
        
        // 24º
        badConsequence = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.", 0, 
                new ArrayList( Arrays.asList( TreasureKind.HELMET, TreasureKind.ARMOR ) ), 
                new ArrayList( Arrays.asList(TreasureKind.BOTHHANDS, TreasureKind.ONEHAND, TreasureKind.ONEHAND)));
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, prize, badConsequence, 5));
        
        // 25º
        badConsequence = new SpecificBadConsequence("Pierdes 2 niveles.", 2, 
                new ArrayList(), 
                new ArrayList());
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("Shoggoth", 16, prize, badConsequence, -4));
        
        // 26º
        badConsequence = new SpecificBadConsequence("Pintalabios negro. Pierdes 2 niveles.", 2, 
                new ArrayList(), 
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, prize, badConsequence, 3));
    }
    
    private void initCultistCardDeck(){
        for(int i = 0; i < 4; i++)
            unusedCultists.add(new Cultist("Sectario", 1));
        unusedCultists.add(new Cultist("Sectario", 2));
        unusedCultists.add(new Cultist("Sectario", 2));
    }
    
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    
    private void shuffleCultist(){
        Collections.shuffle(unusedCultists);
    }
    
    public Cultist nextCultist(){
        if(this.unusedCultists.isEmpty()){
            this.initCultistCardDeck();
            this.shuffleCultist();
        }
        Cultist c = unusedCultists.get(0);
        unusedCultists.remove(0);
        return c;
    }
    
    public Treasure nextTreasure(){
        if(unusedTreasures.isEmpty()){
            unusedTreasures.addAll(usedTreasures);
            shuffleTreasures();
            usedTreasures.clear();
        }
        Treasure t = unusedTreasures.get(0);
        unusedTreasures.remove(0);
        return t;
    }
    
    public Monster nextMonster(){
        if(unusedMonsters.isEmpty()){
            unusedMonsters.addAll(usedMonsters);
            shuffleMonsters();
            usedMonsters.clear();
        }
        Monster m = unusedMonsters.get(0);
        unusedMonsters.remove(0);
        return m;
    }
    
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    
    public void initCards(){
        initMonsterCardDeck();
        shuffleMonsters();
        initTreasureCardDeck();
        shuffleTreasures();
        initCultistCardDeck();
        shuffleCultist();
    }
}
