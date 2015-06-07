import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Dmitry Chernykh on 04.05.2015.
 * Poject Labs for EPAM courses
 */
public class CollectionsCopy {

    <E> void fromArrayToCollection(E[] a, Collection<E> c) {

        if (a == null) throw new NullPointerException("source array is null");

        ensureCollection(c);

        for (E e : a)
            c.add(e);

    }

    <E> void copyAll(Collection<E> collection, Collection<? super E> out) {

        ensureCollection(collection);

        if (collection != out)
            ensureCollection(out);

        out.addAll(collection);

    }

    <E extends Comparable> Collection<E> filter(Collection<? extends E> collection, E border) {

        ArrayList<E> c = new ArrayList<>();
        for (E o : collection) {
            if (o.compareTo(border) > 0) {
                c.add(o);
            }
        }
        return c;

    }

    private void ensureCollection(Collection c) {
        if (c == null)
            throw new NullPointerException("collection is null!");
    }

}
