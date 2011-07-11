/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UITemplateCreator.java
 *
 * Created on Mar 23, 2011, 11:06:33 PM
 */

package common2;

import java.awt.Desktop;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author alex
 */
public class UITemplateCreator extends javax.swing.JPanel {
    List<String> lst = test.XMLTester.getAllBeanNames();

    protected void updateRenderUI() {

    }

    /** Creates new form UITemplateCreator */
    public UITemplateCreator() {
        initComponents();
        ListModel bigData = new AbstractListModel() {
            public int getSize() {
            	return lst.size();
            }
            public Object getElementAt(int index) {
            	return lst.get(index);
            }
        };
        lstClasses.setModel(bigData);
        lstClasses.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				txtCodes.setText(convertBean(lstClasses.getSelectedValue().toString()));
//				txtHtml.setText(convertBean(lstClasses.getSelectedValue().toString()));
			}
		});
    }

    public javax.swing.JPanel getDesktop() {
        return desktop;
    }

    protected String convertBean(String bean) {
    	return bean;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstClasses = new javax.swing.JList();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCodes = new javax.swing.JTextArea();
        desktop = new javax.swing.JPanel();

        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setName("jSplitPane1"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(common2.Common2App.class).getContext().getResourceMap(UITemplateCreator.class);
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jScrollPane1.border.title"))); // NOI18N
        jScrollPane1.setName("jScrollPane1"); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 130));

        lstClasses.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstClasses.setName("lstClasses"); // NOI18N
        lstClasses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstClassesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstClasses);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane2.setName("jSplitPane2"); // NOI18N

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jScrollPane2.border.title"))); // NOI18N
        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.setName("jScrollPane2"); // NOI18N

        txtCodes.setColumns(20);
        txtCodes.setRows(5);
        txtCodes.setName("txtCodes"); // NOI18N
        txtCodes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodesKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtCodes);

        jSplitPane2.setLeftComponent(jScrollPane2);

        desktop.setName("desktop"); // NOI18N
        desktop.setLayout(new java.awt.GridLayout());
        jSplitPane2.setRightComponent(desktop);

        jSplitPane1.setRightComponent(jSplitPane2);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void lstClassesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstClassesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lstClassesMouseClicked

    private void txtCodesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodesKeyTyped
    	updateRenderUI();
    }//GEN-LAST:event_txtCodesKeyTyped

    public String getCode() {
    	return txtCodes.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel desktop;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JList lstClasses;
    private javax.swing.JTextArea txtCodes;
    // End of variables declaration//GEN-END:variables

}
