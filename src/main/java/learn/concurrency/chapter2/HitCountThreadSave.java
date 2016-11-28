package learn.concurrency.chapter2;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author:Just
 * @create:2016-11-05 9:45
 */
public class HitCountThreadSave {
    private final AtomicLong count = new AtomicLong(0);
    public long getCount() {
        return count.get();
    }
    public void print(){
        count.incrementAndGet();
    }
}
