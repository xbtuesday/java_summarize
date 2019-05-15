package com.lpan.java_summarize.multithread;


import java.util.concurrent.*;

/**
 * 线程池
 *      作用：线程池的作用就是限制系统中执行线程的数量
 *
 *      为什么使用线程池：
 *
 *
 *
 */
public class MyThread {

    public static void main(String[] args) {
        //singleThread();
        //cacheThread();
        //fixedThread();
        scheduledThread();
    }

    /***
     *  singleThreadExecutor
     *    只有一个线程的线程池  只会使用唯一的工作线程来执行任务，保证所有任务都说按照顺序执行
     */
    public static void singleThread(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(()->{
            Thread thread = Thread.currentThread();
            thread.setName("threadlpan1");
            System.out.println("新建线程: "+thread.getName());
        });
        executorService.execute(()->{
            Thread thread = Thread.currentThread();
            long id = thread.getId();
            System.out.println("线程id"+id);
        });
        executorService.shutdown();

        /***
         *  newSingleThreadExecutor(ThreadFactory threadFactory);
         */
        //ExecutorService executorService1 = Executors.newSingleThreadExecutor(new CustomizableThreadFactory());
    }

    /***
     * newCacheThreadPool
     * 创建一个可缓存线程池，如果线程池长度超过处理需要，则可以灵活回收空闲线程，若无可回收，则新建线程
     *  如果线程执行之前  先让线程睡眠  再执行   执行的结果就是 每次都是同一个线程执行任务，
     *                  如果不睡眠  就执行     则执行的任务不是同一个线程。
     *                  线程池无限大，当执行第二个任务时 第一个任务执行完，则复用执行第一个任务的线程，不会每次都创建线程
     */
    public static void cacheThread(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<10;i++){
//            try {
//                Thread.sleep(i*1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            executorService.execute(()->{
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName());
            });
        }
        executorService.shutdown();
    }

    /***
     * 创建一个定长的线程池  可控制线程的最大并发数，超出的线程会存放到队列中等待
     *  线程池大小根据系统进行设置  参考：Runtime.getRuntime().availableProcessors() 值
     *
     */
    public static void fixedThread(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        int i1 = Runtime.getRuntime().availableProcessors();
        System.out.println(i1);
        for (int i=0; i<10;i++){
            executorService.execute(()->{
                Thread thread = Thread.currentThread();
                System.out.println("当前线程："+thread.getName());
            });
        }
        executorService.shutdown();
    }

    /***
     * 创建一个定长线程池 支持定长及周期性任务执行
     *
     *
     */
    public static void scheduledThread(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        /***
         *  延迟执行任务
         *  延迟3秒执行
         */
//        scheduledExecutorService.schedule(() -> {
//            Thread thread = Thread.currentThread();
//            System.out.println("当前线程"+thread.getName());
//        }, 3, TimeUnit.SECONDS);

        /***
         *   延迟周期性执行任务
         *   延迟一秒，每个三秒执行一次
         *   scheduleAtFixedRate(Runable runable，Long initialDelay，Long peroid，TimeUnit timeunit)
         *          initialDelay：延迟时间，period(周期)： 周期
         */
        scheduledExecutorService.scheduleAtFixedRate(()->{
            Thread thread = Thread.currentThread();
            System.out.println("当前线程"+thread.getName());
        },1,3,TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }






}
