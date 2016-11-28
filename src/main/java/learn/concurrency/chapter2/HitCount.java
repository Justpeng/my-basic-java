package learn.concurrency.chapter2;

/**
 * @author:Just
 * @create:2016-11-05 9:17
 */
public class HitCount {
    private long count = 0;
    public long getCount() {
        return count;
    }
    public void print(){
        count ++;
    }
}
