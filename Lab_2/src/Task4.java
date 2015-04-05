/**
 * Created by Dmitry Chernykh on 02.04.2015.
 */
public class Task4 {

    public static int factorialNumber(int n) {

        return n > 1 ? factorialNumber(--n) * (++n) : n;

    }

    public static void main(String[] args) {

        int x = CommonUseLibrary.readUserInput("Метод, который вычисленяет факториал числа n через рекурсию\nВведите натуральное число: ");
        System.out.println("Результат: " + factorialNumber(x));
    }
}
