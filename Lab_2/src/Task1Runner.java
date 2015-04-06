/**
 * Created by Dmitry Chernykh on 06.04.2015.
 * Poject Labs for EPAM courses
 */
public class Task1Runner {
    public static void main(String[] args) {

        System.out.println("Lab_2.Task1");
        System.out.println("Метод, который подсчитывает количество цифр в числе");

        int paramN, result, checkResult;

        paramN = 123456;
        checkResult = 6;
        result = Task1.countNumbers(paramN);
        System.out.println("Тест 1: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = 67854321;
        checkResult = 8;
        result = Task1.countNumbers(paramN);
        System.out.println("Тест 2: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = -1247982;
        checkResult = 7;
        result = Task1.countNumbers(paramN);
        System.out.println("Тест 3: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = 0;
        checkResult = 1;
        result = Task1.countNumbers(paramN);
        System.out.println("Тест 4: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));

        paramN = CommonUseLibrary.readUserInput("Метод, который подсчитывает количество цифр в числе\nВведите целое число n: ");

        System.out.println("Результат: " + Task1.countNumbers(paramN));
    }
}
