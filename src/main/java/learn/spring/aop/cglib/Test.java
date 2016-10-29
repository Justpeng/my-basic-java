package spring.aop.cglib;

/**
 * @author:Just
 * @create:2016-10-26 21:43
 */
public class Test {
    public static void main(String args[]){
        Student student = (Student) new CGLibProxyFactory().createStudent(new Student());
        Student student1 = (Student) new CGLibProxyFactory().createStudent(new Student("1"));
        student.print();
        student1.print();
    }
}
