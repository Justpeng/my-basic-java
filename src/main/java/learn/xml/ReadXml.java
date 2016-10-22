package learn.xml;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;

import java.util.List;

/**
 * dom4j读取xml
 *
 * @author:Just
 * @create:2016-10-22 15:20
 */
public class ReadXml {
    public static void init(){
        try {
            SAXReader saxReader = new SAXReader();
            File file = new File("out.xml");
            Document document = saxReader.read(file);
            Element rootElement = document.getRootElement();
            List<Object> list = document.selectNodes("//bean");
            for (Object n : list) {
                if(n instanceof Element){
                    Element e = (Element) n;
                    System.out.println(e.valueOf("@name"));
                    List<Object> aList  = e.selectNodes("@class");
                    for(Object a :aList)
                        if(a instanceof Attribute){
                        ((Attribute) a).valueOf()
                            Attribute attribute = (Attribute) a;
                            System.out.println(attribute.getText());

                        }
                }
            }


            //treeWalk(rootElement);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    public static  void treeWalk(Element element) {
        for ( int i = 0, size = element.nodeCount(); i < size; i++ ) {
            Node node = element.node(i);
            if(node instanceof  Element){
                Element e = (Element) node;
                System.out.println(e.attribute("id").getText());
                System.out.println(e.attribute("class").getText());
            }
        }
    }
    public static void main(String args[]){
        init();
    }
}
