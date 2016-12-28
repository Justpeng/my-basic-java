package learn.chapter.concurrent.chapter2;

/**
 * @author:Just
 * @create:2016-12-26 22:14
 */
public class SynchronizedInteger {
    private int value;
    public synchronized  int get() {
        return value;
    }
    public synchronized void set(int value) {
        this.value = value;
    }
}
