/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.BadConsequence;

/**
 *
 * @author bechma
 */
public class BadConsequenceView extends javax.swing.JPanel {
    protected BadConsequence badConsequenceModel;
    
    /**
     * Creates new form BadConsequenceView
     */
    public BadConsequenceView() {
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

        etiqBadConsequence = new javax.swing.JLabel();
        etiqSpecific = new javax.swing.JLabel();

        etiqBadConsequence.setText("Bad Consequence");

        etiqSpecific.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiqSpecific.setText("\"Etiqueta a insertar\"");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(etiqSpecific))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(etiqBadConsequence)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiqBadConsequence)
                .addGap(18, 18, 18)
                .addComponent(etiqSpecific)
                .addContainerGap(93, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setBadConsequence(BadConsequence bc){
        badConsequenceModel = bc;
        
        this.etiqSpecific.setText("<html><li>" + badConsequenceModel.toString().replace("\n", "<li>") + "</html>");
        
        this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etiqBadConsequence;
    private javax.swing.JLabel etiqSpecific;
    // End of variables declaration//GEN-END:variables
}
