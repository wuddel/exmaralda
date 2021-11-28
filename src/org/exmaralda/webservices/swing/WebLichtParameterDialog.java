/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.exmaralda.webservices.swing;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.exmaralda.exakt.utilities.FileIO;
import org.exmaralda.partitureditor.jexmaraldaswing.fileFilters.ParameterFileFilter;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.xpath.XPath;

/**
 *
 * @author Schmidt
 */
public class WebLichtParameterDialog extends javax.swing.JDialog {

    public boolean approved = false;
    File defaultDirectory;
    WebLichtChainComboBoxModel webLichtChainComboBoxModel = new WebLichtChainComboBoxModel();
    
    /**
     * Creates new form WebLichtParameterDialog
     */
    public WebLichtParameterDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        predefinedChainsComboBox.setModel(webLichtChainComboBoxModel);
        predefinedChainsComboBox.setSelectedIndex(0);
        predefinedChainsComboBox.setRenderer(new WebLichtChainListCellRenderer());
        updateOK();
    }
    
    public HashMap<String, Object> getWebLichtParameters() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("CHAIN", chainTextField.getText());
        String path = ((ChainDefinition)predefinedChainsComboBox.getSelectedItem()).getPath();
        result.put("PREDEFINED-CHAIN", path);
        result.put("USE-PREDEFINED-CHAIN", (Boolean)predefinedChainRadioButton.isSelected());            
        result.put("API-KEY", apiKeyTextField.getText());
        result.put("TCF", tcfTextField.getText());
        result.put("TEI", teiTextField.getText());
        result.put("HTML", htmlTextField.getText());
        result.put("LANG", (String)languageComboBox.getSelectedItem());
        result.put("SEGMENTATION", (String)segmentationComboBox.getSelectedItem());
        result.put("IMPORT-TEI", (Boolean)importTEICheckBox.isSelected());
        
        return result;
    }
    
    public void setParameters(String chainFile, String apiKey, String outputDirectory){
        chainTextField.setText(chainFile);
        apiKeyTextField.setText(apiKey);
        defaultDirectory = new File(outputDirectory);
        updateOK();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chainButtonGroup = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        apikeyPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        apiKeyTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        getAPIKeyButton = new javax.swing.JButton();
        chainPanel = new javax.swing.JPanel();
        chainExplainLabel = new javax.swing.JLabel();
        chainMainPanel = new javax.swing.JPanel();
        predefinedPanel = new javax.swing.JPanel();
        predefinedChainRadioButton = new javax.swing.JRadioButton();
        predefinedChainsComboBox = new javax.swing.JComboBox<>();
        descriptionPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        customPanel = new javax.swing.JPanel();
        customChainRadioButton = new javax.swing.JRadioButton();
        chainTextField = new javax.swing.JTextField();
        chainBrowseButton = new javax.swing.JButton();
        languagePanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        languageComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        segmentationPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        segmentationComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        outputPanel = new javax.swing.JPanel();
        tcfPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tcfTextField = new javax.swing.JTextField();
        tcfBrowseButton = new javax.swing.JButton();
        teiPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        teiTextField = new javax.swing.JTextField();
        teiBrowseButton = new javax.swing.JButton();
        htmlPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        htmlTextField = new javax.swing.JTextField();
        htmlBrowseButton = new javax.swing.JButton();
        importTEIPanel = new javax.swing.JPanel();
        importTEICheckBox = new javax.swing.JCheckBox();
        okCancelPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("WebLicht Parameters");

        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.Y_AXIS));

        apikeyPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("API key"));
        apikeyPanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        apiKeyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apiKeyTextFieldActionPerformed(evt);
            }
        });
        jPanel2.add(apiKeyTextField);

        apikeyPanel.add(jPanel2, java.awt.BorderLayout.CENTER);

        jLabel2.setText("Please provide a valid API key for WebLicht as a Service");
        apikeyPanel.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        getAPIKeyButton.setBackground(java.awt.Color.blue);
        getAPIKeyButton.setText("Get an API key from the WaaS website...");
        getAPIKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAPIKeyButtonActionPerformed(evt);
            }
        });
        apikeyPanel.add(getAPIKeyButton, java.awt.BorderLayout.PAGE_END);

        mainPanel.add(apikeyPanel);

        chainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Chain definition"));
        chainPanel.setLayout(new java.awt.BorderLayout());

        chainExplainLabel.setText("Please choose the file which defines the WebLicht processing chain");
        chainPanel.add(chainExplainLabel, java.awt.BorderLayout.PAGE_START);

        chainMainPanel.setLayout(new javax.swing.BoxLayout(chainMainPanel, javax.swing.BoxLayout.Y_AXIS));

        predefinedPanel.setLayout(new javax.swing.BoxLayout(predefinedPanel, javax.swing.BoxLayout.LINE_AXIS));

        chainButtonGroup.add(predefinedChainRadioButton);
        predefinedChainRadioButton.setSelected(true);
        predefinedChainRadioButton.setText("Predefined: ");
        predefinedChainRadioButton.setMaximumSize(new java.awt.Dimension(85, 23));
        predefinedChainRadioButton.setMinimumSize(new java.awt.Dimension(85, 23));
        predefinedChainRadioButton.setPreferredSize(new java.awt.Dimension(85, 23));
        predefinedPanel.add(predefinedChainRadioButton);

        predefinedChainsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                predefinedChainsComboBoxActionPerformed(evt);
            }
        });
        predefinedPanel.add(predefinedChainsComboBox);

        chainMainPanel.add(predefinedPanel);

        descriptionPanel.setLayout(new javax.swing.BoxLayout(descriptionPanel, javax.swing.BoxLayout.LINE_AXIS));

        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        descriptionTextArea.setColumns(20);
        descriptionTextArea.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setRows(5);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 10));
        jScrollPane1.setViewportView(descriptionTextArea);

        descriptionPanel.add(jScrollPane1);

        chainMainPanel.add(descriptionPanel);

        customPanel.setLayout(new javax.swing.BoxLayout(customPanel, javax.swing.BoxLayout.LINE_AXIS));

        chainButtonGroup.add(customChainRadioButton);
        customChainRadioButton.setText("Custom: ");
        customChainRadioButton.setMaximumSize(new java.awt.Dimension(85, 23));
        customChainRadioButton.setMinimumSize(new java.awt.Dimension(85, 23));
        customChainRadioButton.setPreferredSize(new java.awt.Dimension(85, 23));
        customPanel.add(customChainRadioButton);

        chainTextField.setMaximumSize(new java.awt.Dimension(500, 20));
        chainTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chainTextFieldActionPerformed(evt);
            }
        });
        customPanel.add(chainTextField);

        chainBrowseButton.setText("Browse...");
        chainBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chainBrowseButtonActionPerformed(evt);
            }
        });
        customPanel.add(chainBrowseButton);

        chainMainPanel.add(customPanel);
        customPanel.getAccessibleContext().setAccessibleDescription("");

        chainPanel.add(chainMainPanel, java.awt.BorderLayout.CENTER);

        mainPanel.add(chainPanel);

        languagePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Language"));
        languagePanel.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        languageComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "de", "en", "cs", "es", "fr", "it", "nl", "ro" }));
        jPanel3.add(languageComboBox);

        languagePanel.add(jPanel3, java.awt.BorderLayout.CENTER);

        jLabel6.setText("Please specify the language of the input and the toolchain");
        languagePanel.add(jLabel6, java.awt.BorderLayout.NORTH);

        mainPanel.add(languagePanel);

        segmentationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Segmentation"));
        segmentationPanel.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        segmentationComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HIAT", "GENERIC", "cGAT Minimal" }));
        jPanel4.add(segmentationComboBox);

        segmentationPanel.add(jPanel4, java.awt.BorderLayout.CENTER);

        jLabel7.setText("Please specify which algorithm to use for segmenting (=tokenising) the input");
        segmentationPanel.add(jLabel7, java.awt.BorderLayout.NORTH);

        mainPanel.add(segmentationPanel);

        outputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Output"));
        outputPanel.setLayout(new javax.swing.BoxLayout(outputPanel, javax.swing.BoxLayout.Y_AXIS));

        tcfPanel.setLayout(new javax.swing.BoxLayout(tcfPanel, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setText("TCF Output: ");
        jLabel3.setMaximumSize(new java.awt.Dimension(70, 14));
        jLabel3.setPreferredSize(new java.awt.Dimension(70, 14));
        tcfPanel.add(jLabel3);

        tcfTextField.setMaximumSize(new java.awt.Dimension(500, 20));
        tcfTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcfTextFieldActionPerformed(evt);
            }
        });
        tcfPanel.add(tcfTextField);

        tcfBrowseButton.setText("Browse...");
        tcfBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcfBrowseButtonActionPerformed(evt);
            }
        });
        tcfPanel.add(tcfBrowseButton);

        outputPanel.add(tcfPanel);

        teiPanel.setLayout(new javax.swing.BoxLayout(teiPanel, javax.swing.BoxLayout.LINE_AXIS));

        jLabel4.setText("TEI Output: ");
        jLabel4.setMaximumSize(new java.awt.Dimension(70, 14));
        jLabel4.setPreferredSize(new java.awt.Dimension(70, 14));
        teiPanel.add(jLabel4);

        teiTextField.setMaximumSize(new java.awt.Dimension(500, 20));
        teiTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teiTextFieldActionPerformed(evt);
            }
        });
        teiPanel.add(teiTextField);

        teiBrowseButton.setText("Browse...");
        teiBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teiBrowseButtonActionPerformed(evt);
            }
        });
        teiPanel.add(teiBrowseButton);

        outputPanel.add(teiPanel);

        htmlPanel.setLayout(new javax.swing.BoxLayout(htmlPanel, javax.swing.BoxLayout.LINE_AXIS));

        jLabel5.setText("HTML Output: ");
        htmlPanel.add(jLabel5);

        htmlTextField.setMaximumSize(new java.awt.Dimension(500, 20));
        htmlTextField.setPreferredSize(new java.awt.Dimension(400, 20));
        htmlTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                htmlTextFieldActionPerformed(evt);
            }
        });
        htmlPanel.add(htmlTextField);

        htmlBrowseButton.setText("Browse...");
        htmlBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                htmlBrowseButtonActionPerformed(evt);
            }
        });
        htmlPanel.add(htmlBrowseButton);

        outputPanel.add(htmlPanel);

        importTEICheckBox.setSelected(true);
        importTEICheckBox.setText("Import TEI into Partitur Editor");
        importTEICheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importTEICheckBoxActionPerformed(evt);
            }
        });
        importTEIPanel.add(importTEICheckBox);

        outputPanel.add(importTEIPanel);

        mainPanel.add(outputPanel);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        okButton.setText("OK");
        okButton.setEnabled(false);
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
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void chainBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chainBrowseButtonActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(defaultDirectory);
        if (chainTextField.getText().length()>0){
            jfc.setCurrentDirectory(new File(chainTextField.getText()).getParentFile());
        }
        String[] tcf_suff = {"tcf", "xml"};
        jfc.setFileFilter(new ParameterFileFilter(tcf_suff, "WebLicht chain specification (*.xml)"));
        int result = jfc.showOpenDialog(getParent());
        if (result==JFileChooser.APPROVE_OPTION){
            chainTextField.setText(jfc.getSelectedFile().getAbsolutePath());
        }
        updateOK();
        updateChainLanguage();
        customChainRadioButton.setSelected(true);
        
    }//GEN-LAST:event_chainBrowseButtonActionPerformed

    private void tcfBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcfBrowseButtonActionPerformed
        JFileChooser jfc = new JFileChooser();
        String[] tcf_suff = {"tcf", "xml"};
        jfc.setCurrentDirectory(defaultDirectory);
        jfc.setFileFilter(new ParameterFileFilter(tcf_suff, "TCF file (*.tcf, *.xml)"));
        int result = jfc.showSaveDialog(getParent());
        if (result==JFileChooser.APPROVE_OPTION){
            String suffix = "";
            if (!(jfc.getSelectedFile().getName().contains("."))){
                suffix = ".tcf";
            }
            tcfTextField.setText(jfc.getSelectedFile().getAbsolutePath() + suffix);
        }
        updateOK();
        
    }//GEN-LAST:event_tcfBrowseButtonActionPerformed

    private void teiBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teiBrowseButtonActionPerformed
        JFileChooser jfc = new JFileChooser();
        String[] tcf_suff = {"tei", "xml"};
        jfc.setCurrentDirectory(defaultDirectory);
        jfc.setFileFilter(new ParameterFileFilter(tcf_suff, "TEI file (*.tei, *.xml)"));
        int result = jfc.showSaveDialog(getParent());
        if (result==JFileChooser.APPROVE_OPTION){
            String suffix = "";
            if (!(jfc.getSelectedFile().getName().contains("."))){
                suffix = ".tei";
            }
            teiTextField.setText(jfc.getSelectedFile().getAbsolutePath()+suffix);
        }
        updateOK();
        
    }//GEN-LAST:event_teiBrowseButtonActionPerformed

    private void htmlBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_htmlBrowseButtonActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new ParameterFileFilter("html", "HTML file (*.html)"));
        int result = jfc.showSaveDialog(getParent());
        if (result==JFileChooser.APPROVE_OPTION){
            String suffix = "";
            if (!(jfc.getSelectedFile().getName().contains("."))){
                suffix = ".html";
            }
            
            htmlTextField.setText(jfc.getSelectedFile().getAbsolutePath() + suffix);
        }
        updateOK();

    }//GEN-LAST:event_htmlBrowseButtonActionPerformed

    private void apiKeyTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apiKeyTextFieldActionPerformed
        updateOK();
        this.customChainRadioButton.setSelected(true);
    }//GEN-LAST:event_apiKeyTextFieldActionPerformed

    private void chainTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chainTextFieldActionPerformed
       updateOK();
       // 31-05-2017 - issue #88
       updateChainLanguage();
    }//GEN-LAST:event_chainTextFieldActionPerformed

    private void tcfTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcfTextFieldActionPerformed
       updateOK();
    }//GEN-LAST:event_tcfTextFieldActionPerformed

    private void teiTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teiTextFieldActionPerformed
       updateOK();
    }//GEN-LAST:event_teiTextFieldActionPerformed

    private void htmlTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_htmlTextFieldActionPerformed
       updateOK();
    }//GEN-LAST:event_htmlTextFieldActionPerformed

    private void getAPIKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAPIKeyButtonActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("https://weblicht.sfs.uni-tuebingen.de/WaaS/apikey"));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(WebLichtParameterDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_getAPIKeyButtonActionPerformed

    private void predefinedChainsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_predefinedChainsComboBoxActionPerformed
        predefinedChainRadioButton.setSelected(true);
        String language = ((ChainDefinition)predefinedChainsComboBox.getSelectedItem()).getLanguage();
        languageComboBox.setSelectedItem(language);
        String description = ((ChainDefinition)predefinedChainsComboBox.getSelectedItem()).getDescription();
        this.descriptionTextArea.setText(description);
        
    }//GEN-LAST:event_predefinedChainsComboBoxActionPerformed

    private void importTEICheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importTEICheckBoxActionPerformed
        updateOK();
    }//GEN-LAST:event_importTEICheckBoxActionPerformed

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
            java.util.logging.Logger.getLogger(WebLichtParameterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WebLichtParameterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WebLichtParameterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WebLichtParameterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WebLichtParameterDialog dialog = new WebLichtParameterDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField apiKeyTextField;
    private javax.swing.JPanel apikeyPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton chainBrowseButton;
    private javax.swing.ButtonGroup chainButtonGroup;
    private javax.swing.JLabel chainExplainLabel;
    private javax.swing.JPanel chainMainPanel;
    private javax.swing.JPanel chainPanel;
    private javax.swing.JTextField chainTextField;
    private javax.swing.JRadioButton customChainRadioButton;
    private javax.swing.JPanel customPanel;
    private javax.swing.JPanel descriptionPanel;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JButton getAPIKeyButton;
    private javax.swing.JButton htmlBrowseButton;
    private javax.swing.JPanel htmlPanel;
    private javax.swing.JTextField htmlTextField;
    private javax.swing.JCheckBox importTEICheckBox;
    private javax.swing.JPanel importTEIPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox languageComboBox;
    private javax.swing.JPanel languagePanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel okCancelPanel;
    private javax.swing.JPanel outputPanel;
    private javax.swing.JRadioButton predefinedChainRadioButton;
    private javax.swing.JComboBox<ChainDefinition> predefinedChainsComboBox;
    private javax.swing.JPanel predefinedPanel;
    private javax.swing.JComboBox segmentationComboBox;
    private javax.swing.JPanel segmentationPanel;
    private javax.swing.JButton tcfBrowseButton;
    private javax.swing.JPanel tcfPanel;
    private javax.swing.JTextField tcfTextField;
    private javax.swing.JButton teiBrowseButton;
    private javax.swing.JPanel teiPanel;
    private javax.swing.JTextField teiTextField;
    // End of variables declaration//GEN-END:variables

    private void updateOK() {
        boolean parametersSuffice = 
                (predefinedChainRadioButton.isSelected() || chainTextField.getText().length()>0)
                && apiKeyTextField.getText().length()>0
                && (tcfTextField.getText().length()>0 || teiTextField.getText().length()>0 || htmlTextField.getText().length()>0 || importTEICheckBox.isSelected());
        okButton.setEnabled(parametersSuffice);
    }

    // 31-05-2017 - issue #88
    private void updateChainLanguage() {
        String chainPath = chainTextField.getText();
        File chainFile = new File(chainPath);
        if ((!chainFile.exists()) || (!(chainFile.canRead()))){
            String message = "Chain file \n" + chainPath + "\n does not exist or cannot be read. ";
            JOptionPane.showMessageDialog(rootPane, message);
            return;
        }
        
        try {
            /* <cmd:Toolchain>
                <cmd:ToolInChain>
                    <cmd:PID>http://hdl.handle.net/11858/00-1778-0000-0004-BA56-7</cmd:PID>
                    <cmd:Parameter value="de" name="lang"/>
                    <cmd:Parameter value="text/plain" name="type"/>
                </cmd:ToolInChain>
                <cmd:ToolInChain>
                    <cmd:PID>http://hdl.handle.net/11858/00-1778-0000-0004-BA63-7</cmd:PID>
                    <cmd:Parameter value="de" name="lang"/>
                    <cmd:Parameter value="0.4" name="version"/>
                </cmd:ToolInChain>
                <cmd:ToolInChain>
                    <cmd:PID>http://hdl.handle.net/11858/00-203C-0000-002B-B8EE-C</cmd:PID>
                </cmd:ToolInChain> */

            Document chainDoc = FileIO.readDocumentFromLocalFile(chainFile);
            XPath xp = XPath.newInstance("//cmd:ToolInChain/cmd:Parameter[@name='lang']");
            Namespace CMD_NAMESPACE = Namespace.getNamespace("cmd", "http://www.clarin.eu/cmd/1");
            xp.addNamespace(CMD_NAMESPACE);
            
            List l = xp.selectNodes(chainDoc);
            if (l==null || l.isEmpty()){
                System.out.println("No language defined in chain");
            } else {
                Element paramElement = (Element)(l.get(0));
                String language = paramElement.getAttributeValue("value");
                System.out.println("First language defined in chain is " + language);
                languageComboBox.setSelectedItem(language);
            }            
        } catch (JDOMException ex) {
            String message = "Problem reading chain file \n" + chainPath + ": \n" + ex.getLocalizedMessage();
            JOptionPane.showMessageDialog(rootPane, message);
        } catch (IOException ex) {
            String message = "Problem reading chain file \n" + chainPath + ": \n" + ex.getLocalizedMessage();
            JOptionPane.showMessageDialog(rootPane, message);
        }
        
    }
}
