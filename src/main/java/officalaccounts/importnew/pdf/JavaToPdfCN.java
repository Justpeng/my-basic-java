package officalaccounts.importnew.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Description:
 *
 * iText默认是不支持中文的，因此需要添加对应的中文字体,比如黑体simhei.ttf

   可参考文档:http://developers.itextpdf.com/examples/font-examples/using-fonts#1227-tengwarquenya1.java
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 11/09/2017-14:54
 */
public class JavaToPdfCN {
    private static final String FONT = "fonts/simhei.ttf";
    private static final String DEST = "target/HelloWorld_CN.pdf";
    public static void main(String[] args) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(DEST));
            document.open();
            Font f1 = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            document.add(new Paragraph("hello world,我是李朋，欢迎你", f1));
            document.close();
            writer.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
