package learn.patterns.decorator.iodecorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by @Just on 2016/10/9.
 */
public class UpperCaseInputStream extends FilterInputStream {


    protected UpperCaseInputStream(InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        int c = super.read();
        return c==-1?c:Character.toUpperCase((char)c);
    }

    public int read(byte b[], int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for(int i=0;i<result;i++) {
            b[i]  =(byte) Character.toUpperCase((char)b[i]);
        }
        return result;
    }


}
