package learn.chapter.JVMode.reflect;

/**
 * 类装载器
 *
 * @author:Just
 * @create:2016-10-16 9:16
 */
public class ClassLoaderTest {
    public static void main(String args[]){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("current:"+classLoader);
        System.out.println("current_parent:"+classLoader.getParent());
        System.out.println("current_parent_parent:"+classLoader.getParent().getParent());
    }
}
