import java.util.Random;

/**
 * Created by Dmitry Chernykh on 07.06.2015.
 * Poject Labs for EPAM courses
 */
public class Producer extends Thread {

    static final int DATA_LENGTH = 20;
    Object[] generatedData = generateData();
    int readIndex = 0;

    private CircledBuffer buf;

    Producer(CircledBuffer buffer) {
        buf = buffer;
    }

    private Object[] generateData() {
        Object[] obj = new Object[20];
        Random r = new Random();

        for (int i = 0; i < DATA_LENGTH; i++) {
            Integer next = Integer.valueOf(r.nextInt(1000));
            obj[i] = next;
        }
        return obj;
    }

    public void putToBufferedData(Object next) {
        synchronized (buf) {
            if (buf.put(next)) {

                buf.notifyAll();
            System.out.println(getName() + " Producer #" + getId() + " wrote: " + next);
        } else {
                try {
                    System.out.println(getName() + " Producer #" + getId() + " will wait");
                    buf.wait();
                    System.out.println(getName() + " Producer #" + getId() + " woke up");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void run() {
        System.out.println(getName() + " Producer #" + getId() + " started.");
        while (readIndex < DATA_LENGTH) {
            putToBufferedData(generatedData[readIndex++]);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " Producer #" + getId() + " finished.");
    }
}
