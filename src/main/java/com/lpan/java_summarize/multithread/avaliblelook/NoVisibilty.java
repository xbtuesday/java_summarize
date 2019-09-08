package com.lpan.java_summarize.multithread.avaliblelook;

/**
 * ClassName: NoVisibilty
 * Description: TODO
 * Author: shipan
 * Date 03/09/19 下午6:37
 * Version: 1.0
 */
public class NoVisibilty {

    private static int avaliablenumber;
    private static boolean flag;

    public static void main(String[] args) {
        new Visibilty().start();
        avaliablenumber = 44;
        flag = true;
    }

    public static class Visibilty extends Thread{
        @Override
        public void run() {
            if (!flag){
                Thread.yield();
                System.out.println(avaliablenumber);
            }
        }
    }


}
