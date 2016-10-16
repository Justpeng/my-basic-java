package learn.chapter.concurrent;

/**
 * Created by @Just on 2016/10/8.
 */
public class RunnableDemo {
    public static void main(String args[]) {
        TicketRun r1 = new TicketRun("C1");
        TicketRun r2 = new TicketRun("C2");
        TicketRun r3 = new TicketRun("C3");

        Thread t1 = new Thread(r1);
        Thread t2 =new Thread(r2);
        Thread t3 = new Thread(r3);
        t1.start();
        t2.start();
        t3.start();

    }
}

class TicketRun implements Runnable {
    int ticket = 5;//总10张票
    String name;
    public TicketRun(String name) {
        this.name = name;//线程名称
    }
    public void run() {
        while(ticket>0){
            System.out.println(name+"售卖了票"+ticket);
            ticket--;
        }
    }
}