import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import static org.junit.Assert.assertArrayEquals;

public class CollectionsCopyTest {

    Fruit[] frArray = null;
    RedApple[] rappArray = null;
    ArrayList<Fruit> fr = null;
    LinkedList<Apple> app = null;
    LinkedList<Orange> or = new LinkedList<>();
    LinkedList<RedApple> rapp = null;
    LinkedList<RedApple> rapp2 = null;
    LinkedList<Melon> mel = null;

    @Before
    public void setUp() throws Exception {
        or = new LinkedList<>();
        or.add(new Orange(4));
        or.add(new Orange(6));
        or.add(new Orange(7));

        app = new LinkedList<>();
        rapp = new LinkedList<RedApple>();
        rapp.add(new RedApple(7));
        rapp.add(new RedApple(8));
        rapp.add(new RedApple(2));

        rapp2 = new LinkedList<>();

        frArray = new Fruit[]{new Orange(3), new Apple(4), new RedApple(1), new Fruit(2)};
        fr = new ArrayList<>(Arrays.asList(frArray));
        rappArray = new RedApple[]{new RedApple(3), new RedApple(4), new RedApple(1), new RedApple(2)};
    }

    @org.junit.Test
    public void testCopyAll() throws Exception {

        CollectionsCopy collectionsCopy = new CollectionsCopy();

        fr.clear();
        collectionsCopy.copyAll(or, fr);
        assertArrayEquals("ArrayEquals check fault", or.toArray(), fr.toArray());
        fr.clear();
        collectionsCopy.copyAll(rapp, fr);
        assertArrayEquals("ArrayEquals check fault", rapp.toArray(), fr.toArray());
        collectionsCopy.copyAll(rapp, app);
        assertArrayEquals("ArrayEquals check fault", rapp.toArray(), app.toArray());
        collectionsCopy.copyAll(rapp, rapp2);
        assertArrayEquals("ArrayEquals check fault", rapp.toArray(), rapp2.toArray());
//        collectionsCopy.copyAll(fr, or);
//        assertArrayEquals("ArrayEquals check fault", fr.toArray(), or.toArray());

    }

    @org.junit.Test
    public void testCopyFromArray() throws Exception {

        CollectionsCopy collectionsCopy = new CollectionsCopy();

        fr = new ArrayList<>();
        collectionsCopy.fromArrayToCollection(frArray, fr);
        assertArrayEquals("ArrayEquals check fault", fr.toArray(), frArray);
        fr = new ArrayList<>();
        collectionsCopy.fromArrayToCollection(rappArray, app);
        assertArrayEquals("ArrayEquals check fault", app.toArray(), rappArray);

    }

    @org.junit.Test
    public void testFilter() throws Exception {
        Fruit border = new Fruit(3);
        CollectionsCopy collectionsCopy = new CollectionsCopy();
        Collection<Fruit> fra = collectionsCopy.filter(fr, border);
        Fruit[] fr2 = new Fruit[]{new Orange(3), new Apple(4)};
        assertArrayEquals("ArrayEquals check fault", fra.toArray(), fr2);
    }

    class Fruit implements Comparable<Fruit> {

        int value;

        public Fruit(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Fruit o) {
            return o.value > this.value ? -1 : 1;
        }

        @Override
        public boolean equals(Object obj) {
            return this.value == ((Fruit) obj).value;
        }
    }

    class Apple extends Fruit {
        public Apple(int value) {
            super(value);
        }
    }

    class Orange extends Fruit {
        public Orange(int value) {
            super(value);
        }
    }

    class RedApple extends Apple {
        public RedApple(int value) {
            super(value);
        }
    }

    class Melon extends Fruit {
        public Melon(int value) {
            super(value);
        }
    }
}
