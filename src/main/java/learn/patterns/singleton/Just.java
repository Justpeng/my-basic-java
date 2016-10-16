package learn.patterns.singleton;

/**
 * 占位符式，线程安全，但可以被反射修改
 * Created by @Just on 2016/10/13.
 */
public class Just {
    public Just() {
    }
    private static class SingletonHandler{
        private static  final Just INSTANCE = new Just();
    }
    public static Just getInstance() {
        return SingletonHandler.INSTANCE;
    }
}
