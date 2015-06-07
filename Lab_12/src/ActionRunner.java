import java.util.Arrays;

/**
 * Created by Dmitry Chernykh on 07.06.2015.
 * Poject Labs for EPAM courses
 */
public class ActionRunner {
    public static void main(String[] args) throws InterruptedException {
        int p_count = 3; //how many producers will work
        int c_count = 1; //how many consumers will work
        CircledBuffer buffer = new CircledBuffer(8);
        for (int i = 0; i < p_count; i++) {
            new Producer(buffer).start();
        }
        Consumer firstConsumer = new Consumer(buffer, 50);
        firstConsumer.start();
        firstConsumer.join();
        System.out.println(Arrays.toString(firstConsumer.getDataResult()));
    }
}
