package ua.org.dmitrychernykh.SkiPassSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Stores the rule of card duration
 *
 * @author Dmitry Chernykh on 26.04.2015.
 *         project Labs for EPAM courses
 */
public class CardPeriod {

    public static final int HOUR_OF_DAY_START = 9;
    public static final int HOUR_OF_DAY_FINISH = 17;
    public static final int HOUR_OF_DAY_MIDDLE = 13;


    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd MMM uuuu");

    private LocalDateTime from, to;
    private int daysFrom = 1, daysTo = 7;

    /**
     * Creates new object with date and time restriction
     */
    public CardPeriod(LocalDateTime newFrom, LocalDateTime newTo) {
        from = newFrom;
        to = newTo;

    }

    /**
     * Creates new object with date, time and days of week restriction
     */
    public CardPeriod(LocalDateTime newFrom, LocalDateTime newTo, int newDaysFrom, int newDaysTo) {
        from = newFrom;
        to = newTo;
        daysFrom = newDaysFrom;
        daysTo = newDaysTo;
    }

    /**
     * Checking that the date is in period of card duration
     *
     * @param chekingDate the date and time that must be checked, check when pass
     */
    public boolean dateInPeriod(LocalDateTime chekingDate) {
        int dow = chekingDate.getDayOfWeek().getValue();
        return from.isBefore(chekingDate) &&
                to.isAfter(chekingDate) &&
                dow >= daysFrom &&
                dow <= daysTo &&
                chekingDate.getHour() >= HOUR_OF_DAY_START &&
                chekingDate.getHour() < HOUR_OF_DAY_FINISH;
    }

    @Override
    public String toString() {
        return "Period{" + DATE_FORMAT.format(from) + " - " + DATE_FORMAT.format(to) + '}';
    }
}
