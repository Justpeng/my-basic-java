package officalaccounts.importnew.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Description: Java转为PDF
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 11/09/2017-14:46
 */
public class JavaToPdf {
    private static final String DEST = "target/HelloWorld.pdf";

    public static void main(String[] args) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(DEST));
            document.open();
            document.add(new Paragraph("hello world"));
            document.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
