package com.lpan.java_summarize.bootschedule.dynamicscheduled;


public interface DynamicScheduledTask extends Runnable {
    @Override
    default void run() {
        executDynmicTask();
    }

    void executDynmicTask();
}
