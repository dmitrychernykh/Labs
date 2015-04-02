package Lab_2;

/**
 * Created by Windows on 02.04.2015.
 */
public class Task5 {

    public static int fibonachiNumber(int n){

        if (n > 2) return fibonachiNumber(--n) + fibonachiNumber(--n);
        else if (n > 1) return 1;
        else return 0;

    }

    public static void main(String[] args) {
        System.out.println(fibonachiNumber(8));
    }
}
