package org.rp.sandboxmvc.helper;

public class TimeInterval {

    public static final int MILLISECOND = 1;
    public static final int SECOND      = 1_000 * MILLISECOND;
    public static final int MINUTE      = 60 * SECOND;
    public static final int HOUR        = 60 * MINUTE;
    public static final int DAY         = 24 * HOUR;
    public static final int WEEK        = 7 * DAY;
    public static final int MONTH       = 30 * DAY;
    public static final int YEAR        = 365 * DAY;

}
