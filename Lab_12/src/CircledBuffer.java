/**
 * Created by Dmitry Chernykh on 07.06.2015.
 * Poject Labs for EPAM courses
 */
public class CircledBuffer {
    private final Object[] buf;
    private final int BUFFSIZE;
    private int writePoint = 0;
    private int readPoint = 0;
    private int size = 0;


    /**
     * constructs buffer object with estimated size of buffered elements
     *
     * @param buffSize size of buffered elements
     */
    public CircledBuffer(int buffSize) {
        this.BUFFSIZE = buffSize;
        this.buf = new Object[buffSize];
    }

    /**
     * check that buffer isn't ready for writing new elements because it is full
     */
    public boolean isFull() {
        return size == BUFFSIZE;
    }

    /**
     * check that buffer is empty and isn't ready for reading from it
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * add element to buffer
     *
     * @param o new element
     */
    public synchronized void put(Object o) {
//        if (isFull()) throw new IllegalStateException("buffer is full");
        if (isFull())
            try {
                System.out.println("Thread put() will wait");
                wait();
                System.out.println("Thread put() woke up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        buf[writePoint++] = o;
        if (writePoint == BUFFSIZE) writePoint = 0;
        size++;
        if (isEmpty()) notifyAll();
    }

    /**
     * returns eldest element from buffer
     */
    public synchronized Object get() {
//        if (isEmpty()) throw new IllegalStateException("buffer is empty");
        if (isEmpty())
            try {
                System.out.println("Thread get() will wait");
                wait();
                System.out.println("Thread get() woke up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        Object next = buf[readPoint++];
        if (readPoint == BUFFSIZE) readPoint = 0;
        size--;
        if (isFull()) notifyAll();
        return next;
    }
}
