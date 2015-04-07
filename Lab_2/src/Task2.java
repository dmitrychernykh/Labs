/**
 * Created by Dmitry Chernykh on 02.04.2015.
 */
public class Task2 {
    public static int reverseNumber(int value) {

        if (value > -10 && value < 10) return value;

        final int TEN = 10;

        int minus = 1;

        if (value < 0) minus = -1;

        value *= minus;

        int result = 0;
        int delimiter = 10;
        do {
            result *= TEN;
            result += value % delimiter / (delimiter / TEN);
            delimiter *= 10;
            if (value % delimiter == value) {
                result *= TEN;
                result += value % delimiter / (delimiter / TEN);
            }
        } while (value % delimiter != value);

        value *= minus;

        return result * minus;
    }
}

