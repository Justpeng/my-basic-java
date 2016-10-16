package learn.chapter.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by @Just on 2016/10/5.
 */
public class CountDownLatchDemo {
    public static void main(String args[]){
        //3 表示有三个事件发生才会执行该线程
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Racer(countDownLatch, "A").start();
        new Racer(countDownLatch, "B").start();
        new Racer(countDownLatch, "C").start();
        for(int i=0;i<3;i++){
            System.out.println("计数:"+(3-i));
            countDownLatch.countDown();//触发事件
            if(i==2){
                System.out.println("start--");
            }
        }
    }
}

class Racer extends  Thread{
    CountDownLatch countDownLatch;

    public Racer(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        setName(name);
    }

    public void run() {
        try {
            //等待
            countDownLatch.await();
            //执行操作
            System.out.println("执行程序: "+getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
