package learn.chapter.concurrent.chapter4;

/**
 * 可变的线程安全Point类
 * @author:Just
 * @create:2017-01-03 22:49
 */
public class SafePoint {
    private int x,y;

    private SafePoint(int a[]) {
        this(a[0],a[1]);
    }
    public SafePoint(SafePoint point) {
        this(point.get());
    }

    public SafePoint(int x,int y){
        this.x=x;
        this.y=y;
    }

    //get方法，可以一次获得x与y的值，并返回一个二元数组
    public synchronized int[] get(){
        return new int[]{x, y};
    }

    public synchronized void set(int x, int y) {
        this.x=x;
        this.y=y;
    }



}
