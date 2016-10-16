package learn.chapter.JVMode;

/**
 * Created by sysware.com on 2016/9/26.
 */
public class VolatielFeaturesExample {
//    volatile static long v=0L;
    volatile static long v=0L;

    public static void set(long l){
        v = l;
    }

    public  static  void getAndIncrement(){
        v++;
    }

    public static  long get(){
        return v;
    }


}
