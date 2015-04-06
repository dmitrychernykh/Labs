/**
 * Created by Dmitry Chernykh on 06.04.2015.
 * Poject Labs for EPAM courses
 */
public class Task2Runner {

    public static void main(String[] args) {

        System.out.println("Lab_2.Task2");
        System.out.println("Метод, который возвращает число, записанное наоборот");

        int paramN, result, checkResult;

        paramN = 123456;
        checkResult = 654321;
        result = Task2.reverseNumber(paramN);
        System.out.println("Тест 1: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = 67854321;
        checkResult = 12345876;
        result = Task2.reverseNumber(paramN);
        System.out.println("Тест 2: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = -1247982;
        checkResult = 2897421;
        result = Task2.reverseNumber(paramN);
        System.out.println("Тест 3: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = 0;
        checkResult = 0;
        result = Task2.reverseNumber(paramN);
        System.out.println("Тест 4: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = 1;
        checkResult = 1;
        result = Task2.reverseNumber(paramN);
        System.out.println("Тест 5: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = -9;
        checkResult = 9;
        result = Task2.reverseNumber(paramN);
        System.out.println("Тест 6: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));

        paramN = CommonUseLibrary.readUserInput("Метод, который возвращает число, записанное наоборот\nВведите целое число n: ");
        System.out.println("Результат: " + Task2.reverseNumber(paramN));
    }
}
