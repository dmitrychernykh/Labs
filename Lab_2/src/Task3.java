/**
 * Created by Dmitry Chernykh on 02.04.2015.
 */
public class Task3 {

    public static int raiseNumber(int x, int n) {

        if (x == 0 || x == 1) return x;

        if (n < 0) return -1;

        return (n > 0) ? raiseNumber(x, --n) * x : 1;

    }

}

