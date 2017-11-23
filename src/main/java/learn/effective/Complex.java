package learn.effective;

import java.util.DoubleSummaryStatistics;
import java.util.Objects;

/**
 * Description: 复杂的final修饰的类
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 10/09/2017-14:10
 */
public final class Complex {
    private final double re;
    private final double im;

    public Complex(double re,double im){
        this.re = re;
        this.im = im;
    }

    public double realPart() {
        return re;
    }
    public double imaginaryPart() {
        return im;
    }

    public Complex subtract(Complex complex) {
        return new Complex(re - complex.re, im - complex.im);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Complex)) {
            return false;
        }
        Complex complex = (Complex) o;
        return Double.compare(re, complex.re) == 0 && Double.compare(im, complex.im) == 0;
    }
}
