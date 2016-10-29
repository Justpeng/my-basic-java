package spring.aop.aspect;

/**
 * aop目标对象
 *
 * @author:Just
 * @create:2016-10-27 21:59
 */
public class Code {
    public String print(String code) {
        System.out.println("目标类方法执行了.");
        return code;
    }
}
