package learn.chapter.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Created by @Just on 2016/10/5.
 */
public class SemaphoreDemo {
    public static void main(String args[]){
        //创建2个信号量，有三个对象要使用
        Semaphore semaphore = new Semaphore(2);
        new Person(semaphore,"A").start();
        new Person(semaphore,"B").start();
        new Person(semaphore,"C").start();
    }
    
    
    
}

class Person extends Thread{
    private Semaphore semaphore;
    public Person(Semaphore semaphore,String name){
        this.semaphore = semaphore;
        setName(name);
    }
    public void run(){
        System.out.println(getName() + " is waiting");
        try {
            //获取信号量
            semaphore.acquire();//默认获取一个
            System.out.println(getName()+" is serving");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName()+" is done.");
        semaphore.release();//释放信号量
    }
}