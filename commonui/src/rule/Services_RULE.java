package rule;

import javax.swing.JComponent;

import service.IService;
import service.util.CallService;
import util.BeanUtil;

import bean.service.Services;

public class Services_RULE extends BusinessRuleWrapper {

	@Override
	public void runFocusLost(JComponent comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runOnClick(JComponent comp) {
		if ("btnRun".equals(comp.getName())) {
			runService();
		}
	}

	private void runService() {
		Services serv = (Services) this.getBean();
		String s = BeanUtil.concat("springbean.",serv.code);
		CallService.callService("", 1, s);
	}

}
