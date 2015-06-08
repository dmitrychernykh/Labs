import java.util.Arrays;

/**
 * Created by Dmitry Chernykh on 07.06.2015.
 * Poject Labs for EPAM courses
 */
public class ActionRunner {


    public static void main(String[] args) throws InterruptedException {
        int p_count = 3; //how many producers will work
//        int c_count = 1; //how many consumers will work
        CircledBuffer buffer = new CircledBuffer(8);
        Consumer firstConsumer = new Consumer(buffer, Producer.DATA_LENGTH * p_count);
        firstConsumer.setName("Consumer");
        for (int i = 0; i < p_count; i++) {
            Producer p = new Producer(buffer);
            p.setName("Producer #" + (i + 1));
            p.start();
        }
        firstConsumer.start();
        firstConsumer.join();
        System.out.println(Arrays.toString(firstConsumer.getDataResult()));
    }
}
