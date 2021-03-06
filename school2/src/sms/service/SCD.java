/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sms.service;

import bean.admin.AppConfig;
import bean.admin.SMSMessageBean;
import util.BeanUtil;
import util.DBClient;

/**
 *
 * @author Charliemagne Mark
 */
public class SCD extends AbstractSMSProcessor {
    //Grade SCD <Email address>
    /**
     * 1. Send SCD to the mobile number of school or company
     * 2. System will store the message to SMS Message Bean
     *  a. Mobile number will be checked according to Person mobile number
     */
    @Override
    public void run() {
        String message = this.bean.message;
        String[] arr = message.split(" ");
        String code = arr[0];
        String email = arr[1];

        this.bean.code1 = code;
        this.bean.code2 = email;
        //check if this has been sent already
        String sql = BeanUtil.concat("SELECT a FROM SMSMessageBean a WHERE a.phoneNumber='",this.bean.phoneNumber,"' AND a.code1='",this.bean.code1,"' AND a.code2='",this.bean.code2,"'");
        this.bean = (SMSMessageBean) DBClient.getFirstRecord(sql);
        this.bean.save();
        //this may acknowledge the message
        //if (AppConfig.isTrue("SMS GRDREPLY", true)) {
        //    this.server.addtoReply(this.bean.phoneNumber, getScheduleReport(email));
        //}
    }

    protected String getScheduleReport(String email) {
        //send to phone and email
        return "Grade request acknowledge";
    }
}