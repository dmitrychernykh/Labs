import java.util.Arrays;

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
    public synchronized boolean put(Object o) {
//        if (isFull()) throw new IllegalStateException("buffer is full");
        if (isFull()) return false;

        buf[writePoint++] = o;
        if (writePoint == BUFFSIZE) writePoint = 0;
        size++;

        return true;
    }

    /**
     * returns eldest element from buffer
     */
    public synchronized Object get() {
//        if (isEmpty()) throw new IllegalStateException("buffer is empty");
        if (isEmpty()) return null;

        Object next = buf[readPoint++];

        if (readPoint == BUFFSIZE) readPoint = 0;
        size--;
        return next;
    }

    @Override
    public String toString() {
        return "Buffer {" +
                "buf=" + Arrays.toString(buf) +
                ", size=" + size +
                '}';
    }
}
