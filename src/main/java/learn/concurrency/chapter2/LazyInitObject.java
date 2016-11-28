package learn.concurrency.chapter2;

/**
 * @author:Just
 * @create:2016-11-05 9:30
 */

public class LazyInitObject {
    private  LazyInitObject instance ;

    public LazyInitObject(){
    }
    public LazyInitObject getInstance(){
        if (instance == null) {
            instance  = new LazyInitObject();
        }
        return  instance;
    }
}
