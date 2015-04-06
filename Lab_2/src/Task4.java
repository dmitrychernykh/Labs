/**
 * Created by Dmitry Chernykh on 02.04.2015.
 */
public class Task4 {

    public static int factorialNumber(int n) {

        if (n < 0 || n > 12) return -1;

        return n > 1 ? factorialNumber(--n) * (++n) : n;

    }

}
