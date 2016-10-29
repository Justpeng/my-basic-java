package spring.aop.aspect_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.aop.aspect.Code;

/**
 * aop测试类
 *
 * @author:Just
 * @create:2016-10-27 22:42
 */
public class Test {
    public static void main(String args[]){
        ApplicationContext act = new ClassPathXmlApplicationContext("spring/aop/aspect_xml/spring_aop.xml");
        AopXml code = (AopXml) act.getBean("aopXml");
        code.print("test");
    }
}
