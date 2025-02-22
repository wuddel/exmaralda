/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.exmaralda.webservices.swing;

import java.util.HashMap;

/**
 *
 * @author Schmidt
 */
public class MAUSParameterDialog extends javax.swing.JDialog {

    // Language of the speech to be processed; we use the RFC5646 sub-structure 'iso639-3 - iso3166-1 [ - iso3166-2], 
    // e.g. 'eng-US' for American English, 'deu-AT-1' for Austrian German spoken in 'Oberoesterreich'; 
    // defines the possible orthographic text language in the input, the text-to-phoneme tranformation and some language specific transformations 
    //within the MAUS process. The code 'gsw-CH' (= Swiss German) denotes orthographic text input in Swiss German 'Dieth' encoding. 
    
     
    // [aus-AU, eus-ES, eus-FR, cat-ES, nld-BE, nld-NL, eng-AU, eng-US, eng-GB, eng-SC, eng-NZ, 
    // ekk-EE, fin-FI, fra-FR, kat-GE, deu-DE, gsw-CH, gsw-CH-BE, gsw-CH-BS, gsw-CH-GR, gsw-CH-SG, 
    // gsw-CH-ZH, hun-HU, ita-IT, jpn-JP, gup-AU, mlt-MT, nor-NO, pol-PL, ron-RO, rus-RU, spa-ES, 
    // guf-AU, cat, deu, eng, fra, hun, ita, mlt, nld, pol, nze, fin, ron, spa] 
    
    public static String[][] LANGUAGES = {
        {"deu", "German"},
        {"eng", "English"},
        {"nld", "Dutch ; Flemish"},
        {"fra", "French"},
        {"spa", "Spanish"},
        {"ita", "Italian"},
        {"cat", "Catalan"}, 	
        {"ron", "Romanian; Moldavian; Moldovan"},
        {"hun", "Hungarian"},
        {"pol", "Polish"},
        {"fin", "Finnish"},
        {"cat-ES", "Catalan (Spain)"},
        {"ekk-EE", "Estonian (Estonia)"},        
        {"eng-AU", "English (Australia)"},
        {"eng-US", "English (USA)"},
        {"eng-GB", "English (Great Britain)"},
        {"eng-NZ", "English (New Zealand)"},
        {"eng-SC", "English (Seychelles)"},
        {"fra-FR", "French (France)"},
        {"eus-ES", "Basque (Spain)"},
        {"eus-FR", "Basque (France)"}, 
        {"guf-AU", "Gupapuyngu (Australia)"},
        {"gup-AU", "Gunwinggu (Australia)"},
        {"ita-IT", "Italian (Italy)"},
        {"jpn-JP", "Japanese (Japan)"},
        {"nld-BE", "Flemish (Belgium)"},
        {"kat-GE", "Georgian (Georgia)"},
        {"nld-NL", "Dutch (Netherlands)"},
        {"nor-NO", "Norwegian (Norway)"},
        {"pol-PL", "Polish (Poland)"},
        {"rus-RU", "Russian (Russia)"},
        {"gsw-CH", "Swiss German, Dieth encoding"},
        {"gsw-CH-BE", "Swiss German, Dieth encoding (Bern)"},
        {"gsw-CH-BS", "Swiss German, Dieth encoding (Basel)"},
        {"gsw-CH-GR", "Swiss German, Dieth encoding (Graubünden)"},
        {"gsw-CH-SG", "Swiss German, Dieth encoding (St. Gallen)"},
        {"gsw-CH-ZH", "Swiss German, Dieth encoding (Zürich)"},
        
        
        // gsw-CH, gsw-CH-BE, gsw-CH-BS, gsw-CH-GR, gsw-CH-SG, gsw-CH-ZH,

        {"aus-AU", "???"}

    };   

    public boolean approved = false;
    
    /**
     * Creates new form MAUSParameterDialog
     * @param parent
     * @param modal
     */
    public MAUSParameterDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.languageComboBox.setRenderer(new MAUSLanguagesComboBoxRenderer());
    }
    
    public HashMap<String, Object> getMAUSParameters() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("LANGUAGE", ((String[])languageComboBox.getSelectedItem())[0]);
        result.put("SEGMENT-CHAIN-SELECTION", segmentChainSelectionRadioButton.isSelected());
        result.put("USE-SEGMENTATION", segmentRadioButton.isSelected());
        result.put("SEGMENTATION-ALGORITHM", segmentationComboBox.getSelectedItem());
        result.put("WORDS-ORTHOGRAPHIC", wordsOrthoCheckBox.isSelected());
        result.put("WORDS-SAMPA", wordsSAMPACheckBox.isSelected());
        result.put("PHONEMES", phonemesCheckBox.isSelected());
        result.put("MERGE", mergeWithExistingRadioButton.isSelected());
        
        return result;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        segmentationButtonGroup = new javax.swing.ButtonGroup();
        outputButtonGroup = new javax.swing.ButtonGroup();
        selectionButtonGroup = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        languagePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        languageComboBox = new javax.swing.JComboBox();
        selectionPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        eventsSelectionRadioButton = new javax.swing.JRadioButton();
        segmentChainSelectionRadioButton = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        segmentationPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        textAsIsRadioButton = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        segmentRadioButton = new javax.swing.JRadioButton();
        segmentationComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        annotationLevelsPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        wordsOrthoCheckBox = new javax.swing.JCheckBox();
        wordsSAMPACheckBox = new javax.swing.JCheckBox();
        phonemesCheckBox = new javax.swing.JCheckBox();
        outputPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        openAsNewRadioButton = new javax.swing.JRadioButton();
        mergeWithExistingRadioButton = new javax.swing.JRadioButton();
        okCancelPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MAUS Parameters");

        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.Y_AXIS));

        languagePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Language"));
        languagePanel.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("What language is spoken in the excerpt?");
        languagePanel.add(jLabel1, java.awt.BorderLayout.NORTH);

        languageComboBox.setModel(new javax.swing.DefaultComboBoxModel(LANGUAGES));
        languagePanel.add(languageComboBox, java.awt.BorderLayout.SOUTH);

        mainPanel.add(languagePanel);

        selectionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Selection"));
        selectionPanel.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.GridLayout(2, 1));

        selectionButtonGroup.add(eventsSelectionRadioButton);
        eventsSelectionRadioButton.setSelected(true);
        eventsSelectionRadioButton.setText("Events of the current selection");
        jPanel5.add(eventsSelectionRadioButton);

        selectionButtonGroup.add(segmentChainSelectionRadioButton);
        segmentChainSelectionRadioButton.setText("Segment chain around the current selection");
        jPanel5.add(segmentChainSelectionRadioButton);

        selectionPanel.add(jPanel5, java.awt.BorderLayout.CENTER);

        jLabel5.setText("Which transcription text do you want to pass to MAUS?");
        selectionPanel.add(jLabel5, java.awt.BorderLayout.NORTH);

        mainPanel.add(selectionPanel);

        segmentationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Segmentation"));
        segmentationPanel.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        segmentationButtonGroup.add(textAsIsRadioButton);
        textAsIsRadioButton.setSelected(true);
        textAsIsRadioButton.setText("Use the transcription text as is");
        jPanel1.add(textAsIsRadioButton);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        segmentationButtonGroup.add(segmentRadioButton);
        segmentRadioButton.setText("Use a segmentation algorithm: ");
        jPanel2.add(segmentRadioButton);

        segmentationComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HIAT", "GENERIC", "cGAT Minimal" }));
        jPanel2.add(segmentationComboBox);

        jPanel1.add(jPanel2);

        segmentationPanel.add(jPanel1, java.awt.BorderLayout.CENTER);

        jLabel2.setText("How do you want to pass transcription text to MAUS?");
        segmentationPanel.add(jLabel2, java.awt.BorderLayout.NORTH);

        mainPanel.add(segmentationPanel);

        annotationLevelsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Annotation Levels"));
        annotationLevelsPanel.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Which annotation levels of the MAUS output do you want to use?");
        annotationLevelsPanel.add(jLabel4, java.awt.BorderLayout.NORTH);

        wordsOrthoCheckBox.setSelected(true);
        wordsOrthoCheckBox.setText("Words (orthographic)");
        jPanel4.add(wordsOrthoCheckBox);

        wordsSAMPACheckBox.setSelected(true);
        wordsSAMPACheckBox.setText("Words (SAMPA)");
        jPanel4.add(wordsSAMPACheckBox);

        phonemesCheckBox.setText("Phonemes");
        jPanel4.add(phonemesCheckBox);

        annotationLevelsPanel.add(jPanel4, java.awt.BorderLayout.CENTER);

        mainPanel.add(annotationLevelsPanel);

        outputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Output"));
        outputPanel.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("What do you want to do with the MAUS output?");
        outputPanel.add(jLabel3, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new java.awt.GridLayout(2, 1));

        outputButtonGroup.add(openAsNewRadioButton);
        openAsNewRadioButton.setSelected(true);
        openAsNewRadioButton.setText("Open it as a new file");
        jPanel3.add(openAsNewRadioButton);

        outputButtonGroup.add(mergeWithExistingRadioButton);
        mergeWithExistingRadioButton.setText("Merge it with the existing transcription");
        jPanel3.add(mergeWithExistingRadioButton);

        outputPanel.add(jPanel3, java.awt.BorderLayout.CENTER);

        mainPanel.add(outputPanel);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        okCancelPanel.add(okButton);

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

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        approved = true;
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        approved = false;
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MAUSParameterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MAUSParameterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MAUSParameterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MAUSParameterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MAUSParameterDialog dialog = new MAUSParameterDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel annotationLevelsPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JRadioButton eventsSelectionRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JComboBox languageComboBox;
    private javax.swing.JPanel languagePanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton mergeWithExistingRadioButton;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel okCancelPanel;
    private javax.swing.JRadioButton openAsNewRadioButton;
    private javax.swing.ButtonGroup outputButtonGroup;
    private javax.swing.JPanel outputPanel;
    private javax.swing.JCheckBox phonemesCheckBox;
    private javax.swing.JRadioButton segmentChainSelectionRadioButton;
    private javax.swing.JRadioButton segmentRadioButton;
    private javax.swing.ButtonGroup segmentationButtonGroup;
    private javax.swing.JComboBox segmentationComboBox;
    private javax.swing.JPanel segmentationPanel;
    private javax.swing.ButtonGroup selectionButtonGroup;
    private javax.swing.JPanel selectionPanel;
    private javax.swing.JRadioButton textAsIsRadioButton;
    private javax.swing.JCheckBox wordsOrthoCheckBox;
    private javax.swing.JCheckBox wordsSAMPACheckBox;
    // End of variables declaration//GEN-END:variables

}
