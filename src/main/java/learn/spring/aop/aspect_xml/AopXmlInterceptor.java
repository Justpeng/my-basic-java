package spring.aop.aspect_xml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * aop代理类
 *
 * @author:Just
 * @create:2016-10-27 21:59
 */

public class AopXmlInterceptor {


    public void printMethod() {}
    public void printBeforeMethod() {
        System.out.println("beforeMethod");
    }
    public void printFinallyMethod() {
        System.out.println("finallyMethod");
    }
    public void printAfterCode(String name) {
        System.out.println("after print return:" +name);
    }
    public Object printAroundMethod(ProceedingJoinPoint joinPoint, String name) throws Throwable {
        if(name.equals("test")){
            joinPoint.proceed();
        }else{
            System.out.println("Code.print()方法被拦截");
        }
        System.out.println("aroundMethod");
        return name;
    }
}
