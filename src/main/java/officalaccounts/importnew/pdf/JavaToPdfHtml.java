package officalaccounts.importnew.pdf;

/**
 * Description: java2HTML
 *
 *  在一些比较复杂的pdf布局中，我们可以通过html去生成pdf

  可参考文档:http://developers.itextpdf.com/examples/xml-worker-itext5/xml-worker-examples

     1.html中必须使用标准的语法，标签一定需要闭合
     2.html中如果有中文，需要在样式中添加对应字体的样式
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 11/09/2017-15:24
 */
public class JavaToPdfHtml {
    private static final String DEST = "target/HelloWorld_CN_HTML.pdf";
    private static final String HTML = "template.html";
    private static final String FONT = "simhei.ttf";


}
