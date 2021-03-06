/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.tree.DefaultMutableTreeNode;

import rule.helper.Awb_RuleHelper;
import service.FlightService;
import template.screen.TablePopup;
import util.BeanUtil;
import util.DBClient;
import util.PanelUtil;
import bean.Awb;
import bean.ChargesRule;
import bean.Flight;
import bean.awb.AwbCharges;
import bean.extension.ChargesRuleExt;

import common2.Common2View;
import component.JTreeTableDisplayer;

/**
 *
 * @author Charliemagne Mark
 */
public class Awb_RULE extends BusinessRuleWrapper {
	Awb_RuleHelper helper = new Awb_RuleHelper();
	
    @Override
    public void runFocusLost(JComponent comp) {
    }

    @Override
    public void runOnClick(JComponent comp) {
        if ("btnCreateBooking".equals(comp.getName())) {
            createBooking();
        }
        else if ("btnChooseRoute".equals(comp.getName())) {
            chooseRoute();
        }
        else if ("btnChargesRule".equals(comp.getName())) {
        	chargesRule();
        }
        else if ("btnShowMessages".equals(comp.getName())) {
            showMessages();
        }
        else if ("btnCreateInvoice".equals(comp.getName())) {
            createInvoice();
        }
        else if ("btnViewGL".equals(comp.getName())) {
            viewGL();
        }
    }

    private void chargesRule() {
        Awb awb = (Awb) this.getBean();
		List<ChargesRule> lst = helper.getApplicableCharges(awb);
		PanelUtil.popupBeanTemplate(ChargesRuleExt.class, "Applicable Charges", false, lst);
		boolean b = showPrompt("Do you want to save the applicable charges?");
		if (b) {
//			should merge charge for origin, not yet implemented
			List l = new ArrayList();
			for (ChargesRule c:lst) {
				AwbCharges charge = new AwbCharges();
				charge.awbSeq = awb.seq;
				charge.amount = c.amount;
				charge.chargeCode = c.chargeCode;
				if (c.shc != null) {
					charge.reason = c.shc;
				}
				else if (c.serviceLevel != null) {
					charge.reason = c.serviceLevel;
				}
				l.add(charge);
			}
			DBClient.persistBean(l);
			redisplayRecord();
		}
	}

	private void viewGL() {
		showError("Under Construction in Awb_RULE, must be called before createInvoice.");		
	}

	private void createInvoice() {
		showError("Under Construction in Awb_RULE, this must recalculate charges then put in AWb then display the Invoice.");		
	}

	private void chooseRoute() {
        Awb awb = (Awb) this.getBean();
        if (awb.departureDate==null) {
            awb.departureDate = util.DateUtil.addDay(new Date(), 1);
            awb.save();
        }
        FlightService serv = new FlightService();
        List lst = serv.getAllRoutes(awb);
        if (lst==null || lst.isEmpty()) {
            showMessage("No routes available.");
            return;
        }
        DefaultMutableTreeNode obj = (DefaultMutableTreeNode) JTreeTableDisplayer.popup(lst, "Route Selection");
        if (obj!=null && obj.getUserObject() instanceof Flight) {
            List<Flight> lstFlight = new ArrayList<Flight>();
            Flight f = (Flight) obj.getUserObject();
            DefaultMutableTreeNode pnode = (DefaultMutableTreeNode) f.myNode.getParent();
            if (pnode==null || pnode.getUserObject()==null || pnode.getUserObject().toString().trim().isEmpty()) {
                lstFlight.add(f);
            }
            else {
                int count = pnode.getChildCount();
                for (int i = 0; i < count; i++) {
                    DefaultMutableTreeNode n = (DefaultMutableTreeNode) pnode.getChildAt(i);
                    lstFlight.add((Flight) n.getUserObject());
                }
            }
            helper.putRouting(lstFlight, awb);
            redisplayRecord();
        }
    }

    private void createBooking() {
        Awb awb = (Awb) this.getBean();
        awb.save();
        helper.createBooking(awb);
        redisplayRecord();
    }

    private void showMessages() {
        Awb awb = (Awb) this.getBean();
        Common2View.showBeanPanel("CargoMessageInbox", "", BeanUtil.concat("SELECT a FROM CargoMessageInbox a, CargoMessageTransactionDetail b WHERE a.seq=b.cargoMessageInboxSeq AND b.entity='Awb' AND b.entityId='",awb.seq,"'"));
    }
}
