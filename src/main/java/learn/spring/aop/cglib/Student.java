package spring.aop.cglib;

/**
 * @author:Just
 * @create:2016-10-26 21:35
 */
public class Student {
    private String name;

    public Student() {

    }
    public Student(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("cglib");
    }
}
