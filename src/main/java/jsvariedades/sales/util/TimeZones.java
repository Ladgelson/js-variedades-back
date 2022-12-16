package jsvariedades.sales.util;

import java.time.ZoneId;
import java.util.TimeZone;

public class TimeZones {

    private static final String AMERICA_SAO_PAULO = "GMT-3";

    public static void setDefault() {
        TimeZone.setDefault(TimeZone.getTimeZone(AMERICA_SAO_PAULO));
    }

    public static ZoneId getDefault() {
        return ZoneId.of(AMERICA_SAO_PAULO);
    }
}
