package learn.patterns.singleton;

/**
 * Created by @Just on 2016/10/13.
 */
public class JustDemo {
    private  static  boolean flag = true;

    public JustDemo() {
        synchronized (JustDemo.class){
            if(flag){
                flag = false;
            }else{
                throw new RuntimeException("反射入侵已阻止");
            }
        }
    }

    private static class Single{
        private static final JustDemo INSTANCE = new JustDemo();
    }

    public JustDemo getInstance() {
        return Single.INSTANCE;
    }








}
