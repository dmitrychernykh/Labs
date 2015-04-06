/**
 * Created by Dmitry Chernykh on 06.04.2015.
 * Poject Labs for EPAM courses
 */
public class Task3Runner {

    public static void main(String[] args) {

        System.out.println("Lab_2.Task3");
        System.out.println("Метод, который возводит число x в степень n через рекурсию");

        int paramX, paramN, result, checkResult;

        paramX = 144;
        paramN = 3;
        checkResult = 2985984;
        result = Task3.raiseNumber(paramX, paramN);
        System.out.println("Тест 1: (x = " + paramX + ", n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramX = 144;
        paramN = -5;
        checkResult = -1;
        result = Task3.raiseNumber(paramX, paramN);
        System.out.println("Тест 2: (x = " + paramX + ", n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " (ошибка) Статус: " + (result == checkResult));
        paramX = -144;
        paramN = 2;
        checkResult = 20736;
        result = Task3.raiseNumber(paramX, paramN);
        System.out.println("Тест 3: (x = " + paramX + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramX = -144;
        paramN = 3;
        checkResult = -2985984;
        result = Task3.raiseNumber(paramX, paramN);
        System.out.println("Тест 4: (x = " + paramX + ", n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramX = 0;
        paramN = 5;
        checkResult = 0;
        result = Task3.raiseNumber(paramX, paramN);
        System.out.println("Тест 5: (x = " + paramX + ", n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramX = 1;
        paramN = 15;
        checkResult = 1;
        result = Task3.raiseNumber(paramX, paramN);
        System.out.println("Тест 6: (x = " + paramX + ", n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));

        paramX = CommonUseLibrary.readUserInput("Метод, который возводит число x в степень n через рекурсию\nВведите натуральное число x: ");
        paramN = CommonUseLibrary.readUserInput("Введите натуральное число n: ");
        System.out.println("Результат: " + Task3.raiseNumber(paramX, paramN));

    }
}
