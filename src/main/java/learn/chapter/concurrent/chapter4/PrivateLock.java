package learn.chapter.concurrent.chapter4;

/**
 * 私有锁保护状态
 *
 * @author:Just
 * @create:2017-01-03 19:00
 */
public class PrivateLock {
    private final Object myLock = new Object();
    Widget widget;
    void someMethod(){
        synchronized (myLock) {
            //doSomething
        }
    }
}
