package learn.chapter.Thread;

/**
 * Created by @Just on 2016/10/13.
 */
public class InterruptDemo2 {
    public static void main(String args[]) {
        System.out.println("A:"+Thread.interrupted());
        Thread.currentThread().yield();
        System.out.println("B:"+Thread.interrupted());
        System.out.println("C:"+Thread.interrupted());
        System.out.println("D:"+Thread.interrupted());
    }
}
