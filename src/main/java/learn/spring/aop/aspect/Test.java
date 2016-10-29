package spring.aop.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * aop测试类
 *
 * @author:Just
 * @create:2016-10-27 22:42
 */
public class Test {
    public static void main(String args[]){
        ApplicationContext act = new ClassPathXmlApplicationContext("spring/aop/aspect/spring_aop.xml");
        Code code = (Code) act.getBean("code");
        code.print("test1");
    }
}
