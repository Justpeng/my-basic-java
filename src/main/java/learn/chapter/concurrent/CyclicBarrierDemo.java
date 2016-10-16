package learn.chapter.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by @Just on 2016/10/5.
 */
public class CyclicBarrierDemo {
    public static void main(String args[]) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("Game start");
            }
        });
        new Player(cyclicBarrier,"A").start();
        new Player(cyclicBarrier,"B").start();
        new Player(cyclicBarrier,"C").start();


    }
}

class Player extends Thread{
    CyclicBarrier cyclicBarrier;

    public Player(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        setName(name);
    }
    public void run(){
        System.out.println(getName()+"等待");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

}