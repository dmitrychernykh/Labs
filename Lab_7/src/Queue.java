/**
 * Created by Dmitry Chernykh on 26.04.2015.
 * Poject Labs for EPAM courses
 */
public interface Queue {

    void offer(Object e);

    Object peek();

    Object poll();

}
