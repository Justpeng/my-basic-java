package learn.chapter.concurrent.chapter4;

/**
 * 机车位置
 * //不是线程安全的
 * @author:Just
 * @create:2017-01-03 19:14
 */
public class MutablePoint {
    public int x,y;
    public MutablePoint(){
        x=0;
        y=0;
    }
    public MutablePoint(MutablePoint p){
        this.x=p.x;
        this.y=p.y;
    }
}
