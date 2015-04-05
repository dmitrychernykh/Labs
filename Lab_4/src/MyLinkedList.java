/**
 * Created by Dmitry Chernykh on 05.04.2015.
 * Poject Labs for EPAM courses
 */
public class MyLinkedList {

    Element first, last;

    int size = 0;

    MyLinkedList() {

    }

    /**
     * вставляет элемент в конец списка
     */
    public void add(Integer e) {
        if (size == 0) {
            addFirst(e);
        } else {
            last.setNext(new Element(e, null));
            last = last.next();
        }
        size++;
    }

    public void addElement(Element e) {
        if (size == 0) {
            first = e;
            first.setNext(null);
            last = first;
        } else {
            last.setNext(e);
            last = last.next();
            last.setNext(null);
        }
        size++;
    }

    /**
     * вставляет элемент на указанную позицию, сдвигая остальные элементы
     */
    public void add(int index, Integer element) {
        if (index == 0)
            addFirst(element);
        else if (index == size - 1)
            addLast(element);
        else {
            Element prev = getElement(index - 1);
            prev.setNext(new Element(element, prev.next()));
        }
        size++;
    }

    public void addFirst(Integer e) {
        first = new Element(e, first);
        if (last == null) last = first;
        size++;
    }

    public void addLast(Integer e) {
        add(e);
    }


    public Integer get(int index) {
        return getElement(index).getElement();
    }

    private Element getElement(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException("no such element with index: " + index);

        Element x = first;

        for (int i = 0; i < index; i++)
            x = x.next;
        return x;

    }

    public Integer getFirst() {
        return first.getElement();
    }

    public Integer getLast() {
        return last.getElement();
    }

    public Element getFirstElement() {
        return first;
    }

    public Element getLastElement() {
        return last;
    }

    public Integer remove(int index) {

        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();

        Element prev = getElement(index - 1);
        Integer value = prev.next().getElement();
        prev.setNext(prev.next());
        size--;
        if (size == 0) {
            first = null;
            last = null;
        }
        return value;

    }

    public Integer removeFirst() {

        Integer value = first.getElement();
        first = first.next();
        size--;
        if (size == 0) {
            first = null;
            last = null;
        }
        return value;

    }

    public Element removeFirstElement() {

        Element el = first;
        first = first.next();
        size--;
        if (size == 0) {
            first = null;
            last = null;
        }
        return el;

    }

    public Integer removeLast() {

        Integer value = last.getElement();
        last = getElement(size - 2);
        last.setNext(null);
        size--;
        if (size == 0) {
            first = null;
            last = null;
        }
        return value;

    }

    public Element removeLastElement() {

        Element el = last;
        last = getElement(size - 2);
        last.setNext(null);
        size--;
        if (size == 0) {
            first = null;
            last = null;
        }
        return el;

    }

    /**
     * изменяет значение элемента
     */
    public void set(int index, Integer element) {

        Element el = getElement(index);
        el.setElement(element);

    }

    /**
     * размер списка
     */
    public int size() {
        return size;
    }

    /**
     * поиск индекса по значению
     */
    public int indexOf(Integer o) {
        Element e = first;
        int index = 0;

        while (e.getElement() != o && e.hasNext()) {
            e = e.next();
            index++;
        }

        if (e.getElement() == o)
            return index;
        else
            return -1;

    }

}

class Element {
    Integer item;
    Element next;

    Element(Integer element, Element next) {
        this.item = element;
        this.next = next;
    }

    boolean hasNext() {
        return next != null;
    }

    Element next() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    void remove() {

    }

    Integer getElement() {
        return item;
    }

    void setElement(Integer item) {
        this.item = item;
    }
}
