package learn.patterns.singleton;

/**
 * Created by @Just on 2016/10/13.
 */
public class JustNoReflect {
    private static boolean flag = false;
    public JustNoReflect() {
        synchronized (JustNoReflect.class){
            if(!flag){
                flag = !flag;
            }else{
                throw new RuntimeException("被反射入侵了！");
            }
        }
    }
    private static class Singleton {
         private static final JustNoReflect INSTANCE = new JustNoReflect();
    }
    public static JustNoReflect getInstance(){
        return Singleton.INSTANCE;
    }


}
