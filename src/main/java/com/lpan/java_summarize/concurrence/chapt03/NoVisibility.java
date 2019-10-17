package com.lpan.java_summarize.concurrence.chapt03;

public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReadThread extends Thread{
        @Override
        public void run() {
            while (ready){
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {
        new ReadThread().start();
        number = 2;
        ready = true;
    }

}
