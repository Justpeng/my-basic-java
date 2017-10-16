package learn.patterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by @Just on 2016/10/13.
 */
public class Test {
    public static void main(String args[]) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Just.class;
        Constructor<?> c = clazz.getDeclaredConstructor();
        c.setAccessible(true);
        Just j1 = Just.getInstance();
        Just j2 = (Just) c.newInstance();
        System.out.println(j1==j2);

//        Class<?> clazz1 = JustNoReflect.class;
//        Constructor<?> c1 = clazz1.getDeclaredConstructor(null);
//        c1.setAccessible(true);
//        JustNoReflect j11 = JustNoReflect.getInstance();
//        JustNoReflect j22 = (JustNoReflect) c1.newInstance();
//        System.out.println(j11==j22);


        Class clz = JustEnum.class;
        Constructor<JustEnum> constructor = clz.getConstructor();
        constructor.setAccessible(true);
        constructor.newInstance();
    }





}
