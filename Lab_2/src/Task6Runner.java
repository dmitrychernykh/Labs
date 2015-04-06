/**
 * Created by Dmitry Chernykh on 06.04.2015.
 * Poject Labs for EPAM courses
 */
public class Task6Runner {

    public static void main(String[] args) {

        System.out.println("Lab_2.Task6");
        System.out.println("Метод, который возводит число x в степень n через рекурсию");

        int paramX, paramA;
        double result = 0, checkResult;

        paramX = 144;
        paramA = 3;
        checkResult = 0; //область определения функции все положительные числа
        try {
            result = Task6.calculate(paramX, paramA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Тест 1: (x = " + paramX + ", n = " + paramA + "); Результат: " + result + "; Ожидаемый результат:  Статус: " + (result > checkResult));
        paramX = -144;
        paramA = 5;
        result = 0;
        try {
            result = Task6.calculate(paramX, paramA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Тест 2: (x = " + paramX + ", n = " + paramA + "); Результат: " + result + "; Ожидаемый результат: (ошибка) Статус: " + (result > checkResult));
        paramX = 144;
        paramA = -5;
        result = 0;
        try {
            result = Task6.calculate(paramX, paramA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Тест 3: (x = " + paramX + "); Результат: " + result + "; Ожидаемый результат: Статус: " + (result > checkResult));
        paramX = -144;
        paramA = 3;
        result = 0;
        try {
            result = Task6.calculate(paramX, paramA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Тест 4: (x = " + paramX + ", n = " + paramA + "); Результат: " + result + "; Ожидаемый результат:  Статус: " + (result > checkResult));
        paramX = 0;
        paramA = 5;
        result = 0;
        try {
            result = Task6.calculate(paramX, paramA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Тест 5: (x = " + paramX + ", n = " + paramA + "); Результат: " + result + "; Ожидаемый результат:  (ошибка) Статус: " + (result > checkResult));
        paramX = 1;
        paramA = 15;
        result = 0;
        try {
            result = Task6.calculate(paramX, paramA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Тест 6: (x = " + paramX + ", n = " + paramA + "); Результат: " + result + "; Ожидаемый результат:  (ошибка) Статус: " + (result > checkResult));

        paramX = CommonUseLibrary.readUserInput("Метод, который вычисляет функцию y=log2(x-4)+exp(2a-x), с проверками на область определения, а так же имеет JavaDoc\nВведите число x > 4: ");
        paramA = CommonUseLibrary.readUserInput("Введите число a: ");

        try {
            System.out.println("Результат: " + Task6.calculate(paramX, paramA));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
