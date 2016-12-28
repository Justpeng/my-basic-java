package learn.chapter.JVMode.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 反射测试
 *
 * @author:Just
 * @create:2016-10-15 23:51
 */
public class ReflectTest {
    public static Car initByDefaultConst() throws Throwable{
        //通过类装载器获取Car
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class actionClass = classLoader.loadClass("chapter.JVMode.reflect.Car");

        //获取默认构造器对象，实例化Car对象
        Constructor constructor = actionClass.getDeclaredConstructor((Class[]) null);
        Car car = (Car) constructor.newInstance();
            constructor.setAccessible(true);
        //反射获取方法设置属性
        Method brandMethod = actionClass.getMethod("setBrand", String.class);
        brandMethod.invoke(car, "奔驰");
        Method colorMethod = actionClass.getMethod("setColor", String.class);
        colorMethod.invoke(car, "red");
        Method speedMethod = actionClass.getMethod("setMaxSpeed", int.class);
        speedMethod.invoke(car, 222);


        Object obj = actionClass.newInstance();

        actionClass.getDeclaredMethods();


        return car;
    }

    public static Car initByDefaultParams() throws Throwable {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("chapter.JVMode.reflect.Car");
        Constructor constructor = clazz.getDeclaredConstructor(new Class[]{String.class,String.class,int.class});

        Car car = (Car) constructor.newInstance(new Object[]{"宝马","白色",122});
        return car;
    }
    public static void main(String args[]) throws Throwable {
        Car car  = initByDefaultConst();
        Car car1 = initByDefaultParams();
        car.introduce();
        car1.introduce();

        Class.forName("ff");


    }
}
