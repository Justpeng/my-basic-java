package learn.chapter.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by @Just on 2016/10/13.
 */
public class DaemonThread3 {
    public static void main(String args[]) {
        Thread mainTh = new Thread(new Runnable() {
            @Override
            public void run() {

                ExecutorService exec = Executors.newCachedThreadPool();
                Thread childThread = new Thread(new UserThread2());
                childThread.setDaemon(true);
                exec.execute(childThread);
                exec.shutdown();
                System.out.println("main..............");
            }
        });
        mainTh.start();
    }
}

class UserThread2 implements Runnable{
    public void run(){
        while(true){
            try {
                System.out.println("用户线程...");
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}