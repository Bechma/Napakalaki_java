/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.Napakalaki;
import NapakalakiGame.Player;
import NapakalakiGame.Treasure;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author bechma
 */
public class PlayerView extends javax.swing.JPanel {
    protected Player playerModel;
    private Napakalaki napakalakiModel = Napakalaki.getInstance();
    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombre = new javax.swing.JLabel();
        nivel = new javax.swing.JLabel();
        sectario = new javax.swing.JLabel();
        enemyName = new javax.swing.JLabel();
        visibleTreasures = new javax.swing.JPanel();
        hiddenTreasures = new javax.swing.JPanel();
        etqVisibles = new javax.swing.JLabel();
        etqOcultos = new javax.swing.JLabel();
        robarTesoro = new javax.swing.JButton();
        hacerTesoroVisible = new javax.swing.JButton();
        descartarTesoro = new javax.swing.JButton();
        descartarTODO = new javax.swing.JButton();
        pendingBadConsequenceView1 = new GUI.PendingBadConsequenceView();

        nombre.setText("Nombre");

        nivel.setText("Nivel");

        sectario.setText("Sectario??");

        enemyName.setText("enemy_name");

        visibleTreasures.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(27, 255, 0)));
        visibleTreasures.setLayout(new javax.swing.BoxLayout(visibleTreasures, javax.swing.BoxLayout.Y_AXIS));

        hiddenTreasures.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        hiddenTreasures.setLayout(new javax.swing.BoxLayout(hiddenTreasures, javax.swing.BoxLayout.Y_AXIS));

        etqVisibles.setText("Tesoros Visibles");

        etqOcultos.setText("Tesoros Ocultos");

        robarTesoro.setText("Robar Treasure");
        robarTesoro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robarTesoroActionPerformed(evt);
            }
        });

        hacerTesoroVisible.setText("Hacer tesoro visible");
        hacerTesoroVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hacerTesoroVisibleActionPerformed(evt);
            }
        });

        descartarTesoro.setText("Descartar Tesoro");
        descartarTesoro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descartarTesoroActionPerformed(evt);
            }
        });

        descartarTODO.setText("Descartar todos los tesoros");
        descartarTODO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descartarTODOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombre)
                        .addGap(109, 109, 109)
                        .addComponent(nivel)
                        .addGap(44, 44, 44)
                        .addComponent(sectario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(enemyName))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(44, 44, 44)
                        .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(etqVisibles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etqOcultos)
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(robarTesoro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(149, 149, 149)
                                        .addComponent(descartarTesoro))
                                    .addComponent(hacerTesoroVisible)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(descartarTODO))
                            .addComponent(pendingBadConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre)
                    .addComponent(nivel)
                    .addComponent(sectario)
                    .addComponent(enemyName))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(robarTesoro)
                    .addComponent(hacerTesoroVisible)
                    .addComponent(descartarTesoro))
                .addGap(18, 18, 18)
                .addComponent(descartarTODO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqVisibles)
                    .addComponent(etqOcultos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pendingBadConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void robarTesoroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_robarTesoroActionPerformed
        // TODO add your handling code here:
        
        playerModel.stealTreasure();
        robarTesoro.setVisible(false);
        repaint();
        revalidate();
    }//GEN-LAST:event_robarTesoroActionPerformed

    private void hacerTesoroVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hacerTesoroVisibleActionPerformed
        // TODO add your handling code here:
        ArrayList<Treasure> selHidden = getSelectedTreasures (hiddenTreasures);
        napakalakiModel.makeTreasuresVisible (selHidden);
        setPlayer (napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_hacerTesoroVisibleActionPerformed

    private void descartarTesoroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descartarTesoroActionPerformed
        // TODO add your handling code here:
        ArrayList<Treasure> selHidden = getSelectedTreasures (hiddenTreasures);
        ArrayList<Treasure> selVisible = getSelectedTreasures (visibleTreasures);
        napakalakiModel.discardHiddenTreasures(selHidden);
        napakalakiModel.discardVisibleTreasures(selVisible);
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_descartarTesoroActionPerformed

    private void descartarTODOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descartarTODOActionPerformed
        // TODO add your handling code here:
        napakalakiModel.getCurrentPlayer().discardAllTreasures();
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_descartarTODOActionPerformed

    public void setNapakalaki(Napakalaki a){
        // Ya lo tengo inicializado en la parte superior de la clase.
    }
    
    private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {
        // Se recorren los tesoros que contiene el panel,
        // almacenando en un vector aquellos que están seleccionados.
        // Finalmente se devuelve dicho vector.
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            if ( tv.isSelected() )
            output.add ( tv.getTreasure() );
        }
        return output;
    }
    
    public void setPlayer(Player p){
        playerModel = p;
        
        this.enemyName.setText("Enemigo: " + playerModel.getEnemyName());
        this.nivel.setText(playerModel.getLevel()+"");
        this.nombre.setText("Nombre: " + playerModel.getName());
        
        if(playerModel.getClass().getSimpleName().equals("CultistPlayer"))
            sectario.setText("Soy Sectario");
        else
            sectario.setText("NO soy sectario");
        
        if(playerModel.canISteal())
            robarTesoro.setVisible(true);
        else
            robarTesoro.setVisible(false);
        
        this.pendingBadConsequenceView1.setBadConsequence(playerModel.getPendingBadConsequence());
        
        // Incluir instrucciones para actualizar su nombre, nivel, etc.
        // A continuación se actualizan sus tesoros
        fillTreasurePanel (visibleTreasures, playerModel.getVisibleTreasures());
        fillTreasurePanel (hiddenTreasures, playerModel.getHiddenTreasures());
        repaint();
        revalidate();
    }
    
    private void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) {
        // Se elimina la información antigua
        aPanel.removeAll();
        // Se recorre la lista de tesoros construyendo y añadiendo sus vistas
        // al panel
        for (Treasure t : aList) {
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure (t);
            aTreasureView.setVisible (true);
            aPanel.add (aTreasureView);
        }
        // Se fuerza la actualización visual del panel
        aPanel.repaint();
        aPanel.revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton descartarTODO;
    private javax.swing.JButton descartarTesoro;
    private javax.swing.JLabel enemyName;
    private javax.swing.JLabel etqOcultos;
    private javax.swing.JLabel etqVisibles;
    private javax.swing.JButton hacerTesoroVisible;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JLabel nivel;
    private javax.swing.JLabel nombre;
    private GUI.PendingBadConsequenceView pendingBadConsequenceView1;
    private javax.swing.JButton robarTesoro;
    private javax.swing.JLabel sectario;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
