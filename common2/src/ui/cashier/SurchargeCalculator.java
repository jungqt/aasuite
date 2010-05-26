/*
 * SurchargeCalculator.java
 *
 * Created on April 19, 2009, 10:31 AM
 */

package ui.cashier;

import bean.Person;
import bean.accounting.Payment;
import bean.admin.AppConfig;
import component.JCalendarPallete;
import java.awt.Dimension;
import java.util.List;

import springbean.AAAConfig;
import util.DBClient;
import util.PanelUtil;

/**
 *
 * @author  Alex Miranda
 */
public class SurchargeCalculator extends javax.swing.JPanel {
    Person stud;
    String schoolYear;
    
    public static void main(String[] args) {
    	AAAConfig.getInstance();
        display(null, null);
    }
    
    public static void display(List<Payment> lst) {
        SurchargeCalculator calc = new SurchargeCalculator();
        calc.updateList(lst);
        Dimension dim = calc.getPreferredSize();
        dim.width = 950;
        dim.height = 350;
        calc.setPreferredSize(dim);
        PanelUtil.showDialog(calc, "Surcharge Calculator");
    }

    public static void display(Person stud, String schoolYear) {
        SurchargeCalculator calc = new SurchargeCalculator();
        calc.stud = stud;
        calc.schoolYear = schoolYear;
        calc.updateList();
        Dimension dim = calc.getPreferredSize();
        dim.width = 950;
        dim.height = 350;
        calc.setPreferredSize(dim);
        PanelUtil.showDialog(calc, "Surcharge Calculator");
    }
    
    /** Creates new form SurchargeCalculator */
    public SurchargeCalculator() {
        initComponents();
        try {
        	boolean prod = AppConfig.isProduction();
        	if (prod) {
        		btnSaveSimulation.setVisible(false);
        	}
        }
        catch (Exception e) {
        }
    }

    public void updateList(List lst) {
    	beanPanelPallete1.setList(lst);
    }

    public void updateList() {
    	if (stud!=null) {
            List lst = DBClient.getList("SELECT a FROM Payment a WHERE a.paidBy=",stud.personId+" AND a.schoolYear='",schoolYear,"' AND a.paid=false");
            beanPanelPallete1.setList(lst);
    	}
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        beanPanelPallete1 = new component.BeanPanelPallete();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        calPayDate = new JCalendarPallete();
        btnCalculate = new javax.swing.JButton();
        btnSaveSimulation = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        beanPanelPallete1.setBeanName("PaymentCashierSurchargeCalculatorExt");
        beanPanelPallete1.setName("beanPanelPallete1"); // NOI18N
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
            .addGap(0, 267, Short.MAX_VALUE)
        );

        add(beanPanelPallete1, java.awt.BorderLayout.CENTER);

        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setText("Tentative Pay Date:");
        jLabel1.setName("jLabel1"); // NOI18N
        jPanel1.add(jLabel1);

        calPayDate.setName("calPayDate"); // NOI18N
        jPanel1.add(calPayDate);

        btnCalculate.setText("Calculate");
        btnCalculate.setName("btnCalculate"); // NOI18N
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });
        jPanel1.add(btnCalculate);

        btnSaveSimulation.setText("Save Simulation");
        btnSaveSimulation.setName("btnSaveSimulation"); // NOI18N
        btnSaveSimulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSimulationActionPerformed(evt);
            }
        });
        jPanel1.add(btnSaveSimulation);

        add(jPanel1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
	List<Payment> lst = beanPanelPallete1.view.list;
	for (Payment p:lst) {
		p.useTentativePaymentDate(((JCalendarPallete)calPayDate).getDate());
	}
	try {
		beanPanelPallete1.view.tblResult.setRowSelectionInterval(1, 1);
	}
	catch (Exception e) {
	}
	try {
		beanPanelPallete1.view.tblResult.setRowSelectionInterval(0, 0);
	}
	catch (Exception e) {
	}
}//GEN-LAST:event_btnCalculateActionPerformed

private void btnSaveSimulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSimulationActionPerformed
	List<Payment> lst = beanPanelPallete1.view.list;
	for (Payment p:lst) {
		p.surcharge = p.surchargeBalance = p.calculatedSurcharge;
        p.overallBalance -= p.surcharge;
	}
    DBClient.persistBean((List) lst);
}//GEN-LAST:event_btnSaveSimulationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.BeanPanelPallete beanPanelPallete1;
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnSaveSimulation;
    private javax.swing.JComboBox calPayDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
