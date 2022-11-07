package dayperiod;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayPeriodTest {

    //With english default locale
    static String MORNING = "in the morning";
    static String NOON = "noon";
    static String AFTERNOON = "in the afternoon";
    static String EVENING = "in the evening";
    static String NIGHT = "at night";
    static String MIDNIGHT = "midnight";

    @Test
    public void testDayPeriod() {
        //B is the new formatting flag
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("B", Locale.ENGLISH);

        assertEquals(dtf.format(LocalTime.of(0, 0)), MIDNIGHT);
        assertEquals(dtf.format(LocalTime.of(0, 1)), NIGHT);
        assertEquals(dtf.format(LocalTime.of(5, 59)), NIGHT);
        assertEquals(dtf.format(LocalTime.of(6, 0)), MORNING);
        assertEquals(dtf.format(LocalTime.of(11, 59)), MORNING);
        assertEquals(dtf.format(LocalTime.of(12, 0)), NOON);
        assertEquals(dtf.format(LocalTime.of(12, 1)), AFTERNOON);
        assertEquals(dtf.format(LocalTime.of(17, 59)), AFTERNOON);
        assertEquals(dtf.format(LocalTime.of(18, 0)), EVENING);
        assertEquals(dtf.format(LocalTime.of(20, 59)), EVENING);
        assertEquals(dtf.format(LocalTime.of(21, 0)), NIGHT);
        assertEquals(dtf.format(LocalTime.of(23, 59)), NIGHT);
    }

}
