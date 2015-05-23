package ua.org.dmitrychernykh.SkiPassSystem;

/**
 * Enumeration for separating types of ski passes by days of week
 *
 * @author Dmitry Chernykh on 26.04.2015.
 *         project Labs for EPAM courses
 */
public enum PassCardType {
    WORKDAYS(1, 5), HOLIDAYS(6, 7), SEASON(1, 7);

    private int daysFrom, daysTo;

    PassCardType(int newDaysFrom, int newDaysTo) {
        daysFrom = newDaysFrom;
        daysTo = newDaysTo;
    }

    public int getDaysFrom() {
        return daysFrom;
    }

    public int getDaysTo() {
        return daysTo;
    }

}
