/**
 * Created by Dmitry Chernykh on 06.04.2015.
 * Poject Labs for EPAM courses
 */
public class Task7 {

    public static class NumbersPermutater {

        private final int TEN = 10;
        private int initNumer;
        private int value;


        NumbersPermutater(int initNumer) {
            this.initNumer = initNumer;
        }

        public int permutateNumber(int n) {

            if (n == initNumer || n < 1) throw new IllegalArgumentException();

            int i = initNumer;
            int delimiter = 1;

            while (i >= n) {
                i--;
                delimiter *= TEN;
            }

            int leftPart = value / delimiter * delimiter; // left part

            delimiter /= TEN;

            int rightPart = 0;
            if (delimiter > 10)
                rightPart += value % (delimiter / TEN); //right part

            int result = 0;

            result += value % delimiter / (delimiter / TEN);
            delimiter *= 10;
            result *= TEN;
            result += value % delimiter / (delimiter / TEN); //new combination

            if (delimiter > 100) result *= delimiter / TEN / TEN;

            result += leftPart;

            result += rightPart;

            value = result;

            return result;
        }

        public void printCombinations() {

            if (initNumer < 2) {
                System.out.println(initNumer);
                return;
            }

            value = 0;
            int multipier = 1;
            int border = 1;
            int i = initNumer;

            while (border <= i) {
                value += i * multipier;
                multipier *= 10;
                i--;
            }

            System.out.println("(" + value + ")");

            for (border = 2; border <= initNumer; border++) {
                for (int j = 1; j <= border; j++) {
                    int n = initNumer - j;
                    if (n == 0) n = initNumer - 1;
                    System.out.println("(" + permutateNumber(n) + ")");
                }
            }

        }
    }
}
