/**
 * Created by Dmitry Chernykh on 07.06.2015.
 * Poject Labs for EPAM courses
 */
public class Consumer extends Thread {

    static boolean inWork = false;
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

    public Object getBufferedData() {
        Object next;
        next = buf.get();
        System.out.println("Consumer read: " + next);
        return next;
    }

    @Override
    public void run() {
        inWork = true;
        buf.notifyAll();
        while (nextIndex < dataResult.length) {
            dataResult[nextIndex++] = getBufferedData();
        }
        inWork = false;
        buf.notifyAll();
    }
}
