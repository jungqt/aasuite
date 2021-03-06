/*
 * StudentAction.java
 *
 * Created on September 21, 2008, 1:47 PM
 */

package ui.action;

import bean.Student;
import java.util.List;
import service.util.AbstractIBean;
import service.util.WSPersistenceEntityManager;
import springbean.SchoolDefaultProcess;
import util.PanelUtil;

/**
 *
 * @author  Entokwaa
 */
public class StudentAction extends javax.swing.JPanel {
    Student student;
    
    public static void changeGrade(Student student) {
        StudentAction action = new StudentAction();
        action.student = student;
        action.dlgChangeGrade.pack();
        action.dlgChangeGrade.setVisible(true);
    }
    /** Creates new form StudentAction */
    public StudentAction() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        dlgChangeGrade = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        cboCourse = new component.JComboBoxPallete();
        btnChangeGrade = new javax.swing.JButton();
        schoolPUEntityManager = WSPersistenceEntityManager.getInstance();
        courseQuery = java.beans.Beans.isDesignTime() ? null : schoolPUEntityManager.createQuery("SELECT c FROM Course c");
        courseList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : courseQuery.getResultList();

        dlgChangeGrade.setTitle("Change Grade");
        dlgChangeGrade.setAlwaysOnTop(true);
        dlgChangeGrade.setModal(true);
        dlgChangeGrade.setName("dlgChangeGrade"); // NOI18N
        dlgChangeGrade.getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Grade/Course:");
        jLabel1.setName("jLabel1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        dlgChangeGrade.getContentPane().add(jLabel1, gridBagConstraints);

        cboCourse.setName("cboCourse"); // NOI18N

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, courseList, cboCourse);
        bindingGroup.addBinding(jComboBoxBinding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 250;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        dlgChangeGrade.getContentPane().add(cboCourse, gridBagConstraints);

        btnChangeGrade.setText("Change Grade");
        btnChangeGrade.setName("btnChangeGrade"); // NOI18N
        btnChangeGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeGradeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        dlgChangeGrade.getContentPane().add(btnChangeGrade, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

private void btnChangeGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeGradeActionPerformed
    //todo: check if already had the course, create new student record, update old record parentId, register student for the course
    List<Student> lst = AbstractIBean.list("SELECT a FROM Student a WHERE a.personId=",student.personId," AND a.parentId=",student.personId);
    for (Student stud : lst) {
        if (cboCourse.getCode().equalsIgnoreCase(stud.course)) {
            PanelUtil.showErrorMessageToScreen("Course [",cboCourse.getCode(),"] already taken.");
            return;
        }
    }
    int personId = student.personId;
    student.personId = 0;
    student.course = cboCourse.getCode();
    student.save();
    Student oldStud = (Student) student.find(personId);
    oldStud.parentId = student.personId;
    oldStud.save();
    dlgChangeGrade.setVisible(false);
}//GEN-LAST:event_btnChangeGradeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeGrade;
    private component.JComboBoxPallete cboCourse;
    private java.util.List<bean.reference.Course> courseList;
    private javax.persistence.Query courseQuery;
    private javax.swing.JDialog dlgChangeGrade;
    private javax.swing.JLabel jLabel1;
    private javax.persistence.EntityManager schoolPUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
