package com.lpan.java_summarize.designpattern.strategy.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CPCNStrategy implements Strategy {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String debit(String param) {
        logger.info("中金代扣");
        return param;
    }

    @Override
    public String angecy(String param) {
        logger.info("中金代付");
        return param;
    }
}
