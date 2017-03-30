/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import NapakalakiGame.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author bechma
 */
public class NapakalakiView extends javax.swing.JFrame {
    protected Napakalaki napakalakiModel;
    
    public void setNapakalaki(Napakalaki a){
        napakalakiModel = a;
        resultadoCombate.setVisible(false);
        combat.setVisible(false);
        monsterView1.setVisible(false);
        meetMonster.setVisible(true);
        nextTurn.setVisible(false);
        
        playerView1.setPlayer(napakalakiModel.getCurrentPlayer());
        monsterView1.setMonster(napakalakiModel.getCurrentMonster());
        
    }
    
    /**
     * Creates new form NapakalakiView
     */
    public NapakalakiView() {
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

        playerView1 = new GUI.PlayerView();
        monsterView1 = new GUI.MonsterView();
        meetMonster = new javax.swing.JButton();
        combat = new javax.swing.JButton();
        nextTurn = new javax.swing.JButton();
        resultadoCombate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        meetMonster.setText("Encararse con el monstruo");
        meetMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meetMonsterActionPerformed(evt);
            }
        });

        combat.setText("Combatir");
        combat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatActionPerformed(evt);
            }
        });

        nextTurn.setText("Siguiente turno");
        nextTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTurnActionPerformed(evt);
            }
        });

        resultadoCombate.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(monsterView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultadoCombate)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(combat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(meetMonster))
                    .addComponent(nextTurn))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(monsterView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resultadoCombate)
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(meetMonster)
                            .addComponent(combat))
                        .addGap(18, 18, 18)
                        .addComponent(nextTurn))
                    .addComponent(playerView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void meetMonsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meetMonsterActionPerformed
        // TODO add your handling code here:
        monsterView1.setVisible(true);
        meetMonster.setVisible(false);
        combat.setVisible(true);
    }//GEN-LAST:event_meetMonsterActionPerformed

    private void combatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatActionPerformed
        // TODO add your handling code here:
        CombatResult CR = napakalakiModel.developCombat();
        switch (CR) {
            case WINGAME : 
              resultadoCombate.setText("HAS GANADO EL JUEGO");
        {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(NapakalakiView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
              System.exit(0);
              break;
            case WIN :
              resultadoCombate.setText("Has ganado el combate");
              break;
            case LOSE :
              resultadoCombate.setText("Has perdido el combate");
              break;
            case LOSEANDCONVERT:
              resultadoCombate.setText("Has perdido y además ahora eres un cultist");
                break;
          }
        playerView1.setPlayer(napakalakiModel.getCurrentPlayer());
        combat.setVisible(false);
        resultadoCombate.setVisible(true);
        nextTurn.setVisible(true);
    }//GEN-LAST:event_combatActionPerformed

    private void nextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTurnActionPerformed
        // TODO add your handling code here:
        boolean turnoSig = napakalakiModel.nextTurn();
        if(turnoSig){
            setNapakalaki(napakalakiModel);
            nextTurn.setVisible(false);
        }
    }//GEN-LAST:event_nextTurnActionPerformed

    
    public void showView() {
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton combat;
    private javax.swing.JButton meetMonster;
    private GUI.MonsterView monsterView1;
    private javax.swing.JButton nextTurn;
    private GUI.PlayerView playerView1;
    private javax.swing.JLabel resultadoCombate;
    // End of variables declaration//GEN-END:variables
}
