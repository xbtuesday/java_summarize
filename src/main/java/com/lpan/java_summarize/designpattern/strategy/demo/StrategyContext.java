package com.lpan.java_summarize.designpattern.strategy.demo;

public class StrategyContext {

    Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public String companyPayForDebit(String param){
        return strategy.debit(param);
    }

}
