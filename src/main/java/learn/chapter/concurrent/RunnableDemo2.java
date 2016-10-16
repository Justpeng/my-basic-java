package learn.chapter.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by @Just on 2016/10/8.
 */
public class RunnableDemo2 {
    public static void main(String args[]) {
        TicketData ticketData = new TicketData(10);
        TicketRun2 r = new TicketRun2(ticketData,1);
        TicketRun2 r2 = new TicketRun2(ticketData,2);
        TicketRun2 r3 = new TicketRun2(ticketData,3);
        for(int i=0;i<5;i++){
            new Thread(r).start();
            new Thread(r2).start();
            new Thread(r3).start();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TicketData {
    private int i=0;
    public TicketData(int i){
        this.i = i;
    }
    Lock lock = new ReentrantLock();
    public  synchronized void operate(int num )  {
       // lock.lock();
        if(i>0&& i>=num){
            i -=num;
            System.out.println(Thread.currentThread().getName()+"购票："+ num+",剩余票:"+ (i));
        }else if(i<num){
            System.out.println(Thread.currentThread().getName()+"购票失败："+ num+",剩余票:"+ (i));
        }
       // lock.unlock();
    }
}

class TicketRun2 implements Runnable {
    private  TicketData ticketData;
    private  int num = 0;
    public TicketRun2(TicketData ticketData,int num){
        this.ticketData = ticketData;
        this.num = num;
    }
    public void run() {
        ticketData.operate(num);
    }
}