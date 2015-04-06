/**
 * Created by Dmitry Chernykh on 02.04.2015.
 */
public class Task7Runner {

    public static void main(String[] args) {

        int n = CommonUseLibrary.readUserInput("Метод, который выводит все комбинации перестановок чисел от 1 до заданного n.\nВведите натуральное число n: ");
        Task7.NumbersPermutater NP = new Task7.NumbersPermutater(n);
        System.out.println("Результат:");
        NP.printCombinations();

    }
}
