/**
 * Created by Dmitry Chernykh on 02.04.2015.
 * <p/>
 * This method returns result of function y=log2(x-4)+exp(2a-x) calculation
 * <p/>
 * Tip: enter argument x bigger then 4
 */
public class Task6 {

    /**
     * calculates function y=log2(x-4)+exp(2a-x)
     *
     * @param x x value
     * @param a a value
     * @return log2(x-4)+exp(2a-x).
     */
    public static double calculate(int x, int a) {

        if (x <= 4) throw new IllegalArgumentException("Аргумент не соответствует области определения фукнции");

        double result;

        result = Math.log10(x - 4) / Math.log10(2) + Math.exp((double) Math.multiplyExact(2, a) - x);

        return result;

    }

    public static void main(String[] args) {

        int x = CommonUseLibrary.readUserInput("Метод, который вычисленяет функцию y=log2(x-4)+exp(2a-x), с проверками на область определения, а так же имеет JavaDoc\nВведите число x > 4: ");
        int a = CommonUseLibrary.readUserInput("Введите число a: ");

        System.out.println("Результат: " + calculate(x, a));
    }
}
