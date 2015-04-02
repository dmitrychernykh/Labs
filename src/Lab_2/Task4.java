package Lab_2;

/**
 * Created by Windows on 02.04.2015.
 */
public class Task4 {

    public static int factorialNumber(int n){

        return n > 1 ? factorialNumber(--n) * (++n) : n;

    }

    public static void main(String[] args) {
        System.out.println(factorialNumber(12));
    }
}
