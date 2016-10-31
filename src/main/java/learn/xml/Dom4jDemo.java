package learn.xml;

import org.dom4j.*;
import org.dom4j.io.*;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * dom4j
 *
 * @author:Just
 * @create:2016-10-22 17:15
 */
public class Dom4jDemo {
    public Document parse(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return  document;
    }

    public Document parse(InputStream in) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(in);
        return  document;
    }


    /**
     * Document对象通过内置方法可以返回标准的java迭代器
     * @param document
     */
    public void bar(Document document){
        Element element = document.getRootElement();

        //root 元素的子元素进行迭代
        for(Iterator i = element.elementIterator();i.hasNext();) {
           Element element1 = (Element) i.next();
            // do something
        }
        //iterate through child elements of root with element name "foo"
        for(Iterator i=element.elementIterator("foo");i.hasNext();) {
            Element foo = (Element) i.next();
            //do something
        }

        // iterate through attribute of root
        for(Iterator i = element.attributeIterator();i.hasNext();) {
            Attribute attribute = (Attribute) i.next();
            // do something
        }

    }

    /**
     * 处理xpath的能力
     * 使用xpath表示要获取节点的路径
     * @param document
     */
    public void bar1(Document document) {
        List list = document.selectNodes("//foo/bar");
        Node node = document.selectSingleNode("//foo/bar/author");
        String name = node.valueOf("@name");
    }

    public void findLinks(Document document) throws DocumentException {

        List list = document.selectNodes( "//a/@href" );

        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            Attribute attribute = (Attribute) iter.next();
            String url = attribute.getValue();
        }
    }

    /**
     * Fast Looping
     * avoids the cost of creating an Iterator Object for each loop
     * @param document
     */
    public  void bar2(Document document){
        Element root = document.getRootElement();
        treeWork(root);
    }

    public void treeWork(Element element) {
        for (int i=0,size = element.nodeCount();i<size;i++){
            Node node = element.node(i);
            if(node instanceof Element){
                treeWork((Element) node);
            }else{
                // do something
            }
        }
    }

    /**
     * 创建一个 xml
     * @return
     */
    public Document createDocument() {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("root");
        Element author1 = root.addElement("author")
                .addAttribute("name", "lip")
                .addText("1323");
        Element author2 = root.addElement("author")
                .addAttribute("name", "lin")
                .addText("4444");
        return  document;
    }

    /**
     *  a quick and easy way to write a Document (or any Node)
     *  via the write() method
     * @param document
     * @throws IOException
     */
    public void write(Document document) throws IOException {
        // write to a file
        FileWriter fileWriter = new FileWriter("out.xml");
        document.write(fileWriter);
    }

    /**
     * If you want to be able to change the format of the output,
     * such as pretty printing or a compact format,
     * or you want to be able to work with Writer objects or OutputStream objects as the destination,
     * then you can use the XMLWriter class.
     * @param document
     * @throws IOException
     */
    public void write1(Document document) throws IOException {

        // write to a file
        XMLWriter writer = new XMLWriter(new FileWriter("out.xml"));
        writer.write(document);
        writer.close();
        // pretty the document to System.out
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        writer = new XMLWriter(System.out, outputFormat);
        writer.write(document);

        // compact format to System.out
        outputFormat = OutputFormat.createCompactFormat();
        writer = new XMLWriter(System.out, outputFormat);
        writer.write(document);

    }

    /**
     * convert from string
     * @param xml
     * @return
     * @throws DocumentException
     */
    public Document convert(String xml) throws DocumentException {
        Document document = DocumentHelper.parseText(xml);
        return  document;
    }

    /**
     * convert to string
     * @param document
     * @return
     * @throws DocumentException
     */
    public String convert(Document document) throws DocumentException {
        String str = document.asXML();
        return str;
    }

    public Document styleDocument(Document document, String stylesheet
) throws Exception {

        // load the transformer using JAXP
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(
                new StreamSource( stylesheet )
        );

        // now lets style the given document
        DocumentSource source = new DocumentSource( document );
        DocumentResult result = new DocumentResult();
        transformer.transform( source, result );

        // return the transformed document
        Document transformedDoc = result.getDocument();
        return transformedDoc;
    }

}

