package Lab_2;

/**
 * Created by Windows on 02.04.2015.
 */
public class Task2 {
    public static int reverseNumber(int value){

        final int TEN = 10;

        int result = 0;
        int delimiter = 10;
        do{
            result *= TEN;
            result += value % delimiter / (delimiter / TEN);
            delimiter *= 10;
            if(value % delimiter == value){
                result *= TEN;
                result += value % delimiter / (delimiter / TEN);
            }
        } while (value % delimiter != value);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseNumber(1101));
    }
}
