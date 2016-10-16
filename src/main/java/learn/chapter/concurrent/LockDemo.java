package learn.chapter.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by @Just on 2016/10/5.
 */
public class LockDemo {
    public static void main(String args[]) {
           new AddData().start();
    }
}

class Data {
    static int i=0;
    static  Lock lock = new ReentrantLock();
    static AtomicInteger ai = new AtomicInteger(0);
    static void operate( ){
        System.out.println("ai:"+ai.getAndIncrement());//与变量i无关
//        lock.lock();
//        i++;
//        System.out.println("i:"+i);
//        lock.unlock();
    }
}

class AddData extends Thread{
    @Override
    public void run() {
       while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Data.operate();
       }
    }
}

