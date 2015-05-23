package ua.org.dmitrychernykh.SkiPassSystem;

/**
 * Enumeration for separating types of quantities of passes
 *
 * @author Dmitry Chernykh on 26.04.2015.
 *         project Labs for EPAM courses
 */
public enum PassQuantities {
    TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100);

    private int count;

    PassQuantities(int newCount) {
        count = newCount;
    }

    public int getCount() {
        return count;
    }

}
