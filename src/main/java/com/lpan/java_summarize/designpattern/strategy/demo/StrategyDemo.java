package com.lpan.java_summarize.designpattern.strategy.demo;

public class StrategyDemo {

    public static void main(String[] args) {
        StrategyContext strategyContext = new StrategyContext(new CPCNStrategy());
        String result = strategyContext.companyPayForDebit("我要代扣");
        System.out.println(result);
    }

}
