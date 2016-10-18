package learn.chapter.concurrent.synchronize;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by @Just on 2016/10/17.
 */
public class WaitAndNotify {
    static boolean flag = true;
    static Object block = new Object();

    static class Wait implements Runnable{

        @Override
        public void run() {
            synchronized (block) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread()+":flag is true");
                        block.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread()+":flag is false");
            }
        }
    }
    static class Notify implements Runnable{
        @Override
        public void run() {
            synchronized (block){
                flag = false;
                block.notify();
                try {
                    TimeUnit.SECONDS.sleep(6);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Thread A = new Thread(new Wait(), "Thread A");
        A.start();
        TimeUnit.SECONDS.sleep(2);
        Thread B = new Thread(new Notify(), "Thread A");
        B.start();

        Lock lock = new ReentrantLock();
    }
}
