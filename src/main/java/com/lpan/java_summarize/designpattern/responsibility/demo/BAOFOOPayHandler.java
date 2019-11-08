package com.lpan.java_summarize.designpattern.responsibility.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BAOFOOPayHandler extends PayHandler {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void DebitPay(String paynum) {
        if (null != paynum && paynum.equals("BAOFOO")){
            logger.info("当前使用支付通道为宝付支付 ：" + paynum);
        }else if (null != getNextHandler()){
            getNextHandler().DebitPay(paynum);
        }else{
            logger.info("无可用支付通道");
        }
    }
}
