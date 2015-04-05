/**
 * Created by Dmitry Chernykh on 02.04.2015.
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
        int number = CommonUseLibrary.readUserInput("Метод, который возвращает число, записанное наоборот\nВведите натуральное число n: ");
        System.out.println("Результат: " + reverseNumber(number));
    }
}
