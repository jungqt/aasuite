/*
 * TestDBForm.java
 *
 * Created on April 4, 2009, 2:02 PM
 */

package ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JTable;
import javax.swing.JTextField;

import util.BeanUtil;
import util.DBClient;
import util.DateUtil;
import util.Log;
import util.PanelUtil;
import util.ZipUtil;

/**
 *
 * @author  alex
 */
public class TestDBForm extends javax.swing.JPanel {
	Map<Integer, Integer> map = new Hashtable<Integer, Integer>();
    private static boolean stop;
    Vector columnNames = new Vector();
    Vector data = new Vector();
    
    /** Creates new form TestDBForm */
    public TestDBForm() {
    	columnNames.add("Computer");
    	columnNames.add("Start");
    	columnNames.add("End");
    	columnNames.add("Time");
    	columnNames.add("Size");
    	columnNames.add("Total Memory");
    	columnNames.add("Used Memory");
        initComponents();
        DBClient.collectSQL = true;
        PanelUtil.showMessage(this, "Please do your work and this will collect the SQL you issued.");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnClearLog = new javax.swing.JButton();
        btnStartCollect = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cboTestCount = new javax.swing.JComboBox();
        btnTest = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSQL = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl = new JTable(data, columnNames);
        tbl.setAutoCreateRowSorter(true);

        setName("Form"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(common2.Common2App.class).getContext().getResourceMap(TestDBForm.class);
        btnClearLog.setText(resourceMap.getString("btnClearLog.text")); // NOI18N
        btnClearLog.setName("btnClearLog"); // NOI18N
        btnClearLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearLogActionPerformed(evt);
            }
        });
        jPanel1.add(btnClearLog);

        btnStartCollect.setText(resourceMap.getString("btnStartCollect.text")); // NOI18N
        btnStartCollect.setName("btnStartCollect"); // NOI18N
        btnStartCollect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartCollectActionPerformed(evt);
            }
        });
        jPanel1.add(btnStartCollect);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        jPanel1.add(jLabel1);

        cboTestCount.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "50","75","100","150","200" }));
        cboTestCount.setName("cboTestCount"); // NOI18N
        txtThread = new JTextField(5);
        jPanel1.add(txtThread);
        jPanel1.add(cboTestCount);

        btnTest.setText(resourceMap.getString("btnTest.text")); // NOI18N
        btnTest.setName("btnTest"); // NOI18N
        btnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });
        jPanel1.add(btnTest);

        btnStop.setText("Query Sizes"); // NOI18N
        btnStop.setName("btnStop"); // NOI18N
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });
        jPanel1.add(btnStop);

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setDividerSize(10);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setName("jSplitPane1"); // NOI18N
        jSplitPane1.setOneTouchExpandable(true);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        txtSQL.setColumns(20);
        txtSQL.setRows(5);
        txtSQL.setName("txtSQL"); // NOI18N
        jScrollPane1.setViewportView(txtSQL);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        tbl.setName("tbl"); // NOI18N
        jScrollPane2.setViewportView(tbl);

        jSplitPane1.setRightComponent(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void btnStartCollectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartCollectActionPerformed
    StringBuffer sb = new StringBuffer();
    List<String> lst = DBClient.collectedSQL;
    for (String sql : lst) {
        sb.append(sql).append("\n");
    }
    txtSQL.setText(sb.toString());
    DBClient.collectedSQL.clear();
}//GEN-LAST:event_btnStartCollectActionPerformed

private void testThread() {
    btnTest.setEnabled(false);
    String txt = txtSQL.getText();
    List<String> sqlList = new ArrayList();
    String[] arr = txt.split("\n");
    for (String sql : arr) {
        sqlList.add(sql);
    }
    btnTest.setEnabled(false);
    Date d = new Date();
    
    Object obj = DBClient.batchQueryNoCache(sqlList);

    int i = data.size();
    int size = ZipUtil.getBytes(obj).length;
    Date d2 = new Date();
    Vector vec = new Vector();
    vec.add(BeanUtil.concat("PC "+(i+1)));
    vec.add(DateUtil.formatDate(d, "hh:mm:ss"));
    vec.add(DateUtil.formatDate(d2, "hh:mm:ss"));
    vec.add(d2.getTime()-d.getTime());
    vec.add(size);
    vec.add((int) (Runtime.getRuntime().totalMemory()/1000000));
    vec.add((int) ((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/1000000));
    data.add(vec);
    Log.out("PC "+(i+1));
    if (map.get(size) == null) {
    	map.put(size, 0);
    }
    int count = map.get(size);
    map.put(size, count+1);
    btnTest.setEnabled(true);
}

private void btnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestActionPerformed
    stop = false;
    PanelUtil.showMessage(btnTest, "The process will use batch then do single sql sending.");
    int count = PanelUtil.getIntValue(cboTestCount.getSelectedItem().toString());
    btnTest.setEnabled(false);
    data.clear();
    int t = Integer.parseInt(txtThread.getText());
    ExecutorService e = Executors.newFixedThreadPool(count);
    for (int i = 0; i < t; i++) {
    	e.execute(new run(i) {
            @Override
            public void run() {
                testThread();
            }
        });
    }
}//GEN-LAST:event_btnTestActionPerformed

private void displaySizes() {
	txtSQL.append("\nSIZES ------ \n");
	Iterator iter = map.keySet().iterator();
	while (iter.hasNext()) {
		Object key = iter.next();
		int value = map.get((Integer) key);
		txtSQL.append(BeanUtil.concat(key.toString()," - ",value,"\n"));
	}
}

private static class run implements Runnable {
	int i;
	private run(int i) {
		this.i = i;
	}
	
	public int getI() {
		return i;
	}

	@Override
	public void run() {
	}
}

private void btnClearLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearLogActionPerformed
	data.clear();
}//GEN-LAST:event_btnClearLogActionPerformed

private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
    displaySizes();
}//GEN-LAST:event_btnStopActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearLog;
    private javax.swing.JButton btnStartCollect;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton btnTest;
    private javax.swing.JComboBox cboTestCount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable tbl;
    private javax.swing.JTextArea txtSQL;
    private javax.swing.JTextField txtThread;
    // End of variables declaration//GEN-END:variables

}