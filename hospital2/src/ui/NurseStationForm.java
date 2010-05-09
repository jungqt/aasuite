/*
 * NurseStationForm.java
 *
 * Created on June 4, 2009, 9:34 PM
 */

package ui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import bean.Admission;
import bean.Patient;
import bean.reference.RoomHospital;

import constants.UserInfo;
import springbean.AAAConfig;
import template.screen.TransactionPanel;
import util.DBClient;
import util.PanelUtil;

/**
 *
 * @author  alex
 */
public class NurseStationForm extends TransactionPanel {

    public static void main(String[] args) {
        java.awt.Color clr = new java.awt.Color(44, 117, 44);
        constants.Constants.panelBackground = clr;
        constants.Constants.labelColor = Color.WHITE;
        AAAConfig.getInstance();
        UserInfo.weblogin("AAA", "AAAXXXAAA");
        PanelUtil.displayToFrame(new NurseStationForm());
    }
    
    /** Creates new form NurseStationForm */
    public NurseStationForm() {
        initComponents();
        PanelUtil.updateColor(this);
        PanelUtil.updateColor(jPanel1);
        PanelUtil.updateColor(jPanel2);
        PanelUtil.updateColor(jPanel3);
        PanelUtil.updateColor(jPanel4);
        PanelUtil.updateColor(jLabel1);
        
        beanPatients.view.tblResult.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				changePatientInfo();
			}
        });
        try {
        	List lst = DBClient.getList("SELECT a FROM Patient a WHERE a.section IS NOT NULL ORDER BY a.lastName, a.firstName");
        	beanPatients.setList(lst);
        }
        catch (Exception e) {
        }
    }
    

	private void changePatientInfo() {
		Patient p = (Patient) beanPatients.getBean();
		beanPatientInfo.setBean(p);
		
		if (p!=null) {
			Admission ad = (Admission) DBClient.getFirstRecord("SELECT a FROM Admission a WHERE a.seq="+p.admissionId);
			beanAdmission.setBean(ad);
		}
	}
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnShowAll = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtSearchPatient = new javax.swing.JTextField();
        beanPatients = new component.BeanPanelPallete();
        jPanel3 = new javax.swing.JPanel();
        beanPatientInfo = new component.BeanPanelPallete();
        jPanel12 = new javax.swing.JPanel();
        btnReleasePatient = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        beanAdmission = new component.BeanPanelPallete();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 200));
        jPanel1.setPreferredSize(new java.awt.Dimension(809, 200));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Patients"));
        jPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 200));
        jPanel2.setPreferredSize(new java.awt.Dimension(309, 250));
        jPanel2.setLayout(new java.awt.BorderLayout());

        btnShowAll.setText("Show All");
        btnShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllActionPerformed(evt);
            }
        });
        jPanel4.add(btnShowAll);

        jLabel1.setText("Or Search:");
        jPanel4.add(jLabel1);

        txtSearchPatient.setPreferredSize(new java.awt.Dimension(150, 20));
        txtSearchPatient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchPatientKeyPressed(evt);
            }
        });
        jPanel4.add(txtSearchPatient);

        jPanel2.add(jPanel4, java.awt.BorderLayout.NORTH);

        beanPatients.setBeanName("Patient");
        beanPatients.setShowForm(false);
        beanPatients.setShowImage(false);
        beanPatients.setShowResult(true);

        javax.swing.GroupLayout beanPatientsLayout = new javax.swing.GroupLayout(beanPatients);
        beanPatients.setLayout(beanPatientsLayout);
        beanPatientsLayout.setHorizontalGroup(
            beanPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );
        beanPatientsLayout.setVerticalGroup(
            beanPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
        );

        jPanel2.add(beanPatients, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Patient Information"));
        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 200));
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 250));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        beanPatientInfo.setBeanName("PatientSnapShotExt");

        javax.swing.GroupLayout beanPatientInfoLayout = new javax.swing.GroupLayout(beanPatientInfo);
        beanPatientInfo.setLayout(beanPatientInfoLayout);
        beanPatientInfoLayout.setHorizontalGroup(
            beanPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );
        beanPatientInfoLayout.setVerticalGroup(
            beanPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );

        jPanel3.add(beanPatientInfo);

        jPanel1.add(jPanel3, java.awt.BorderLayout.EAST);

        add(jPanel1, java.awt.BorderLayout.NORTH);

        btnReleasePatient.setText("Release Patient");
        btnReleasePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReleasePatientActionPerformed(evt);
            }
        });
        jPanel12.add(btnReleasePatient);

        add(jPanel12, java.awt.BorderLayout.SOUTH);

        jPanel5.setLayout(new java.awt.GridLayout());

        beanAdmission.setBeanName("AdmissionExt");
        beanAdmission.setShowImage(false);
        beanAdmission.setShowSubRecords(true);

        javax.swing.GroupLayout beanAdmissionLayout = new javax.swing.GroupLayout(beanAdmission);
        beanAdmission.setLayout(beanAdmissionLayout);
        beanAdmissionLayout.setHorizontalGroup(
            beanAdmissionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 887, Short.MAX_VALUE)
        );
        beanAdmissionLayout.setVerticalGroup(
            beanAdmissionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );

        jPanel5.add(beanAdmission);

        add(jPanel5, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchPatientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchPatientKeyPressed
        if (evt.getKeyChar()=='\n') {
        	if (txtSearchPatient.getText()==null || txtSearchPatient.getText().trim().isEmpty()) {
            	List lst = DBClient.getList("SELECT a FROM Patient a WHERE a.section IS NOT NULL ORDER BY a.lastName, a.firstName");
            	beanPatients.setList(lst);
        	}
        	else {
            	List lst = DBClient.getList("SELECT a FROM Patient a WHERE a.section IS NOT NULL AND (a.lastName LIKE '"+txtSearchPatient.getText()+"%' OR a.firstName LIKE '"+txtSearchPatient.getText()+"%') ORDER BY a.lastName, a.firstName");
            	beanPatients.setList(lst);
        	}
        }
    }//GEN-LAST:event_txtSearchPatientKeyPressed

    private void btnShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllActionPerformed
    	List lst = DBClient.getList("SELECT a FROM Patient a WHERE a.section IS NOT NULL");
    	beanPatients.setList(lst);
    }//GEN-LAST:event_btnShowAllActionPerformed

    private void btnReleasePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReleasePatientActionPerformed
        Patient p = (Patient) beanPatients.getBean();
        
        RoomHospital room = (RoomHospital) RoomHospital.extractObject(RoomHospital.class.getSimpleName(), p.section);
        room.patientId = 0;
        room.patient = null;
//        room.save();

        p.section = null;
//        p.save();
        
    	List tmp = new ArrayList();
    	tmp.add(room);
    	tmp.add(p);

    	List lst = DBClient.batchQueryNoCache(tmp, "SELECT a FROM Patient a WHERE a.section IS NOT NULL");
    	beanPatients.setList(lst);
    }//GEN-LAST:event_btnReleasePatientActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.BeanPanelPallete beanAdmission;
    private component.BeanPanelPallete beanPatientInfo;
    public component.BeanPanelPallete beanPatients;
    private javax.swing.JButton btnReleasePatient;
    private javax.swing.JButton btnShowAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField txtSearchPatient;
    // End of variables declaration//GEN-END:variables
    
}