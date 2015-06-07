import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dmitry Chernykh on 07.06.2015.
 * Poject Labs for EPAM courses
 */
class CircledBufferTest {
    @Test
    void testPut() {

        Queue<Integer> testQ = new LinkedList<>();
        testQ.offer(21);
        testQ.offer(13);
        testQ.offer(77);
        testQ.offer(5);
        testQ.offer(16);

        CircledBuffer buf = new CircledBuffer(5);
        buf.put(21);
        buf.put(13);
        buf.put(77);
        buf.put(5);
        buf.put(16);

        assertEquals(testQ.poll(), buf.get());
        assertEquals(testQ.poll(), buf.get());
        assertEquals(testQ.poll(), buf.get());
        assertEquals(testQ.poll(), buf.get());
        assertEquals(testQ.poll(), buf.get());

    }
}
