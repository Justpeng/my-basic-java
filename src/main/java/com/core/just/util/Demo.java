package com.core.just.util;

/**
 * @author:Just
 * @create:2016-12-17 16:15
 */
public class Demo {
    private String name;
    private int age;
    private double salary;

    public String toString(){
        return getClass().getName() + "[name=" + name + ",age=" + age + "]";
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (object instanceof Demo) {
            Demo demo = (Demo) object;
            return demo.name == name && demo.age == age;
        }else{
            return false;
        }
    }

    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime*result +age;
        result = prime*result + (name==null?0:name.hashCode());
        long temp = Double.doubleToLongBits(salary);
        return result;

    }

}
