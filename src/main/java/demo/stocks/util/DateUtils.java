package demo.stocks.util;

import java.util.Date;

import org.joda.time.DateTime;

/**
 * 
 * @author Irina
 *
 */
public class DateUtils {

	public static Date getPastDateTime(Date date, int minusMinutes) {
        DateTime pastDateTime = new DateTime(date);

        pastDateTime = pastDateTime.minusMinutes(minusMinutes);

        return pastDateTime.toDate();
    }
}
