package spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂类
 *
 * @author:Just
 * @create:2016-10-26 20:35
 */
public class ProxyFactory implements InvocationHandler {

    private Object student;
    public Object createStudentProxy(Object student){
        this.student = student;
        return Proxy.newProxyInstance(student.getClass().getClassLoader(), student.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        StudentBean studentBean = (StudentBean) student;
        if(studentBean.getName()==null){
            System.out.println("代理已拦截");
        }else{
            object =  studentBean;
        }
        return object;
    }
}
