/**
 * Created by Dmitry Chernykh on 07.06.2015.
 * Poject Labs for EPAM courses
 */
public class Consumer extends Thread {

    private final Object[] dataResult;
    private CircledBuffer buf;
    private int nextIndex = 0;

    Consumer(CircledBuffer buffer, int maxSize) {
        this.dataResult = new Object[maxSize];
        buf = buffer;
    }

    public Object[] getDataResult() {
        return dataResult;
    }

    public void getBufferedData() {
        Object next;
        synchronized (buf) {
            if ((next = buf.get()) == null) {
                try {
                    System.out.println(getName() + " Consumer #" + getId() + " will wait");
                    buf.wait(1000);
                    System.out.println(getName() + " Consumer #" + getId() + " woke up");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }
            buf.notifyAll();
        }

        System.out.println(getName() + " #" + getId() + " read: " + next + " size: " + nextIndex);
        dataResult[nextIndex++] = next;
    }

    @Override
    public void run() {
        System.out.println("Consumer #" + getId() + " started.");
        while (nextIndex < dataResult.length) {
            getBufferedData();
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumer #" + getId() + " finished.");
    }
}
