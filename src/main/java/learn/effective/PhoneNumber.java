package learn.effective;

import org.jetbrains.annotations.NotNull;

/**
 * Description: equals,hashCode,clone
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 10/01/2017-20:45
 */
public final class PhoneNumber implements Comparable<PhoneNumber>{
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    private volatile int hashCode;


    public PhoneNumber(int areaCode,int prefix,int lineNumber) {
        rangeCheck(areaCode,999,"areaCode");
        rangeCheck(prefix,999,"prefix");
        rangeCheck(lineNumber,9999,"line number");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max) {
            throw new IllegalArgumentException(name + ":" + arg);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber phoneNumber = (PhoneNumber) o;
        return this.areaCode == phoneNumber.areaCode
                && this.prefix==phoneNumber.prefix
                && this.lineNumber == phoneNumber.lineNumber;
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31*result+areaCode;
            result = 31*result+prefix;
            result = 31*result+lineNumber;
            hashCode = result;
        }

        return result;
    }

    @Override
    public int compareTo(@NotNull PhoneNumber o) {
        int areaCodeDiff = areaCode - o.areaCode;
        if (areaCodeDiff != 0) {
            return areaCodeDiff;
        }
        int prefixCodeDiff = prefix - o.prefix;
        if (prefixCodeDiff != 0) {
            return prefixCodeDiff;
        }
        return lineNumber - o.lineNumber;
    }
}
