package learn.effective;

import lombok.Data;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Description: 校验出生
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 09/30/2017-08:23
 */
@Data
public class PersonBirth {
    private final Date birthDate;

    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946,Calendar.JANUARY,1,0,0,0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965,Calendar.JANUARY,1,0,0,0);
        BOOM_END = gmtCal.getTime();
    }

    public boolean isBabyBoomer() {
        if (birthDate == null) {
            return false;
        }
        return birthDate.compareTo(BOOM_START)>0 && birthDate.compareTo(BOOM_END)<0;
    }
}