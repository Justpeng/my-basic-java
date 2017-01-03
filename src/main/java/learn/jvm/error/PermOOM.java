package learn.jvm.error;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 持久代异常
 *
 * @author:Just
 * @create:2017-01-02 21:43
 */
public class PermOOM {

    static class PermObj{
    }
    public static void main(String args[]){
        try {
            while (true) {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(PermObj.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhancer.create();
            }
        }catch (Error e){
            throw e;
        }
    }
}
