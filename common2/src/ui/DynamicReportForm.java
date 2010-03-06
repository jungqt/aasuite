/*
 * DynamicReportForm.java
 *
 * Created on March 8, 2008, 7:19 PM
 */

package ui;

import bean.admin.DynamicReport;
import component.AbstractPanel;
import component.AbstractReport;
import java.awt.EventQueue;
import java.io.File;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JFrame;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperReport;
import service.util.AbstractIBean;
import service.util.WSPersistenceEntityManager;
import util.DataUtil;

/**
 *
 * @author  Entokwaa
 */
public class DynamicReportForm extends AbstractPanel {

    @Override
    public String getHelpName() {
        return "Module.Reports.Dynamic Report Admin";
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
    
    /** Creates new form DynamicReportForm */
    public DynamicReportForm() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingContext = new javax.beans.binding.BindingContext();

        reportParameterViewer1 = new component.ReportParameterViewer();
        schoolPUEntityManager = WSPersistenceEntityManager.getInstance();
        dynamicReportQuery = schoolPUEntityManager.createQuery("SELECT d FROM DynamicReport d");
        dynamicReportList = com.sun.java.util.BindingCollections.observableList(dynamicReportQuery.getResultList());
        dataReportCategory = new bean.admin.DynamicReportCategory();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeReports = new component.JTreePallete();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlViewer = new javax.swing.JPanel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reports", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        bindingContext.addBinding(dataReportCategory, null, treeReports, "rootBean");

        treeReports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                treeReportsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(treeReports);

        jPanel1.add(jScrollPane1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Report Viewer", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        pnlViewer.setLayout(new java.awt.GridLayout());
        jScrollPane2.setViewportView(pnlViewer);

        jPanel2.add(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                .addContainerGap())
        );

        bindingContext.bind();
    }// </editor-fold>//GEN-END:initComponents

private void treeReportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treeReportsMouseClicked
    if (evt.getClickCount()==2) {
        //get the last selection only
        DynamicReport report = null;
        List<AbstractIBean> lst = treeReports.getSelectedObjects();
        for (AbstractIBean bean:lst) {
            if (bean instanceof DynamicReport) {
                report = (DynamicReport) bean;
            }
        }
        if (report!=null) {
            try {
                DataUtil.writeToFile(report.getXmlContent().getBytes(), constants.Constants.ROOT_FOLDER+"tmp/designing/"+report.getReportName(), false);
                report.setFile(new File(constants.Constants.ROOT_FOLDER+"tmp/designing/"+report.getReportName()));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            JasperReport jreport = AbstractReport.compileReport(report.getFile());
            List<JRParameter> params = AbstractReport.getReportParameters(jreport);
            if (params!=null && params.size()>0) {
                reportParameterViewer1.showParameters(jreport, pnlViewer, report.getFile());
            }
            else {  
                AbstractReport.displayReportToPanel(pnlViewer, jreport);
            }
        }
    }
}//GEN-LAST:event_treeReportsMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private bean.admin.DynamicReportCategory dataReportCategory;
    private java.util.List<bean.admin.DynamicReport> dynamicReportList;
    private javax.persistence.Query dynamicReportQuery;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlViewer;
    private component.ReportParameterViewer reportParameterViewer1;
    private javax.persistence.EntityManager schoolPUEntityManager;
    private component.JTreePallete treeReports;
    private javax.beans.binding.BindingContext bindingContext;
    // End of variables declaration//GEN-END:variables
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setContentPane(new DynamicReportForm());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

    public String getTitle() {
        return "Reports";
    }

    public JTable getMasterTable() {
        return null;
    }

    public List getMasterList() {
        return null;
    }

    public EntityManager getEntityManager() {
        return null;
    }

    public Query getMasterQuery() {
        return null;
    }

    public Class getBeanClass() {
        return bean.admin.DynamicReport.class;
    }
}