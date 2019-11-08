package com.lpan.java_summarize.designpattern.responsibility.demo;

public class ClientDemo {
    public static void main(String[] args) {
        PayHandler payHandler = new CPCNPayHandler();
        PayHandler payHandler1 = new BAOFOOPayHandler();
        PayHandler payHandler2 = new HNAPayHandler();
        payHandler.setNextHandler(payHandler1);
        payHandler1.setNextHandler(payHandler2);
        payHandler.DebitPay("BAOFOO");
    }
}
