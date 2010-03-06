/*
 * PopupReportDisplayer.java
 *
 * Created on March 29, 2008, 6:04 PM
 */

package component;

import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperReport;
import util.DataUtil;

/**
 *
 * @author  Entokwaa
 */
public class PopupReportDisplayer extends javax.swing.JDialog {
    static PopupReportDisplayer popup;
    
    public static void showReport(String report) {
        showReport(report, new HashMap());
    }
    
    public static void showReport(String report, String addWhere) {
        Map<String, String> map = new HashMap<String, String>();
        map.put(constants.Constants.REPORT_ADD_WHERE, addWhere);
        showReport(report, map);
    }

    public static void showReport(String report, Map map) {
        if (popup==null) {
            popup = new PopupReportDisplayer(null, true);
            popup.pack();
        }
        JasperReport rep = component.AbstractReport.compileReport(DataUtil.getReportStream(report));
        if (map.size()==0) {
            component.AbstractReport.displayReportToPanel(popup.pnlReport, rep);
        }
        else {
            component.AbstractReport.displayReportToPanel(popup.pnlReport, rep, map);
        }
        popup.setVisible(true);
    }

    /** Creates new form PopupReportDisplayer */
    public PopupReportDisplayer(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlReport = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Report Viewer"); // NOI18N
        setMinimumSize(new java.awt.Dimension(550, 450));
        setModal(true);

        javax.swing.GroupLayout pnlReportLayout = new javax.swing.GroupLayout(pnlReport);
        pnlReport.setLayout(pnlReportLayout);
        pnlReportLayout.setHorizontalGroup(
            pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        pnlReportLayout.setVerticalGroup(
            pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PopupReportDisplayer dialog = new PopupReportDisplayer(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlReport;
    // End of variables declaration//GEN-END:variables
    
}