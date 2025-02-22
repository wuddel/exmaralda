/*
 * ImportHIATDOSDialog.java
 *
 * Created on 29. Oktober 2002, 11:26
 */

package org.exmaralda.partitureditor.exHIATDOS.swing;


import org.exmaralda.partitureditor.jexmaraldaswing.fileDialogs.AbstractXMLOpenDialog;
import org.exmaralda.partitureditor.jexmaraldaswing.fileFilters.ParameterFileFilter;
import org.exmaralda.partitureditor.jexmaralda.*;
import org.exmaralda.partitureditor.exHIATDOS.*;
import java.io.*;

/**
 *
 * @author  Thomas
 */
public class ImportHIATDOSDialog extends org.exmaralda.partitureditor.jexmaraldaswing.JEscapeDialog {
    
    private BasicTranscription transcription;
    String startDirectory = "";
    char[][] CHAR_REPLACE = {
                              {'\u017D', '\u00C4'},     // großes Ä
                              {'\u201E', '\u00E4'},     // kleines ä
                              {'\u2122', '\u00D6'},     // großes Ö
                              {'\u201D', '\u00F6'},     // kleines ö
                              {'\u0161', '\u00DC'},     // großes Ü
                              {'\u0081', '\u00FC'},     // kleines ü
                              {'\u00E1', '\u00DF'},     // sz (ß)   
                              {'&', '\u00C5'},     // großes A mit Kringel                                    
                              {'*', '\u00E5'},     // kleines a mit Kringel
                              {'$', '\u00D8'},    // großes O mit Strich durch
                              {'#', '\u00F8'},          // kleines o mit Strich durch
                              {'+', '\u00C6'},         // großes AE Ligatur
                              {'%', '\u00E6'},         // kleines ae Ligatur
                              {'\uFFFD', '\u00FC'},     // auch kleines ü
                              {'\u201A', '\u00E9'}      // kleines e mit accent aigue
                             };

    
    /** Creates new form ImportHIATDOSDialog */
    public ImportHIATDOSDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getRootPane().setDefaultButton(okButton);
        setCharReplaceLabel();
        org.exmaralda.common.helpers.Internationalizer.internationalizeDialogToolTips(this);
    }
    
    public void setDatFile(String df){
        jTextField1.setText(df);
        startDirectory = df;
    }
    
    public BasicTranscription getTranscription(){
        return transcription;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        filePanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        browseDatButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        browseInfButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        browseSigButton = new javax.swing.JButton();
        methodPanel = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        miscPanel = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        charReplaceLabel = new javax.swing.JLabel();
        changeCharReplaceButton = new javax.swing.JButton();
        buttonPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        setTitle("\"Import\" a HIAT-DOS file");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        filePanel.setLayout(new java.awt.GridLayout(3, 1));

        filePanel.setBorder(new javax.swing.border.TitledBorder("Files"));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.X_AXIS));

        jLabel1.setText("Transcript file: ");
        jLabel1.setToolTipText("Datei mit Suffix *.dat");
        jPanel3.add(jLabel1);

        jPanel3.add(jTextField1);

        browseDatButton.setText("Browse...");
        browseDatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseDatButtonActionPerformed(evt);
            }
        });

        jPanel3.add(browseDatButton);

        filePanel.add(jPanel3);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.X_AXIS));

        jLabel2.setText("Info file: ");
        jLabel2.setToolTipText("Datei mit Suffix *.inf");
        jLabel2.setPreferredSize(new java.awt.Dimension(93, 16));
        jLabel2.setMaximumSize(new java.awt.Dimension(93, 16));
        jLabel2.setMinimumSize(new java.awt.Dimension(93, 16));
        jPanel4.add(jLabel2);

        jPanel4.add(jTextField2);

        browseInfButton.setText("Browse...");
        browseInfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseInfButtonActionPerformed(evt);
            }
        });

        jPanel4.add(browseInfButton);

        filePanel.add(jPanel4);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.X_AXIS));

        jLabel3.setText("Speakers file: ");
        jLabel3.setToolTipText("Datei mit Suffix *.sig");
        jLabel3.setPreferredSize(new java.awt.Dimension(93, 16));
        jLabel3.setMaximumSize(new java.awt.Dimension(93, 16));
        jLabel3.setMinimumSize(new java.awt.Dimension(93, 16));
        jPanel5.add(jLabel3);

        jPanel5.add(jTextField3);

        browseSigButton.setText("Browse...");
        browseSigButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseSigButtonActionPerformed(evt);
            }
        });

        jPanel5.add(browseSigButton);

        filePanel.add(jPanel5);

        getContentPane().add(filePanel);

        methodPanel.setLayout(new java.awt.GridLayout(2, 1));

        methodPanel.setBorder(new javax.swing.border.TitledBorder("Method for calculating synchronisation points"));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setLabel("Use left and right boundaries");
        methodPanel.add(jRadioButton1);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setSelected(true);
        jRadioButton2.setText("Use left boundaries only");
        methodPanel.add(jRadioButton2);

        getContentPane().add(methodPanel);

        miscPanel.setLayout(new java.awt.GridLayout(2, 1));

        miscPanel.setBorder(new javax.swing.border.TitledBorder("Miscellaneous"));
        jCheckBox1.setText("Remove holes (after manual wrap)");
        miscPanel.add(jCheckBox1);

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.X_AXIS));

        jLabel4.setText("Replace symbols: ");
        jLabel4.setPreferredSize(new java.awt.Dimension(120, 16));
        jLabel4.setMaximumSize(new java.awt.Dimension(120, 16));
        jLabel4.setMinimumSize(new java.awt.Dimension(120, 16));
        jPanel6.add(jLabel4);

        charReplaceLabel.setFont(new java.awt.Font("Arial Unicode MS", 0, 12));
        charReplaceLabel.setForeground(java.awt.Color.blue);
        charReplaceLabel.setMaximumSize(new java.awt.Dimension(300, 16));
        charReplaceLabel.setMinimumSize(new java.awt.Dimension(100, 16));
        charReplaceLabel.setPreferredSize(new java.awt.Dimension(150, 16));
        jPanel6.add(charReplaceLabel);

        changeCharReplaceButton.setText("Change...");
        changeCharReplaceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeCharReplaceButtonActionPerformed(evt);
            }
        });

        jPanel6.add(changeCharReplaceButton);

        miscPanel.add(jPanel6);

        getContentPane().add(miscPanel);

        okButton.setText("OK");
        okButton.setMaximumSize(new java.awt.Dimension(73, 26));
        okButton.setMinimumSize(new java.awt.Dimension(73, 26));
        okButton.setPreferredSize(new java.awt.Dimension(73, 26));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        buttonPanel.add(okButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        buttonPanel.add(cancelButton);

        getContentPane().add(buttonPanel);

        pack();
    }
    // </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // Add your handling code here:
        change = false;
        setVisible(false);
        dispose();        
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // Add your handling code here:
        change = true;
        setVisible(false);
        dispose();        
    }//GEN-LAST:event_okButtonActionPerformed

    private void changeCharReplaceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeCharReplaceButtonActionPerformed
        // Add your handling code here:
        CharReplaceDialog dialog = new CharReplaceDialog((javax.swing.JFrame)getParent(), true, this.CHAR_REPLACE);
        dialog.show();
        if (dialog.change){
            this.CHAR_REPLACE = dialog.getCharReplace();
            this.setCharReplaceLabel();
        }
    }//GEN-LAST:event_changeCharReplaceButtonActionPerformed

    private void browseSigButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseSigButtonActionPerformed
        // Add your handling code here:
        AbstractXMLOpenDialog dialog = new AbstractXMLOpenDialog(startDirectory);
        dialog.setFileFilter(new ParameterFileFilter("sig", "HIAT-DOS Siglendateien (*.sig)"));
        dialog.setDialogTitle("HIAT-DOS Siglendatei auswählen");
        int returnVal = dialog.showOpenDialog(this);
        if(returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            String fn = new String(dialog.getSelectedFile().toString());
            jTextField3.setText(fn);
        }                       
    }//GEN-LAST:event_browseSigButtonActionPerformed

    private void browseInfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseInfButtonActionPerformed
        // Add your handling code here:
        AbstractXMLOpenDialog dialog = new AbstractXMLOpenDialog(startDirectory);
        dialog.setFileFilter(new ParameterFileFilter("inf", "HIAT-DOS Infodateien (*.inf)"));
        dialog.setDialogTitle("HIAT-DOS Infodatei auswählen");
        int returnVal = dialog.showOpenDialog(this);
        if(returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            String fn = new String(dialog.getSelectedFile().toString());
            jTextField2.setText(fn);
        }               
    }//GEN-LAST:event_browseInfButtonActionPerformed

    private void browseDatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseDatButtonActionPerformed
        // Add your handling code here:
        AbstractXMLOpenDialog dialog = new AbstractXMLOpenDialog(startDirectory);
        dialog.setFileFilter(new ParameterFileFilter("dat", "HIAT-DOS Transkriptdateien (*.dat)"));
        dialog.setDialogTitle("HIAT-DOS Transkriptdatei auswählen");
        int returnVal = dialog.showOpenDialog(this);
        if(returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            String fn = new String(dialog.getSelectedFile().toString());
            startDirectory = fn;
            jTextField1.setText(fn);
        }       
    }//GEN-LAST:event_browseDatButtonActionPerformed
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        change = false;
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new ImportHIATDOSDialog(new javax.swing.JFrame(), true).show();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseDatButton;
    private javax.swing.JButton browseInfButton;
    private javax.swing.JButton browseSigButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton changeCharReplaceButton;
    private javax.swing.JLabel charReplaceLabel;
    private javax.swing.JPanel filePanel;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel methodPanel;
    private javax.swing.JPanel miscPanel;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

    private void setCharReplaceLabel(){
        String text = new String();
        text+="[ ";
        for (int pos=0; pos<CHAR_REPLACE.length; pos++){
            text+=CHAR_REPLACE[pos][1];
            text+=" ";
        }
        text+="]";
        charReplaceLabel.setText(text);
    }
    
    public boolean importHIATDOS(){
        java.awt.Dimension dialogSize = this.getPreferredSize();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width/2 - dialogSize.width/2, screenSize.height/2 - dialogSize.height/2);
        this.show();
        if (!change) return false;
        try{
            HIATDOSReader hdr = new HIATDOSReader(jTextField1.getText());
            if (jTextField2.getText().length()>0){
                hdr.readHead(jTextField2.getText());
            }
            if (jTextField3.getText().length()>0){
                hdr.readSpeakers(jTextField3.getText());
            }
            hdr.parse();
            hdr.replaceChars();   
            if (jCheckBox1.isSelected()) {
                hdr.removeHoles();
            }
            hdr.calculateSyncPoints(jRadioButton1.isSelected());
            transcription = hdr.toBasicTranscription();
            return true;
        } catch (IOException ioe){
            javax.swing.JOptionPane errorDialog = new javax.swing.JOptionPane();
            errorDialog.showMessageDialog(  this.getParent(),
                                    ioe.getMessage(),
                                    "I/O-Error",
                                    javax.swing.JOptionPane.ERROR_MESSAGE);              

            return false;
        }
    }
}
