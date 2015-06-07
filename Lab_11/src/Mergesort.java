import java.util.Arrays;

/**
 * Created by Dmitry Chernykh on 07.06.2015.
 * Poject Labs for EPAM courses
 */
public class Mergesort {

    /**
     * merging two arrays left & right to result array that is exact length of those
     *
     * @param result result array
     * @param left   first part
     * @param right  second part
     */
    static Comparable[] merge(Comparable[] result, Comparable[] left, Comparable[] right) {
        int left_i = left.length, right_i = right.length;
        int res_index = (left_i--) + (right_i--);
        while (left_i >= 0 && right_i >= 0) { //wright to result by order
            if (left[left_i].compareTo(right[right_i]) > 0)
                result[--res_index] = left[left_i--];
            else
                result[--res_index] = right[right_i--];
        }
        if (left_i == 0) // if have one element left add it
            result[--res_index] = left[left_i];
        else if (right_i == 0)
            result[--res_index] = right[right_i];
        else if (left_i > 0) // if have more than one elements left copy all
            System.arraycopy(left, 0, result, 0, left_i + 1);
        else if (right_i > 0)
            System.arraycopy(right, 0, result, 0, right_i + 1);

        return result;
    }

    /**
     * main Sort method
     * calls new threads to help sort
     *
     * @param arrayToSplit array to sort
     */
    static void Sort(Comparable[] arrayToSplit) throws InterruptedException {

        if (arrayToSplit.length == 1) return;
        else if (arrayToSplit.length == 2 && arrayToSplit[0].compareTo(arrayToSplit[1]) > 0) {
            Comparable tmp = arrayToSplit[0];
            arrayToSplit[0] = arrayToSplit[1];
            arrayToSplit[1] = tmp;
            return;
        }

        int mid = arrayToSplit.length / 2;
        SortParallel runner1 = new SortParallel(Arrays.copyOfRange(arrayToSplit, 0, mid));
        SortParallel runner2 = new SortParallel(Arrays.copyOfRange(arrayToSplit, mid, arrayToSplit.length));
        Thread worker1 = new Thread(runner1);
        Thread worker2 = new Thread(runner2);
        System.out.println("Worker1 #" + worker1.getId() + " started");
        worker1.start();
        System.out.println("Worker2 #" + worker1.getId() + " started");
        worker2.start();
        worker1.join();
        worker2.join();
        merge(arrayToSplit, runner1.arrayToSort, runner2.arrayToSort);
    }

    public static void main(String[] args) {

        Integer[] arrToSort = new Integer[]{21, 32, 4, 5, 6, 123, 51, 53, 62, 63, 7, 88, 96, 2};
        System.out.println(Arrays.toString(arrToSort));

        SortParallel sort = new SortParallel(arrToSort);

        sort.run();

        System.out.println(Arrays.toString(arrToSort));
    }

    /**
     * thread method class
     */
    static class SortParallel implements Runnable {

        final Comparable[] arrayToSort;

        SortParallel(Comparable[] arrayToSort) {
            this.arrayToSort = arrayToSort;
        }

        @Override
        public void run() {
            try {
                Sort(arrayToSort);
            } catch (InterruptedException e) {
                System.err.println("unexpected interruption: " + e);
            }
        }
    }
}
