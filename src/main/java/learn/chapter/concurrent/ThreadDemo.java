package learn.chapter.concurrent;

/**
 * Created by @Just on 2016/10/8.
 */
public class ThreadDemo {
    public static void main(String args[]) {
        //三个窗口同时卖票
        new Ticket("窗口A").start();
        new Ticket("窗口B").start();
        new Ticket("窗口C").start();
    }
}

class Ticket extends  Thread{
    int ticket = 5;//总10张票

    public Ticket(String name) {
        setName(name);//线程名称
    }

    public void run() {
        while(ticket>0){
            System.out.println(getName()+"售卖了票"+ticket);
            ticket--;
        }
    }
}