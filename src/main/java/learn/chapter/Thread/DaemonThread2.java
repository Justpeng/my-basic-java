package learn.chapter.Thread;

import java.util.concurrent.TimeUnit;

/**
 * 使用主线程中断用户线程
 * Created by @Just on 2016/10/13.
 */
public class DaemonThread2 {
    public static void main(String args[]) {
        Thread mainThread  = new Thread(new Runnable() {
            @Override
            public void run() {
                UserDemo2 u = new UserDemo2(Thread.currentThread());
                Thread t = new Thread(u);
                t.setDaemon(false);
                t.start();
                try
                {
                    TimeUnit.MILLISECONDS.sleep(10000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("main start");
            }
        });
        mainThread.start();
    }
}

class UserDemo2 implements Runnable{
    private Thread thread;

    public UserDemo2(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        while (thread.isAlive()) {
            System.out.println("UserDemo2");
            try
            {
                TimeUnit.MILLISECONDS.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("main over....");
    }
}
