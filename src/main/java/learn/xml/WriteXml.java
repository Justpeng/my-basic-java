package learn.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 写XML
 *
 * @author:Just
 * @create:2016-10-22 15:55
 */
public class WriteXml {
    public static void init() throws IOException {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("beans");
        Element bean = root.addElement("bean")
                .addAttribute("id", "testBean")
                .addAttribute("class","com.just.Test");
        write(document);
    }

    public static void write(Document document) throws IOException {
        //输出到文件 out.xml
        XMLWriter writer = new XMLWriter(new FileWriter("out.xml"));
        writer.write(document);
        writer.flush();
        writer.close();
        System.out.println("------------");
        /**
         * 通过 createPrettyPrint美化输出到控制台
         */
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        writer = new XMLWriter(System.out, outputFormat);
        writer.write(document);
        System.out.println("----------------------------------");
        /**
         * 实现压缩
         */
        outputFormat = OutputFormat.createCompactFormat();
        writer = new XMLWriter(System.out, outputFormat);
        writer.write(document);

    }
    public static void main(String args[]) throws IOException {
        init();
    }
}
