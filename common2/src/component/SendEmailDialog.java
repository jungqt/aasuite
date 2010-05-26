/*
 * SendEmailDialog.java
 *
 * Created on May 22, 2008, 9:01 PM
 */

package component;

import bean.admin.EmailTemplate;
import bean.admin.SentEmail;
import common2.Common2View;
import java.io.File;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import org.jdesktop.beansbinding.ELProperty;
import service.util.WSPersistenceEntityManager;
import template.screen.TransactionPanel;
import util.BeanUtil;

/**
 *
 * @author  Entokwaa
 */
public class SendEmailDialog extends javax.swing.JPanel {
    static SendEmailDialog dialog;
    
    public static void showDialog(boolean empty) {
        if (dialog==null) dialog = new SendEmailDialog();
        if (empty) {
            dialog.cboTemplate.refresh();
            dialog.datSentEmail.setAttachment("");
            dialog.datSentEmail.setContent("");
            dialog.datSentEmail.setCustomerId(0);
            dialog.datSentEmail.setRecipient("");
            dialog.datSentEmail.setSentDate(constants.Constants.useDate);
            dialog.datSentEmail.setSeq(0);
            dialog.datSentEmail.setSubject("");
        }
        dialog.dlgNewEmail.pack();
        dialog.dlgNewEmail.setVisible(true);
    }
    
    public static void showDialog(String subject, String content, int customerId, String recipient, String attachment) {
        if (dialog==null) {
            dialog = new SendEmailDialog();
        }
        dialog.cboTemplate.refresh();
        dialog.datSentEmail.setAttachment(attachment);
        dialog.txtContent.setText(content);
        dialog.datSentEmail.setContent(content);
        dialog.datSentEmail.setCustomerId(customerId);
        dialog.datSentEmail.setRecipient(recipient);
        dialog.datSentEmail.setSentDate(constants.Constants.useDate);
        dialog.datSentEmail.setSeq(0);
        dialog.datSentEmail.setSubject(subject);
        
        dialog.cboCustomer.setText(BeanUtil.concat(customerId,""));
        dialog.txtSentTo.setText(recipient);
        dialog.txtSubject.setText(subject);
        dialog.dlgNewEmail.pack();
        dialog.dlgNewEmail.setVisible(true);
    }

    /** Creates new form SendEmailDialog */
    public SendEmailDialog() {
        datSentEmail = new SentEmail();
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        fileChooser = new javax.swing.JFileChooser();
        dlgNewEmail = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSentTo = new component.JTextFieldPallete();
        jLabel4 = new javax.swing.JLabel();
        btnChooseFile = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtSubject = new component.JTextFieldPallete();
        cboCustomer = new component.LookupTableFieldPallete();
        jPanel1 = new javax.swing.JPanel();
        btnSendEmail = new javax.swing.JButton();
        cboTemplate = new component.JComboBoxPallete();
        jLabel1 = new javax.swing.JLabel();
        btnLoadTemplate = new javax.swing.JButton();
        txtAttachment = new component.JTextFieldPallete();
        toolPUEntityManager = WSPersistenceEntityManager.getInstance();
        customerQuery = java.beans.Beans.isDesignTime() ? null : toolPUEntityManager.createQuery("SELECT c FROM Customer c");
        customerList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : customerQuery.getResultList();
        datSentEmail = new bean.admin.SentEmail();
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(common2.Common2App.class).getContext().getResourceMap(SendEmailDialog.class);
        emailtemplateQuery = java.beans.Beans.isDesignTime() ? null : toolPUEntityManager.createQuery(resourceMap.getString("emailtemplateQuery.query")); // NOI18N
        emailtemplateList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : emailtemplateQuery.getResultList();

        fileChooser.setDialogTitle("Attachment"); // NOI18N

        dlgNewEmail.setTitle("Compose Email"); // NOI18N
        dlgNewEmail.setModal(true);
        dlgNewEmail.getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Select Customer:"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        dlgNewEmail.getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setText("Send to:"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        dlgNewEmail.getContentPane().add(jLabel3, gridBagConstraints);

        txtSentTo.setUpCase(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, datSentEmail, org.jdesktop.beansbinding.ELProperty.create("${recipient}"), txtSentTo, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        dlgNewEmail.getContentPane().add(txtSentTo, gridBagConstraints);

        jLabel4.setText("Attachment:"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        dlgNewEmail.getContentPane().add(jLabel4, gridBagConstraints);

        btnChooseFile.setText("Choose File"); // NOI18N
        btnChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseFileActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        dlgNewEmail.getContentPane().add(btnChooseFile, gridBagConstraints);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Content:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(150, 200));

        txtContent.setColumns(20);
        txtContent.setRows(5);
        txtContent.setMinimumSize(new java.awt.Dimension(250, 250));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, datSentEmail, org.jdesktop.beansbinding.ELProperty.create("${content}"), txtContent, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(txtContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 400;
        gridBagConstraints.ipady = 350;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        dlgNewEmail.getContentPane().add(jScrollPane2, gridBagConstraints);

        jLabel5.setText("Subject:"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        dlgNewEmail.getContentPane().add(jLabel5, gridBagConstraints);

        txtSubject.setUpCase(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, datSentEmail, org.jdesktop.beansbinding.ELProperty.create("${subject}"), txtSubject, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        dlgNewEmail.getContentPane().add(txtSubject, gridBagConstraints);

        cboCustomer.setBean(resourceMap.getString("cboCustomer.bean")); // NOI18N
        cboCustomer.setColumns(new String[] {"companyName", "lastName", "firstName"});

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, datSentEmail, org.jdesktop.beansbinding.ELProperty.create("${customer}"), cboCustomer, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        dlgNewEmail.getContentPane().add(cboCustomer, gridBagConstraints);

        btnSendEmail.setText("Send Email"); // NOI18N
        btnSendEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendEmailActionPerformed(evt);
            }
        });
        jPanel1.add(btnSendEmail);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        dlgNewEmail.getContentPane().add(jPanel1, gridBagConstraints);

        cboTemplate.setList(emailtemplateList);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, emailtemplateList, cboTemplate);
        bindingGroup.addBinding(jComboBoxBinding);

        cboTemplate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTemplateItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        dlgNewEmail.getContentPane().add(cboTemplate, gridBagConstraints);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        dlgNewEmail.getContentPane().add(jLabel1, gridBagConstraints);

        btnLoadTemplate.setText(resourceMap.getString("btnLoadTemplate.text")); // NOI18N
        btnLoadTemplate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadTemplateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        dlgNewEmail.getContentPane().add(btnLoadTemplate, gridBagConstraints);

        txtAttachment.setUpCase(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, datSentEmail, org.jdesktop.beansbinding.ELProperty.create("${attachment}"), txtAttachment, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        dlgNewEmail.getContentPane().add(txtAttachment, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

private void btnSendEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendEmailActionPerformed
    dlgNewEmail.setVisible(false);
    Thread t = new Thread(new Runnable() {
        public void run() {
            sendEmail();
        }
    });
    t.start();
}//GEN-LAST:event_btnSendEmailActionPerformed

private void sendEmail() {
    try {
        datSentEmail.setCustomerId(cboCustomer.getIntText());
        datSentEmail.setSentDate(constants.Constants.useDate);
        datSentEmail.setSeq(0);
        datSentEmail.save();
        test.SimpleMail.sendEmail(datSentEmail.getSubject(), datSentEmail.getContent(), datSentEmail.getRecipient().toLowerCase(), datSentEmail.getAttachment());
    } catch (Exception ex) {
        Logger.getLogger("global").log(Level.SEVERE, null, ex);
    }
}

private void btnChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseFileActionPerformed
    fileChooser.showOpenDialog(btnChooseFile);
    File f = fileChooser.getSelectedFile();
    if (f!=null && f.exists()) {
        String txt = BeanUtil.concat(txtAttachment.getText(),";",f.getPath());
        txtAttachment.setText(txt);
    }
}//GEN-LAST:event_btnChooseFileActionPerformed

private void btnLoadTemplateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadTemplateActionPerformed
    Common2View.showBeanPanel(EmailTemplate.class.getSimpleName());
    dlgNewEmail.setVisible(false);
}//GEN-LAST:event_btnLoadTemplateActionPerformed

private void cboTemplateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTemplateItemStateChanged
    EmailTemplate template = (EmailTemplate) cboTemplate.getSelectedBean();
    if (template!=null) {
        try {
            Object obj = TransactionPanel.getCurrentPanel().getBean();
            txtSubject.setText((String) ELProperty.create(template.getSubject()).getValue(obj));
            txtContent.setText((String) ELProperty.create(template.getContent()).getValue(obj));
        }
        catch (Exception e) {
            txtSubject.setText(template.getSubject());
            txtContent.setText(template.getContent());
        }
        txtAttachment.setText(template.attachment);
    }
}//GEN-LAST:event_cboTemplateItemStateChanged
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChooseFile;
    private javax.swing.JButton btnLoadTemplate;
    private javax.swing.JButton btnSendEmail;
    private component.LookupTableFieldPallete cboCustomer;
    private component.JComboBoxPallete cboTemplate;
    private java.util.List<bean.Customer> customerList;
    private javax.persistence.Query customerQuery;
    private bean.admin.SentEmail datSentEmail;
    private javax.swing.JDialog dlgNewEmail;
    private java.util.List<bean.admin.EmailTemplate> emailtemplateList;
    private javax.persistence.Query emailtemplateQuery;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.persistence.EntityManager toolPUEntityManager;
    private component.JTextFieldPallete txtAttachment;
    private javax.swing.JTextArea txtContent;
    private component.JTextFieldPallete txtSentTo;
    private component.JTextFieldPallete txtSubject;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    
}
