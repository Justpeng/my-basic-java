package learn.chapter.concurrent.chapter4;

/**
 * 不可变的Point
 * 线程安全，可自由发布与共享
 * @author:Just
 * @create:2017-01-03 22:05
 */
public class Point {
    private final int x,y;
    public Point(int x, int y) {
        this.x=x;
        this.y=y;
    }
}
