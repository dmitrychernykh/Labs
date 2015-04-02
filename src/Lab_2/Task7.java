package Lab_2;

/**
 * Created by Windows on 02.04.2015.
 */
public class Task7 {


    public static void printCombinations(int n){

        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("" + j + ((j == 1) ? "\n" : ""));
            }
            System.out.print("" + i + ((i == 1) ? "\n" : ""));
        }




    }

    public static void main(String[] args) {
        printCombinations(3);
    }
}
