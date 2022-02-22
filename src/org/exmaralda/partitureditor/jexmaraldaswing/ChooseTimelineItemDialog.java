/*
 * ChooseTimelineItemDialog.java
 *
 * Created on 21. August 2001, 09:51
 */

package org.exmaralda.partitureditor.jexmaraldaswing;

import org.exmaralda.common.helpers.Internationalizer;
import org.exmaralda.partitureditor.jexmaralda.*;

/**
 *
 * @author  Thomas
 * @version 
 */
public class ChooseTimelineItemDialog extends JEscapeDialog {

    private TimelineItem timelineItem;
    private Timeline timeline;
    private javax.swing.DefaultListModel timelineItemsListModel;
    
    /** Creates new form ChooseTimelineItemDialog */
    public ChooseTimelineItemDialog(java.awt.Frame parent,boolean modal, Timeline t, int beginIndex) {
        super (parent, modal);
        timeline = t;
        timelineItemsListModel = new javax.swing.DefaultListModel();        
        for (int pos=1; pos<timeline.getNumberOfTimelineItems()-1; pos++){
            String index = Integer.toString(beginIndex+pos-1);
            TimelineItem tli = timeline.getTimelineItemAt(pos);
            String listEntry = new String(index + ":");
            if (tli.getTime()>=0){
                //listEntry+=new String(" [" + tli.getTimeAsString() + "]");
                listEntry+=" [" + org.exmaralda.folker.utilities.TimeStringFormatter.formatMiliseconds(tli.getTime()*1000.0, 2) + "]";
            }
            listEntry += " " + tli.getID();
            timelineItemsListModel.addElement(listEntry);
        }
        initComponents ();        
        this.getRootPane().setDefaultButton(okButton);
        pack ();
        Internationalizer.internationalizeDialogToolTips(this);        
    }

    public TimelineItem getTimelineItem(){
        return timelineItem;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        okButton.setMnemonic('O');
        cancelButton = new javax.swing.JButton();
        cancelButton.setMnemonic('C');
        timelineItemsScrollPane = new javax.swing.JScrollPane();
        timelineItemsList = new javax.swing.JList(timelineItemsListModel);
        timelineItemsList.setSelectedIndex(0);

        setTitle("Choose a timeline item");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setText("OK");
        okButton.setMaximumSize(new java.awt.Dimension(80, 27));
        okButton.setMinimumSize(new java.awt.Dimension(80, 27));
        okButton.setPreferredSize(new java.awt.Dimension(80, 27));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(okButton);

        cancelButton.setText("Cancel");
        cancelButton.setMaximumSize(new java.awt.Dimension(80, 27));
        cancelButton.setMinimumSize(new java.awt.Dimension(80, 27));
        cancelButton.setPreferredSize(new java.awt.Dimension(80, 27));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(cancelButton);

        getContentPane().add(buttonPanel, java.awt.BorderLayout.SOUTH);

        timelineItemsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        timelineItemsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timelineItemsListMouseClicked(evt);
            }
        });
        timelineItemsScrollPane.setViewportView(timelineItemsList);

        getContentPane().add(timelineItemsScrollPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

  private void cancelButtonActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
// Add your handling code here:
    change = false;
    setVisible (false);
    dispose ();        
  }//GEN-LAST:event_cancelButtonActionPerformed

  private void okButtonActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
// Add your handling code here:
    change = true;
    timelineItem = timeline.getTimelineItemAt(timelineItemsList.getSelectedIndex()+1);
    setVisible (false);
    dispose ();    
  }//GEN-LAST:event_okButtonActionPerformed

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        change = false;
        setVisible (false);
        dispose ();
    }//GEN-LAST:event_closeDialog

    private void timelineItemsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timelineItemsListMouseClicked
        if (evt.getClickCount()==2){
            okButtonActionPerformed(null);
        }
    }//GEN-LAST:event_timelineItemsListMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main (String args[]) {
        //new ChooseTimelineItemDialog (new javax.swing.JFrame (), true).show ();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton okButton;
    private javax.swing.JList timelineItemsList;
    private javax.swing.JScrollPane timelineItemsScrollPane;
    // End of variables declaration//GEN-END:variables

    public boolean chooseTimelineItem(){
        show();
        return change;
    }
}