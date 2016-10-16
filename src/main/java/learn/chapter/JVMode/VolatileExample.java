package learn.chapter.JVMode;

/**
 * Created by sysware.com on 2016/9/26.
 */
public class VolatileExample {
    static int  i = 0;
    volatile static  boolean flag = false;

    public static void writer(){
        i = 1;
        flag = true;
    }

    public  static void reader(){
        System.out.println("- - - - lip - - - - flag 值=" + flag  + ",当前类=VolatileExample.reader()");
        if(flag){
            System.out.println("- - - - lip - - - - i值=" + i + ",当前类=VolatileExample.reader()");
        }
    }

    public static  void main(String args[]){
        MyReadThread r1 = new MyReadThread();
        r1.start();
        MyWriteThread w1 = new MyWriteThread();
        w1.start();
    }




}

class MyReadThread extends  Thread{
    public void run(){
        System.out.println("- - - - lip - - - -read ,当前类=MyReadThread.run()");
        VolatileExample.reader();
    }
}

class MyWriteThread extends  Thread{
    public void run(){
        System.out.println("- - - - lip - - - -write ,当前类=MyReadThread.run()");

        VolatileExample.writer();
    }
}