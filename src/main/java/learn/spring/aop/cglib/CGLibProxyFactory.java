package spring.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author:Just
 * @create:2016-10-26 21:36
 */
public class CGLibProxyFactory implements MethodInterceptor {
    private Object object;

    public Object createStudent(Object object) {
        this.object = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());//为当前类设置父类，即目标类
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Student student = (Student) object;
        Object result = null;
        if (student.getName() == null) {
            System.out.println("代理已经拦截！");
        }else{
            result = methodProxy.invoke(student,args);
        }
        return  result;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
