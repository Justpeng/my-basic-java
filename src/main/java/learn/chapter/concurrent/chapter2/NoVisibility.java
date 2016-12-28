package learn.chapter.concurrent.chapter2;

/**
 * 共享变量
 *
 * @author:Just
 * @create:2016-12-26 21:59
 */
public class NoVisibility {
    public static boolean read;
    public static int number;

    public static class ReaderThread extends Thread{
        public void run(){
            while(!read){
                Thread.yield();
                System.out.println(number);
            }
        }
    }
    public static void main(String args[]){
        new ReaderThread().start();
        read = true;
        number=10;
    }
}
