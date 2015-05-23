package ua.org.dmitrychernykh.SkiPassSystem.SkiPass;

import ua.org.dmitrychernykh.SkiPassSystem.PassCardType;
import ua.org.dmitrychernykh.SkiPassSystem.PassQuantities;
import ua.org.dmitrychernykh.SkiPassSystem.PassTimePeriods;

/**
 * Realizes factory singleton that making skipass cards
 *
 * @author Created by Dmitry Chernykh on 05.05.2015.
 *         Project Labs for EPAM courses
 */
public class SkiPassFactory {
    private static SkiPassFactory ourInstance = new SkiPassFactory();

    private SkiPassFactory() {
    }

    public static SkiPassFactory getInstance() {
        return ourInstance;
    }

    /**
     * Creates new ski pass that have quantity of passes
     */
    public SkiPass getNewSkiPass(PassCardType newType, PassQuantities p) {
        return new SkiPassByCount(newType, p);
    }

    /**
     * Creates new ski pass that have time period of work
     */
    public SkiPass getNewSkiPass(PassCardType newType, PassTimePeriods p) {
        return new SkiPassByTime(newType, p);
    }

    /**
     * returns rejected ski pass
     */
    public SkiPass getRejectedSkiPass() {
        return SkiPassRejected.getInstanse();
    }
}
