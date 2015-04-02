package Lab_2;

/**
 * Created by Windows on 02.04.2015.
 */
public class Task3 {

    public static int raiseNumber(int x, int n){

        return (n > 0) ? raiseNumber(x, --n) * x : 1;

    }

    public static void main(String[] args) {
        System.out.println(raiseNumber(5, 6));
    }
}
