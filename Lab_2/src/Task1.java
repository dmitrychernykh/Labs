/**
 * Created by Dmitry Chernykh on 02.04.2015.
 */
public class Task1 {

    public static int countNumbers(int value) {

        int result = 1;
        int delimiter = 1;
        while (value / (delimiter *= 10) != 0)
            result++;

        return result;

    }

}

