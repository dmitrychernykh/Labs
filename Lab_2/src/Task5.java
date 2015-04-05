/**
 * Created by Dmitry Chernykh on 02.04.2015.
 */
public class Task5 {

    public static int fibonachiNumber(int n) {

        if (n > 2) return fibonachiNumber(--n) + fibonachiNumber(--n);
        else if (n > 1) return 1;
        else return 0;

    }

    public static void main(String[] args) {

        int x = CommonUseLibrary.readUserInput("Метод, который вычисленяет n-ое по счету число Фибоначчи через рекурсию\nВведите натуральное число: ");
        System.out.println("Результат: " + fibonachiNumber(x));
    }
}
