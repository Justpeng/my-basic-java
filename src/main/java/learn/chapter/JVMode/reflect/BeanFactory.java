package learn.chapter.JVMode.reflect;


import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.IntrospectionException;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 反射实例化工厂
 *
 * @author:Just
 * @create:2016-10-16 14:04
 */
public class BeanFactory {

    private Map<String,Object> beanMap = new HashMap<String,Object>();

    public void  init(String xml) {
        try{
            //1创建读取配置文件的reader对象
            SAXReader reader = new SAXReader();
            //2获取类加载器
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            //3获取文件
            java.io.InputStream inputStream = loader.getResourceAsStream(xml);
            //
            Document doc = reader.read(inputStream);
            Element root = doc.getRootElement();
            Element foo;

            //4遍历获取xml中bean实  例
            for (Iterator i = root.elementIterator("bean"); i.hasNext();){
                foo = (Element) i.next();
                //5针对每一个bean实例获取id和name属性
                Attribute id = foo.attribute("id");
                Attribute clazz = foo.attribute("class");

                //6利用反射，通过class名称获取class对象
                Class bean = Class.forName(clazz.getText());
                //7 获取对应class信息
                java.beans.BeanInfo info = java.beans.Introspector.getBeanInfo(bean);
                //8获取其属性信息
                java.beans.PropertyDescriptor pd[] = info.getPropertyDescriptors();

                //9创建一个对象，并按照接下来的代码为对象的属性赋值
                Object obj = bean.newInstance();
                //10.遍历该bean的property属性property
                for(Iterator it  = foo.elementIterator("property");it.hasNext();) {
                    Element pro = (Element) it.next();
                    //11获取property name属性
                    Attribute name = pro.attribute("name");
                    String value = null;
                    //12获取子元素value值
                    for(Iterator v = pro.elementIterator("value");v.hasNext();) {
                        Element node = (Element) v.next();
                        value = node.getText();
                        break;
                    }
                    //13利用Java的反射机制调用对象的某个set方法，并将值设置进去
                    for(int k = 0;k<pd.length;k++) {
                        if(pd[k].getName().equalsIgnoreCase(name.getText())){
                            Method method = null;
                            method = pd[k].getWriteMethod();
                            method.invoke(obj, value);
                        }
                    }
                }
                beanMap.put(id.getText(),obj);
              }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String beanName) {
        Object obj = beanMap.get(beanName);
        return obj;
    }

    public static void main(String args[]){
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.init("learn/chapter/JVMode/reflect/config/beanConfig.xml");
        JavaBean javaBean = (JavaBean) beanFactory.beanMap.get("javaBean");
        System.out.println("name=" + javaBean.getName());
        System.out.println("password=" + javaBean.getPassword());
    }
}
