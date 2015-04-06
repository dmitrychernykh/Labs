/**
 * Created by Dmitry Chernykh on 06.04.2015.
 * Poject Labs for EPAM courses
 */
public class MyArrayList {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] arrayData;

    private int size;

    /**
     * Constructs an empty list with the specified initial capacity
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.arrayData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    /**
     * Constructs an empty list with an initial capacity of ten (10)
     */
    public MyArrayList() {
        this.arrayData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * вставляет элемент в конец списка
     */
    public void add(Object e) {
        ensureCapacity(size);
        arrayData[size] = e;
        size++;
    }

    public void add(int index, Object e) {

        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Wrong index:" + index);

        ensureCapacity(size);
        System.arraycopy(arrayData, index, arrayData, index + 1, size - index);
        arrayData[index] = e;
        size++;
    }

    Object get(int index) {

        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Wrong index:" + index);

        return arrayData[index];
    }

    /**
     * при удалении размер массива должен уменьшаться
     */
    Object remove(int index) {

        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Wrong index:" + index);

        Object ob = get(index);

        if (index == (size - 1)) {
            //arrayData[index] = null;
        } else
            System.arraycopy(arrayData, index + 1, arrayData, index, size - index);

        size--;
        if (arrayData.length >> 1 - size > 0)
            trimArray();

        return ob;
    }

    /**
     * изменяет значение элемента
     */
    void set(int index, Object element) {

        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Wrong index:" + index);

        arrayData[index] = element;
    }

    /**
     * Appends all of the elements to the end of this list
     */
    void addAll(Object[] c) {
        int numNew = c.length;
        ensureCapacity(size + numNew);
        System.arraycopy(c, 0, arrayData, size, numNew);
        size += numNew;
    }

    /**
     * Inserts all of the elements into this list, starting at the specified position
     */
    void addAll(int index, Object[] c) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Wrong index:" + index);
        int numNew = c.length;
        ensureCapacity(size + numNew);
        System.arraycopy(arrayData, index, arrayData, index + numNew, size - numNew);
        System.arraycopy(c, 0, arrayData, index, numNew);
        size += numNew;
    }

    /**
     * Increases the capacity of this ArrayList instance, if necessary, to
     * ensure that it can hold at least the number of elements specified by the minimum capacity argument.
     */
    void ensureCapacity(int minCapacity) {
        if (minCapacity - this.arrayData.length > 0) {
            makeGrowing(minCapacity);
        }
    }

    public int Size() {
        return size;
    }

    private void makeGrowing(int minCapacity) {

        int oldLen = arrayData.length;
        int newLen = oldLen + (oldLen >> 1);
        if (newLen - minCapacity < 0) newLen = minCapacity;

        Object[] newArrayData = new Object[newLen];

        System.arraycopy(arrayData, 0, newArrayData, 0, oldLen);

        arrayData = newArrayData;
    }

    public void trimArray() {
        if (size < arrayData.length) {
            if (size == 0)
                arrayData = new Object[0];
            else {
                Object[] newArrayData = new Object[size];

                System.arraycopy(arrayData, 0, newArrayData, 0, arrayData.length);

                this.arrayData = newArrayData;
            }
        }
    }
}
