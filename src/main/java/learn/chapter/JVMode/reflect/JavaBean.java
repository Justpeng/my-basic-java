package learn.chapter.JVMode.reflect;

/**
 * 模拟spring ioc反射原理
 *
 * @author:Just
 * @create:2016-10-16 14:01
 */
public class JavaBean {
    private String name;
    private String password;

    public JavaBean(){

    }
    public JavaBean(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
