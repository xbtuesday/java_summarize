package com.lpan.java_summarize.designpattern.responsibility.demo;


import lombok.Getter;
import lombok.Setter;

/**
 * 抽象处理者
 */

@Setter
@Getter
public abstract class PayHandler {

    public PayHandler nextHandler;

    public abstract void DebitPay(String paynum);


}
