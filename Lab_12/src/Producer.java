import java.util.Random;

/**
 * Created by Dmitry Chernykh on 07.06.2015.
 * Poject Labs for EPAM courses
 */
public class Producer extends Thread {

    private CircledBuffer buf;

    Producer(CircledBuffer buffer) {
        buf = buffer;
    }

    public void putToBufferedData(Object next) {
        buf.put(next);
        System.out.println("Producer wrote: " + next);
    }

    @Override
    public void run() {
        Random r = new Random();
        while (Consumer.inWork) {
            Integer next = Integer.valueOf(r.nextInt(1000));
            putToBufferedData(next);
        }
    }
}
