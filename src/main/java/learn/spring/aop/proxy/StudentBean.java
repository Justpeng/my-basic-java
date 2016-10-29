package spring.aop.proxy;

/**
 * s
 *
 * @author:Just
 * @create:2016-10-26 20:17
 */
public class StudentBean implements StudentInterface {
    private String name;
    public StudentBean() {

    }
    public StudentBean(String name) {
        this.name = name;
    }
    @Override
    public void print() {
        System.out.println("StudentBean");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
