package Lab_2;

/**
 * Created by Windows on 02.04.2015.
 */
public class Task1 {
    public static int countNumbers(int value){

        int result = 1;
        int delimiter = 1;
        while (value / (delimiter *= 10) != 0)
            result ++;

        return result;

    }

    public static void main(String[] args) {
        System.out.println(countNumbers(-122));
    }
}
