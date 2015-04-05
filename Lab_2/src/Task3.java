/**
 * Created by Dmitry Chernykh on 02.04.2015.
 */
public class Task3 {

    public static int raiseNumber(int x, int n) {

        return (n > 0) ? raiseNumber(x, --n) * x : 1;

    }

    public static void main(String[] args) {

        int x = CommonUseLibrary.readUserInput("Метод, который возводит число x в степень n через рекурсию\nВведите натуральное число x: ");
        int n = CommonUseLibrary.readUserInput("Введите натуральное число n: ");
        System.out.println("Результат: " + raiseNumber(x, n));

    }
}
