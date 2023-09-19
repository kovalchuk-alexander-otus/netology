package ru.maki;

import java.util.Random;

public class MyThread {
    Random random = new Random();
    int ms;

    public MyThread(int ms) {
        this.ms = ms;
    }

    public Thread start(ThreadGroup threadGroup){
        Thread thread = new Thread(threadGroup,()->{
            if(Thread.currentThread().isInterrupted()) return;
            while(true){
                System.out.printf("%d\n", random.nextInt(100));
                try {
                    Thread.sleep(this.ms);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
        return thread;
    }

}
