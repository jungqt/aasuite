/*
 * PhysicianAppointmentForm.java
 *
 * Created on June 5, 2009, 10:06 PM
 */

package ui;

import bean.Physician;
import constants.UserInfo;
import java.awt.Color;
import java.util.List;

import service.util.WSPersistenceEntityManager;
import springbean.AAAConfig;
import template.report.AbstractReportTemplate;
import util.DBClient;
import util.PanelUtil;

/**
 *
 * @author  alex
 */
public class PhysicianAppointmentForm extends javax.swing.JPanel {
    public static void main(String[] args) {
        java.awt.Color clr = new java.awt.Color(44, 117, 44);
        constants.Constants.panelBackground = clr;
        constants.Constants.labelColor = Color.WHITE;
        AAAConfig.getInstance();
        UserInfo.weblogin("WENG", "WENG");
        PanelUtil.displayToFrame(new PhysicianAppointmentForm());
    }
    
    /** Creates new form PhysicianAppointmentForm */
    public PhysicianAppointmentForm() {
        initComponents();
        PanelUtil.updateColor(jLabel1);
        PanelUtil.updateColor(jPanel1);
        PanelUtil.updateColor(jPanel2);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        hospitalPUEntityManager = WSPersistenceEntityManager.getInstance();
        personQuery = hospitalPUEntityManager.createQuery("SELECT p FROM Physician p ORDER BY p.lastName, p.firstName");
        personList = personQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        btnShowAll = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cboPhysician = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        btnPrintAppointment = new javax.swing.JButton();
        beanPanelPallete1 = new component.BeanPanelPallete();

        setLayout(new java.awt.BorderLayout());

        btnShowAll.setText("Show All");
        btnShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllActionPerformed(evt);
            }
        });
        jPanel1.add(btnShowAll);

        jLabel1.setText("Or Search Physician:");
        jPanel1.add(jLabel1);

        cboPhysician.setPreferredSize(new java.awt.Dimension(150, 22));

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, personList, cboPhysician);
        bindingGroup.addBinding(jComboBoxBinding);

        cboPhysician.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPhysicianItemStateChanged(evt);
            }
        });
        jPanel1.add(cboPhysician);

        add(jPanel1, java.awt.BorderLayout.NORTH);

        btnPrintAppointment.setText("Print Appointment");
        btnPrintAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintAppointmentActionPerformed(evt);
            }
        });
        jPanel2.add(btnPrintAppointment);

        add(jPanel2, java.awt.BorderLayout.SOUTH);

        beanPanelPallete1.setBeanName("Appointment");
        beanPanelPallete1.setShowForm(false);
        beanPanelPallete1.setShowImage(false);
        beanPanelPallete1.setShowResult(true);

        javax.swing.GroupLayout beanPanelPallete1Layout = new javax.swing.GroupLayout(beanPanelPallete1);
        beanPanelPallete1.setLayout(beanPanelPallete1Layout);
        beanPanelPallete1Layout.setHorizontalGroup(
            beanPanelPallete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        beanPanelPallete1Layout.setVerticalGroup(
            beanPanelPallete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        add(beanPanelPallete1, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllActionPerformed
        List lst = DBClient.getList("SELECT a FROM Appointment a ORDER BY a.physician, a.appointmentDate DESC");
        beanPanelPallete1.setList(lst);
    }//GEN-LAST:event_btnShowAllActionPerformed

    private void cboPhysicianItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPhysicianItemStateChanged
        Physician p = (Physician) cboPhysician.getSelectedItem();
        if (p!=null) {
        	List lst = DBClient.getList("SELECT a FROM Appointment a WHERE a.physicianId="+p.personId+" ORDER BY a.physician, a.appointmentDate DESC");
            beanPanelPallete1.setList(lst);
        }
    }//GEN-LAST:event_cboPhysicianItemStateChanged

    private void btnPrintAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintAppointmentActionPerformed
        Physician p = (Physician) cboPhysician.getSelectedItem();
        if (p!=null) {
        	AbstractReportTemplate.getInstance().showReportFromFileTemplateDialog("Appointment", p.personId, "Appointment of "+p.toString(), null);
        }
        else {
        	AbstractReportTemplate.getInstance().showReportFromFileTemplateDialog("Appointment", null, "All Appointments", null);
        }
    }//GEN-LAST:event_btnPrintAppointmentActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.BeanPanelPallete beanPanelPallete1;
    private javax.swing.JButton btnPrintAppointment;
    private javax.swing.JButton btnShowAll;
    private javax.swing.JComboBox cboPhysician;
    private javax.persistence.EntityManager hospitalPUEntityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private java.util.List<bean.Physician> personList;
    private javax.persistence.Query personQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    
}
