import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class ProducerTest {

    @Test
    public void testPut() {

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

    @Test
    public void testMonoThreadRunning() {

        CircledBuffer buffer = new CircledBuffer(8);
        Consumer c = new Consumer(buffer, Producer.DATA_LENGTH);
        Producer p = new Producer(buffer);

        Random r = new Random();
        p.putToBufferedData(r.nextInt(1000));
        p.putToBufferedData(r.nextInt(1000));
        p.putToBufferedData(r.nextInt(1000));

        System.out.println(buffer);

        c.getBufferedData();
        c.getBufferedData();

        p.putToBufferedData(r.nextInt(1000));
        p.putToBufferedData(r.nextInt(1000));

        c.getBufferedData();
        c.getBufferedData();
        c.getBufferedData();

        System.out.println(Arrays.toString(c.getDataResult()));
    }

}