/**
 * Created by Dmitry Chernykh on 07.06.2015.
 * Poject Labs for EPAM courses
 */
public class SimpleNumbersSearch {

    /**
     * checks number, if it simple returns true
     *
     * @param number number to check
     */
    public static boolean isSimpleNumber(int number) {
        for (int i = 2; i <= number / 2; i++) if (number % i == 0) return false;
        return true;
    }

    public static void printSimpleNumbers(int begin, int end) {

        for (int i = begin; i < end; i++) {
            if (isSimpleNumber(i)) System.out.println("simple num: " + i);
        }
    }

    public static void main(String[] args) {

        int endBorder = 25000; // how much numbers to scan
        int ThreadCapacity = 5000; // how much numbers scans one thread

        for (int i = 0; i <= endBorder; i += ThreadCapacity) {
            new Thread(new SimpleNumberFinder(i, i + ThreadCapacity)).start();
        }
    }

    static class SimpleNumberFinder implements Runnable {

        static int counter = 0;

        private int startFrom, end;

        SimpleNumberFinder(int from, int to) {
            System.out.println("Finder " + (counter++) + " started");
            startFrom = from;
            end = to;
        }

        @Override
        public void run() {
            printSimpleNumbers(startFrom, end);
        }
    }
}
