package learn.patterns.decorator.iodecorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by @Just on 2016/10/9.
 */
public class Test {
    public static void main(String args[]) throws IOException {
        int c;
        InputStream in = new UpperCaseInputStream(new BufferedInputStream(new FileInputStream("D://test.txt")));
        while((c=in.read())>0){
            System.out.print((char)c);
        }
    }
}
