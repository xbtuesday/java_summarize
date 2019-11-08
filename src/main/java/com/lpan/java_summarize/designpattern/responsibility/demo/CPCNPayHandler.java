package com.lpan.java_summarize.designpattern.responsibility.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 *  具体处理者
 */

public class CPCNPayHandler extends PayHandler {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void DebitPay(String paynum) {
        if (null != paynum && paynum.equals("CPCN")){
            logger.info("当前支付通道是中金支付：" + paynum);
        }else if (null != getNextHandler()){
            getNextHandler().DebitPay(paynum);
        }else{

        }
    }
}
