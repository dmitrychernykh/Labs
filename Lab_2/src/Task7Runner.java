/**
 * Created by Dmitry Chernykh on 02.04.2015.
 */
public class Task7Runner {

    public static void main(String[] args) {

        System.out.println("Lab_2.Task7");
//        System.out.println("Метод, который выводит все комбинации перестановок чисел от 1 до заданного n.");

        int paramN = 5;
        Task7.NumbersPermutater numbersPermutator;
//        numbersPermutator = new Task7.NumbersPermutater(paramN);
//        numbersPermutator.printCombinationsNew();

        paramN = CommonUseLibrary.readUserInput("Метод, который выводит все комбинации перестановок чисел от 1 до заданного n.\nВведите натуральное число n: ");
        numbersPermutator = new Task7.NumbersPermutater(paramN);
        numbersPermutator.printCombinationsNew();

    }
}
