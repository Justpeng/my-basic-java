package learn.chapter.concurrent;

import java.util.concurrent.Phaser;

/**
 * Created by @Just on 2016/10/5.
 */
public class PhaserDemo {
    public static void main(String args[]) {
        Phaser phaser = new Phaser(1);
        System.out.println("starting...");
        //假设每个订单有三道工序
        new Worker(phaser,"worker1").start();//执行等待
        new Worker(phaser, "worker2").start();
        new Worker(phaser,"worker3").start();
        //处理三个订单
        for(int i=0;i<3;i++) {
            //处理完每一个订单都要等待，相当于开始执行下一个订单
            phaser.arriveAndAwaitAdvance();
        }
        //所有订单处理完毕，接触在phaser上注册的所有worker
        phaser.arriveAndDeregister();
        System.out.println("all done...");
    }
}

class Worker extends Thread{
    Phaser phaser;
    public Worker(Phaser phaser,String name){
        this.phaser = phaser;
        setName(name);
        phaser.register();//当当前线程注册到phaser中
    }
    public void run(){
        //模拟三个订单
        for(int i=1;i<=3;i++){
            System.out.println("current order:"+i+":"+getName());
            if(i==3){
                //如果是第三个订单，即所有订单都处理完毕，注销phaser
                phaser.arriveAndDeregister();
            }else{//否则，执行等待
                phaser.arriveAndAwaitAdvance();
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
