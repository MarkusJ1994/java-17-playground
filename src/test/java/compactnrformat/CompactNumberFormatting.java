package compactnrformat;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompactNumberFormatting {

    NumberFormat getInstance(NumberFormat.Style style) {
        return NumberFormat.getCompactNumberInstance(Locale.ENGLISH, style);
    }

    @Test
    public void testCompactNumberFormatting() {
        NumberFormat fmtShort = getInstance(NumberFormat.Style.SHORT);

        assertEquals("1K", fmtShort.format(1000));
        assertEquals("10K", fmtShort.format(10000));
        assertEquals("100K", fmtShort.format(100000));
        assertEquals("1M", fmtShort.format(1000000));

        NumberFormat fmtLong = getInstance(NumberFormat.Style.LONG);

        assertEquals("1 thousand", fmtLong.format(1000));
        assertEquals("10 thousand", fmtLong.format(10000));
        assertEquals("100 thousand", fmtLong.format(100000));
        assertEquals("1 million", fmtLong.format(1000000));
    }

}
