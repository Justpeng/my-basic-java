package learn.chapter.concurrent;

import java.util.concurrent.Exchanger;

/**
 * Created by @Just on 2016/10/5.
 */
public class ExchangerDemo {
    public static void main(String args[]) {
        Exchanger<String> ex = new Exchanger<>();
        new A(ex).start();
        new B(ex).start();
    }
}

class A extends Thread{
    Exchanger<String> ex;
    public A(Exchanger ex){
        this.ex = ex;
    }
    public void run(){
        String str;
        try {
            str = ex.exchange("hello");
            System.out.println("A ex:"+str);

            str = ex.exchange("this is A");
            System.out.println("A ex:"+ str);

            str = ex.exchange("this is A1");
            System.out.println("A ex:"+ str);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B extends Thread{
    Exchanger<String> ex;
    public B(Exchanger ex){
        this.ex = ex;
    }
    public void run(){
        String str;
        try {
            str = ex.exchange("hI");
            System.out.println("B ex:"+str);

            str = ex.exchange("this is B");
            System.out.println("B ex:"+ str);

            str = ex.exchange("this is B1");
            System.out.println("B ex:"+ str);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
