/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ULDBuildUpForm.java
 *
 * Created on Mar 7, 2010, 1:14:11 PM
 */

package ui;

import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import bean.UldNumber;
import bean.awb.AwbFlt;

import service.util.AbstractIBean;
import template.screen.TransactionPanel;
import util.DBClient;
import util.PanelUtil;

/**
 *
 * @author Administrator
 */
public class ULDBuildUpForm extends TransactionPanel {
	private UldNumber uld;

    @Override
    public String getTitle() {
        return "ULD Build Up";
    }
	
    /** Creates new form ULDBuildUpForm */
    public ULDBuildUpForm() {
        initComponents();
        List lst = DBClient.getList("SELECT a FROM AwbFlt a, Awb b WHERE a.awbSeq=b.seq AND b.prefix is not null AND a.uldNumber is null AND b.activeStatus LIKE '%C%'");
        beanLooseCargo.setList(lst);
        
        beanInsideCargo.view.tblResult.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				changeInsideCargoDetail();
			}
		});
        beanLooseCargo.view.tblResult.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				changeLooseCargoDetail();
			}
		});
    }

    protected void changeLooseCargoDetail() {
    	AbstractIBean b = beanLooseCargo.getBean();
    	beanLooseCargoDetail.setBean(b);
	}

	protected void changeInsideCargoDetail() {
    	AbstractIBean b = beanInsideCargo.getBean();
    	beanInsideCargoDetail.setBean(b);
	}

	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        beanLooseCargo = new component.BeanPanelPallete();
        jPanel6 = new javax.swing.JPanel();
        beanLooseCargoDetail = new component.BeanPanelPallete();
        jPanel3 = new javax.swing.JPanel();
        beanInsideCargo = new component.BeanPanelPallete();
        jPanel5 = new javax.swing.JPanel();
        beanInsideCargoDetail = new component.BeanPanelPallete();
        jPanel9 = new javax.swing.JPanel();
        btnAssignCargo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRemoveCargo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel8.setName("jPanel8"); // NOI18N
        jPanel8.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Loose Cargo"));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(0, 1));

        beanLooseCargo.setBeanName("AwbFltBuildUpListExt");
        beanLooseCargo.setName("beanLooseCargo"); // NOI18N
        beanLooseCargo.setShowForm(false);
        beanLooseCargo.setShowImage(false);
        beanLooseCargo.setShowResult(true);

        javax.swing.GroupLayout beanLooseCargoLayout = new javax.swing.GroupLayout(beanLooseCargo);
        beanLooseCargo.setLayout(beanLooseCargoLayout);
        beanLooseCargoLayout.setHorizontalGroup(
            beanLooseCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );
        beanLooseCargoLayout.setVerticalGroup(
            beanLooseCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );

        jPanel1.add(beanLooseCargo);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail"));
        jPanel6.setName("jPanel6"); // NOI18N
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        beanLooseCargoDetail.setBeanName("AwbFltBuildUpDetailExt");
        beanLooseCargoDetail.setName("beanLooseCargoDetail"); // NOI18N
        beanLooseCargoDetail.setShowImage(false);

        javax.swing.GroupLayout beanLooseCargoDetailLayout = new javax.swing.GroupLayout(beanLooseCargoDetail);
        beanLooseCargoDetail.setLayout(beanLooseCargoDetailLayout);
        beanLooseCargoDetailLayout.setHorizontalGroup(
            beanLooseCargoDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        beanLooseCargoDetailLayout.setVerticalGroup(
            beanLooseCargoDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        jPanel6.add(beanLooseCargoDetail);

        jPanel1.add(jPanel6);

        jPanel8.add(jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Inside Cargo"));
        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setLayout(new java.awt.GridLayout(0, 1));

        beanInsideCargo.setBeanName("AwbFltBuildUpListExt");
        beanInsideCargo.setName("beanInsideCargo"); // NOI18N
        beanInsideCargo.setShowForm(false);
        beanInsideCargo.setShowImage(false);
        beanInsideCargo.setShowResult(true);

        javax.swing.GroupLayout beanInsideCargoLayout = new javax.swing.GroupLayout(beanInsideCargo);
        beanInsideCargo.setLayout(beanInsideCargoLayout);
        beanInsideCargoLayout.setHorizontalGroup(
            beanInsideCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );
        beanInsideCargoLayout.setVerticalGroup(
            beanInsideCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );

        jPanel3.add(beanInsideCargo);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail"));
        jPanel5.setName("jPanel5"); // NOI18N
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        beanInsideCargoDetail.setBeanName("AwbFltBuildUpDetailExt");
        beanInsideCargoDetail.setName("beanInsideCargoDetail"); // NOI18N
        beanInsideCargoDetail.setShowImage(false);

        javax.swing.GroupLayout beanInsideCargoDetailLayout = new javax.swing.GroupLayout(beanInsideCargoDetail);
        beanInsideCargoDetail.setLayout(beanInsideCargoDetailLayout);
        beanInsideCargoDetailLayout.setHorizontalGroup(
            beanInsideCargoDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        beanInsideCargoDetailLayout.setVerticalGroup(
            beanInsideCargoDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        jPanel5.add(beanInsideCargoDetail);

        jPanel3.add(jPanel5);

        jPanel8.add(jPanel3);

        add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel9.setName("jPanel9"); // NOI18N

        btnAssignCargo.setText(">> Assign Cargo >>");
        btnAssignCargo.setName("btnAssignCargo"); // NOI18N
        btnAssignCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignCargoActionPerformed(evt);
            }
        });
        jPanel9.add(btnAssignCargo);

        jLabel1.setText("            ");
        jLabel1.setName("jLabel1"); // NOI18N
        jPanel9.add(jLabel1);

        btnRemoveCargo.setText("<< Remove Cargo <<");
        btnRemoveCargo.setName("btnRemoveCargo"); // NOI18N
        btnRemoveCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveCargoActionPerformed(evt);
            }
        });
        jPanel9.add(btnRemoveCargo);

        add(jPanel9, java.awt.BorderLayout.SOUTH);

        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setText("   Select cargo from Loose Cargo then click Assign Cargo");
        jLabel2.setName("jLabel2"); // NOI18N
        jPanel2.add(jLabel2);

        add(jPanel2, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignCargoActionPerformed
        AwbFlt flt = (AwbFlt) beanLooseCargo.getBean();
        if (flt.pieces > 1) {
        	int d = (int) PanelUtil.showPromptMessage(btnAssignCargo, "Put all pieces inside ULD.", flt.pieces);
        	if (d > flt.pieces) {
        		PanelUtil.showError(null, "Typed values is more than cargo pieces.");
        		return;
        	}
        	else if (d < flt.pieces) {
        		AwbFlt partial = (AwbFlt) flt.clone();
        		partial.seq = null;
        		partial.pieces = flt.pieces - d;
        		partial.save();
        		beanLooseCargo.view.list.add(partial);
        		flt.pieces = d;
        	}
        }
        flt.uldNumber = uld.uld;
    	flt.save();
    	beanLooseCargo.view.list.remove(flt);
    	beanInsideCargo.view.list.add(uld);
    }//GEN-LAST:event_btnAssignCargoActionPerformed

    private void btnRemoveCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveCargoActionPerformed
    	AwbFlt flt = (AwbFlt) beanInsideCargo.getBean();
        if (flt.pieces > 1) {
        	int d = (int) PanelUtil.showPromptMessage(btnAssignCargo, "Remove all pieces out of ULD.", flt.pieces);
        	if (d > flt.pieces) {
        		PanelUtil.showError(null, "Typed values is more than cargo pieces.");
        		return;
        	}
        	else if (d < flt.pieces) {
        		AwbFlt partial = (AwbFlt) flt.clone();
        		partial.seq = null;
        		partial.pieces = flt.pieces - d;
        		partial.save();
        		beanInsideCargo.view.list.add(partial);
        		flt.pieces = d;
        	}
        }
    	flt.uldNumber = null;
    	flt.save();
    	beanInsideCargo.view.list.remove(flt);
        beanLooseCargo.view.list.add(flt);
    }//GEN-LAST:event_btnRemoveCargoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.BeanPanelPallete beanInsideCargo;
    private component.BeanPanelPallete beanInsideCargoDetail;
    private component.BeanPanelPallete beanLooseCargo;
    private component.BeanPanelPallete beanLooseCargoDetail;
    private javax.swing.JButton btnAssignCargo;
    private javax.swing.JButton btnRemoveCargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
    
	public void setUldNumber(UldNumber uld) {
        List lst = DBClient.getList("SELECT a FROM AwbFlt a, Awb b WHERE a.awbSeq=b.seq AND b.prefix is not null AND a.uldNumber='",uld.uld,"'");
        beanInsideCargo.setList(lst);
        this.uld = uld;
	}

}
