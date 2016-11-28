package learn.concurrency.chapter2;

/**
 * @author:Just
 * @create:2016-11-05 9:37
 */
public class ThreadSafeInit {
    private  static boolean flag = true;
    public ThreadSafeInit(){
        synchronized (ThreadSafeInit.class) {
            if (flag) {
                flag = true;
            }else{
                throw new RuntimeException("");
            }
        }
    }
    private  static class Single{
        private  static  ThreadSafeInit INSTANCE = new ThreadSafeInit();
    }
    public ThreadSafeInit getInstance() {
        return Single.INSTANCE;
    }
}
