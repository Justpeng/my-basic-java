package learn.chapter.Thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by @Just on 2016/10/13.
 */
public class DaemonDemo1 {
    public static void main(String args[]) {
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread t = new Thread(new UserThread());
                t.setDaemon(true);
                t.start();
                try {
                    TimeUnit.MILLISECONDS.sleep(1200);//
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("DaemonThread");
            }
        });
        daemonThread.start();
        Thread daemonThread2 = new Thread(new Runnable() {
            public void run(){
                while(true){
                    try {
                        TimeUnit.MILLISECONDS.sleep(1200);//
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("DaemonThread2");
                }
            }
        });
        daemonThread2.start();
    }
}

class UserThread extends  Thread{
    public void run(){
        while(true){
            System.out.println("用户线程...");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);//如果参数小于0，则不sleep
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
