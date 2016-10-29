package spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * aop代理类
 *
 * @author:Just
 * @create:2016-10-27 21:59
 */
@Aspect
public class CodeInterceptor {

    // Code实体类的任意方法
    //@Pointcut("execution(* spring.aop.aspect.Code.*(..))")

    //定义切面 Code实体类的 print 方法;                     .. 参数为任意参数
    @Pointcut("execution(* spring.aop.aspect.Code.print(..))")
    public void printMethod() {

    }

    // 前置通知 before于 printMethod切面
    @Before("printMethod()")
    public void printBeforeMethod() {
        System.out.println("beforeMethod");
    }



    //最终通知
    @After("printMethod()")
    public void printFinallyMethod() {
        System.out.println("finallyMethod");
    }


    //后置通知
    @AfterReturning(pointcut = "printMethod()",returning = "code")
    public void printAfterCode(String code) {
        System.out.println("after print return:" +code);
    }

    //环绕通知
    @Around( "printMethod() && args(code)")
    public Object printAroundMethod(ProceedingJoinPoint joinPoint, String code) throws Throwable {
        if(code.equals("test")){
            joinPoint.proceed();
        }else{
            System.out.println("Code.print()方法被拦截");
        }
        System.out.println("aroundMethod");
        return code;
    }
}
