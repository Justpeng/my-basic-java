package spring.aop.proxy;

/**
 * test
 *
 * @author:Just
 * @create:2016-10-26 20:41
 */
public class ProxyTest {
    public static void main(String args[]){
        StudentInterface studentBean = new StudentBean("1");
        //StudentInterface studentBean1 = new StudentBean();
        StudentInterface studentBean1 = (StudentInterface) new ProxyFactory().createStudentProxy(studentBean);
        //被拦截方法
        studentBean1.print();
    }
}
