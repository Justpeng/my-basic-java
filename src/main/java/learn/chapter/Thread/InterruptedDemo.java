package learn.chapter.Thread;

/**
 * Created by @Just on 2016/10/13.
 */
public class InterruptedDemo {
    public static void main(String args[]) {
        Thread t = new Thread(new ThreadDemo());
        t.start();

        System.out.println("线程t开始，中断标志："+ t.isInterrupted());//false
        //中断线程
        t.interrupt();
        System.out.println("线程t中断标志:："+ t.isInterrupted());//true
        try {
            //模拟 t 抛出异常后中断标志是否消失
            Thread.sleep(2000);
            System.out.println("线程t处理异常后,中断标志："+ t.isInterrupted());//false
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadDemo extends Thread {
    public void run() {
        try {
            System.out.println("开始方法...");
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            System.out.println("线程被中断");
            e.printStackTrace();
        }
        System.out.println("结束方法...");
    }
}
