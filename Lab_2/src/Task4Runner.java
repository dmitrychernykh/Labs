/**
 * Created by Dmitry Chernykh on 06.04.2015.
 * Poject Labs for EPAM courses
 */
public class Task4Runner {
    public static void main(String[] args) {

        System.out.println("Lab_2.Task4");
        System.out.println("Метод, который вычисленяет факториал числа n через рекурсию");

        int paramN, result, checkResult;

        paramN = 6;
        checkResult = 720;
        result = Task4.factorialNumber(paramN);
        System.out.println("Тест 1: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = -6;
        checkResult = -1;
        result = Task4.factorialNumber(paramN);
        System.out.println("Тест 2: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " (ошибка) Статус: " + (result == checkResult));
        paramN = -1;
        checkResult = -1;
        result = Task4.factorialNumber(paramN);
        System.out.println("Тест 3: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " (ошибка) Статус: " + (result == checkResult));
        paramN = 0;
        checkResult = 0;
        result = Task4.factorialNumber(paramN);
        System.out.println("Тест 4: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = 1;
        checkResult = 1;
        result = Task4.factorialNumber(paramN);
        System.out.println("Тест 5: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = 12;
        checkResult = 479001600;
        result = Task4.factorialNumber(paramN);
        System.out.println("Тест 6: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = 13;
        checkResult = -1;
        result = Task4.factorialNumber(paramN);
        System.out.println("Тест 7: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " (инт. переполнен) Статус: " + (result == checkResult));

        paramN = CommonUseLibrary.readUserInput("Метод, который вычисленяет факториал числа n через рекурсию\nВведите натуральное число: ");
        System.out.println("Результат: " + Task4.factorialNumber(paramN));
    }
}
