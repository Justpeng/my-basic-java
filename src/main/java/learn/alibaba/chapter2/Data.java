package learn.alibaba.chapter2;

import java.awt.*;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.chrono.IsoChronology;
import java.util.Date;

/**
 * Description:
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 05/31/2017-16:51
 */
public class Data {

    public static void main(String[] args) {
          //1 UTC时间
        System.out.println(Date.from(Clock.systemUTC().instant()));
        System.out.println(Date.from(Clock.systemDefaultZone().instant()));
        System.out.println(Date.from(Clock.offset(Clock.system(ZoneId.of(ZoneId.SHORT_IDS.get("JST"))), Duration.ofDays(3L)).instant()));

//        Clock.SystemClock
//
//        System.out.println(ZoneId.getAvailableZoneIds());
//
//        System.out.println(ZoneId.of(ZoneId.SHORT_IDS.get("CTT")));
//        System.out.println(ZoneId.of(ZoneId.SHORT_IDS.get("JST")));
//
//        System.out.println(ZoneId.of(ZoneId.SHORT_IDS.get("CTT")).getRules());
//        System.out.println(ZoneId.of(ZoneId.SHORT_IDS.get("JST")).getRules());
//
//        Clock clock = Clock.system(ZoneId.of(ZoneId.SHORT_IDS.get("CTT")));//上海
//        Clock clock1 = Clock.system(ZoneId.of(ZoneId.SHORT_IDS.get("JST")));//东京
//
//        clock.withZone(ZoneId.of(ZoneId.SHORT_IDS.get("CTT")));
//        clock1.withZone(ZoneId.of(ZoneId.SHORT_IDS.get("JST")));
//        Instant instant = clock.instant();
//        Date date = Date.from(instant);
//
//        System.out.println("上海："+date);
//
//        Instant instant1 = clock1.instant();
//        Date date1 = Date.from(instant1);
//        System.out.println("东京："+date1);







    }
}
