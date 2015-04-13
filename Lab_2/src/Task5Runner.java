/**
 * Created by Dmitry Chernykh on 06.04.2015.
 * Poject Labs for EPAM courses
 */
public class Task5Runner {

    public static void main(String[] args) {

        System.out.println("Lab_2.Task5 (1)");
        System.out.println("Реализовано 2 варианта");
        System.out.println("1:Метод, который вычисленяет n-ое по счету число Фибоначчи через рекурсию");

        int paramN, result, checkResult;

        paramN = 6;
        checkResult = 5;
        result = Task5.febonachiNumber(paramN);
        System.out.println("Тест 1: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = -6;
        checkResult = -1;
        result = Task5.febonachiNumber(paramN);
        System.out.println("Тест 2: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " (ошибка) Статус: " + (result == checkResult));
        paramN = -1;
        checkResult = -1;
        result = Task5.febonachiNumber(paramN);
        System.out.println("Тест 3: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " (ошибка) Статус: " + (result == checkResult));
        paramN = 0;
        checkResult = -1;
        result = Task5.febonachiNumber(paramN);
        System.out.println("Тест 4: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " (ошибка) Статус: " + (result == checkResult));
        paramN = 1;
        checkResult = 0;
        result = Task5.febonachiNumber(paramN);
        System.out.println("Тест 5: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = 2;
        checkResult = 1;
        result = Task5.febonachiNumber(paramN);
        System.out.println("Тест 6: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = 3;
        checkResult = 1;
        result = Task5.febonachiNumber(paramN);
        System.out.println("Тест 7: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = 4;
        checkResult = 2;
        result = Task5.febonachiNumber(paramN);
        System.out.println("Тест 8: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = 13;
        checkResult = 144;
        result = Task5.febonachiNumber(paramN);
        System.out.println("Тест 9: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = 43;
        checkResult = 267914296;
        result = Task5.febonachiNumber(paramN);
        System.out.println("Тест 10: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));

        System.out.println("2:Метод, который вычисленяет n-ое по счету число Фибоначчи использую простой связанный список (объектная рекурсия)");

        paramN = 6;
        checkResult = 5;
        result = Task5.febonachiObjectRecursion(paramN);
        System.out.println("Тест 1: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = -6;
        checkResult = -1;
        result = Task5.febonachiObjectRecursion(paramN);
        System.out.println("Тест 2: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " (ошибка) Статус: " + (result == checkResult));
        paramN = -1;
        checkResult = -1;
        result = Task5.febonachiObjectRecursion(paramN);
        System.out.println("Тест 3: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " (ошибка) Статус: " + (result == checkResult));
        paramN = 0;
        checkResult = -1;
        result = Task5.febonachiObjectRecursion(paramN);
        System.out.println("Тест 4: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " (ошибка) Статус: " + (result == checkResult));
        paramN = 1;
        checkResult = 0;
        result = Task5.febonachiObjectRecursion(paramN);
        System.out.println("Тест 5: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = 2;
        checkResult = 1;
        result = Task5.febonachiObjectRecursion(paramN);
        System.out.println("Тест 6: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = 3;
        checkResult = 1;
        result = Task5.febonachiObjectRecursion(paramN);
        System.out.println("Тест 7: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = 4;
        checkResult = 2;
        result = Task5.febonachiObjectRecursion(paramN);
        System.out.println("Тест 8: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = 13;
        checkResult = 144;
        result = Task5.febonachiObjectRecursion(paramN);
        System.out.println("Тест 9: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));
        paramN = 43;
        checkResult = 267914296;
        result = Task5.febonachiObjectRecursion(paramN);
        System.out.println("Тест 10: (n = " + paramN + "); Результат: " + result + "; Ожидаемый результат: " + checkResult + " Статус: " + (result == checkResult));

        paramN = CommonUseLibrary.readUserInput("Метод, который вычисленяет n-ое по счету число Фибоначчи через рекурсию\nВведите натуральное число: ");
        System.out.println("Результат: " + Task5.febonachiNumber(paramN));
    }
}
