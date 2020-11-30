/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.exmaralda.partitureditor.jexmaraldaswing;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.exmaralda.partitureditor.jexmaralda.BasicTranscription;
import org.exmaralda.partitureditor.jexmaralda.JexmaraldaException;

/**
 *
 * @author Thomas_Schmidt
 */
public class EditTiersDialogNew extends javax.swing.JDialog implements ListSelectionListener {

    EditTiersTableModel editTiersTableModel;
    
    /**
     * Creates new form EditTiersDialogNew
     * @param parent
     * @param modal
     * @param transcription
     */
    public EditTiersDialogNew(java.awt.Frame parent, boolean modal, BasicTranscription transcription) {
        super(parent, modal);
        initComponents();
        editTiersTableModel = new EditTiersTableModel(transcription);
        tiersTable.setModel(editTiersTableModel);
        tiersTable.setDefaultRenderer(String.class, new EditTiersTableCellRenderer());
        tiersTable.setDefaultRenderer(Integer.class, new EditTiersTableCellRenderer());

        tiersTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        tiersTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        tiersTable.getColumnModel().getColumn(3).setPreferredWidth(250);
        tiersTable.getColumnModel().getColumn(4).setPreferredWidth(150);
        tiersTable.getColumnModel().getColumn(5).setPreferredWidth(200);
        tiersTable.getColumnModel().getColumn(6).setPreferredWidth(150);
        tiersTable.getColumnModel().getColumn(7).setPreferredWidth(120);
        tiersTable.getColumnModel().getColumn(8).setPreferredWidth(150);
        tiersTable.getColumnModel().getColumn(9).setPreferredWidth(120);
        
        
        tiersTable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new TierTypeComboBox()));
        tiersTable.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(new SpeakerComboBox(transcription)));
        
        tiersTable.getSelectionModel().addListSelectionListener(this);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent event){
        int[] rows = tiersTable.getSelectedRows();
        upButton.setEnabled(rows!=null && rows.length>0 && (!tiersTable.isRowSelected(0)));
        downButton.setEnabled(rows!=null && rows.length>0 && (!tiersTable.isRowSelected(editTiersTableModel.getRowCount()-1)));
    }
    
    public boolean isChanged(){
        return editTiersTableModel.changed;
    }
    
    public BasicTranscription getTranscription(){
        return editTiersTableModel.transcription;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tiersTableScrollPane = new javax.swing.JScrollPane();
        tiersTable = new javax.swing.JTable();
        rightSidePanel = new javax.swing.JPanel();
        upButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        okCancelPanel = new javax.swing.JPanel();
        okButon = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 800));

        tiersTable.setAutoCreateRowSorter(true);
        tiersTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tiersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tiersTable.setMaximumSize(new java.awt.Dimension(2147483647, 800000));
        tiersTable.setRowHeight(20);
        tiersTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tiersTableScrollPane.setViewportView(tiersTable);

        getContentPane().add(tiersTableScrollPane, java.awt.BorderLayout.CENTER);

        rightSidePanel.setLayout(new javax.swing.BoxLayout(rightSidePanel, javax.swing.BoxLayout.Y_AXIS));

        upButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/folker/tangoicons/tango-icon-theme-0.8.1/16x16/actions/go-up.png"))); // NOI18N
        upButton.setText("Up");
        upButton.setToolTipText("Move the selected tier(s) upwards");
        upButton.setEnabled(false);
        upButton.setMaximumSize(new java.awt.Dimension(79, 25));
        upButton.setMinimumSize(new java.awt.Dimension(79, 25));
        upButton.setPreferredSize(new java.awt.Dimension(79, 25));
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });
        rightSidePanel.add(upButton);

        downButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/exmaralda/folker/tangoicons/tango-icon-theme-0.8.1/16x16/actions/go-down.png"))); // NOI18N
        downButton.setText("Down");
        downButton.setToolTipText("Move the selected tier(s) downwards");
        downButton.setEnabled(false);
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });
        rightSidePanel.add(downButton);

        getContentPane().add(rightSidePanel, java.awt.BorderLayout.EAST);

        okButon.setText("OK");
        okButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButonActionPerformed(evt);
            }
        });
        okCancelPanel.add(okButon);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        okCancelPanel.add(cancelButton);

        getContentPane().add(okCancelPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        // an interval can be selected
        int[] rows = tiersTable.getSelectedRows();
        try {
            editTiersTableModel.moveDown(rows[0], rows[rows.length-1]);
            tiersTable.setRowSelectionInterval(rows[0]+1, rows[rows.length-1]+1);
        } catch (JexmaraldaException ex) {
            Logger.getLogger(EditTiersDialogNew.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_downButtonActionPerformed

    private void okButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButonActionPerformed
        dispose();
    }//GEN-LAST:event_okButonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        editTiersTableModel.changed = false;
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        int[] rows = tiersTable.getSelectedRows();
        try {
            editTiersTableModel.moveUp(rows[0], rows[rows.length-1]);
            tiersTable.setRowSelectionInterval(rows[0]-1, rows[rows.length-1]-1);
        } catch (JexmaraldaException ex) {
            Logger.getLogger(EditTiersDialogNew.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_upButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditTiersDialogNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditTiersDialogNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditTiersDialogNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditTiersDialogNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditTiersDialogNew dialog = new EditTiersDialogNew(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton downButton;
    private javax.swing.JButton okButon;
    private javax.swing.JPanel okCancelPanel;
    private javax.swing.JPanel rightSidePanel;
    private javax.swing.JTable tiersTable;
    private javax.swing.JScrollPane tiersTableScrollPane;
    private javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables

    private static class TierTypeComboBox extends JComboBox {

        public TierTypeComboBox() {
            addItem("t");
            addItem("a");
            addItem("d");
            setRenderer(new ListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    if ("t".equals(value)) {
                        return new JLabel("T(ranscription)");
                    } else if ("a".equals(value)) {
                        return new JLabel("A(nnotation)");
                    } else if ("d".equals(value)) {
                        return new JLabel("D(escription)");
                    }
                    return new JLabel((String)value);
                }
                
            });
        }
    }

    private static class SpeakerComboBox extends JComboBox {

        public SpeakerComboBox(final BasicTranscription transcription) {
            String[] speakerIDs = transcription.getHead().getSpeakertable().getAllSpeakerIDs();
            setModel(new DefaultComboBoxModel(speakerIDs));
            setRenderer(new ListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    try {
                        String abb = transcription.getHead().getSpeakertable().getSpeakerWithID((String)value).getAbbreviation();
                        return new JLabel(abb + " [" + (String)value + "]");
                    } catch (JexmaraldaException ex) {
                        Logger.getLogger(EditTiersDialogNew.class.getName()).log(Level.SEVERE, null, ex);
                        return new JLabel("");
                    }
                }
                
            });
        }
    }
}
