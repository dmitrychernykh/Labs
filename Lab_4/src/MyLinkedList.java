/**
 * Created by Dmitry Chernykh on 05.04.2015.
 * Poject Labs for EPAM courses
 */
public class MyLinkedList implements MyList, Stack, Queue {

    private Element first, last;

    private int size = 0;

    MyLinkedList() {

    }

    MyLinkedList(Object... args) {
        addAll(args);
    }

    /**
     * вставляет элемент в конец списка
     */
    @Override
    public void add(Object e) {
        if (size == 0) {
            addFirst(e);
        } else {
            last.setNext(new Element(e, null));
            last = last.next();
            size++;
        }
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
    @Override
    public void add(int index, Object element) {
        if (index == 0)
            addFirst(element);
        else if (index == size - 1)
            addLast(element);
        else {
            Element prev = getElement(index - 1);
            prev.setNext(new Element(element, prev.next()));
            size++;
        }
    }

    public void insertElement(int index, Element node) {

        if (index == 0) {
            node.setNext(first);
            first = node;
            size++;
            return;
        } else if (index == size - 1) {
            addElement(node);
            return;
        }

        Element prev = getElement(index - 1);
        node.setNext(prev.next());
        prev.setNext(node);
        size++;

    }

    public void addFirst(Object e) {
        first = new Element(e, first);
        if (last == null) last = first;
        size++;
    }

    public void addLast(Object e) {
        add(e);
    }

    @Override
    public void addAll(Object[] c) {
        for (int i = 0; i < c.length; i++) {
            add(c[i]);
        }
    }

    @Override
    public void addAll(int index, Object[] c) {
        if (!(index >= 0 && index <= size))
            throw new IndexOutOfBoundsException("no such element with index: " + index);

        int i = 0;
        if (index == size) {
            addAll(c);
            return;
        } else if (index == 0) {
            addFirst(c[i++]);
            index++;
        }

        Element tmpLast = last;
        last = getElement(index - 1);
        Element tmpNodes = last.next();
        size -= (index + 1);

        while (i < c.length) {
            add(c[i++]);
        }
        last.setNext(tmpNodes);
        last = tmpLast;
        size += c.length + index + 1;
    }

    @Override
    public Object get(int index) {
        return getElement(index).getElement();
    }

    public Element getElement(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException("no such element with index: " + index);

        Element x = first;

        for (int i = 0; i < index; i++)
            x = x.next();
        return x;

    }

    public Object getFirst() {
        return first.getElement();
    }

    public void setFirst(Element newFirst) {
        first = newFirst;
        refreshLastElement();
    }

    public Object getLast() {
        return last.getElement();
    }

    public Element getFirstElement() {
        return first;
    }

    public void setFirstElement(Element newFirst) {
        if (first != null) newFirst.setNext(first.next());
        first = newFirst;
        refreshLastElement();
    }

    /**
     * изменяет значение элемента
     */
    @Override
    public void set(int index, Object element) {

        Element el = getElement(index);
        el.setElement(element);

    }

    private void refreshLastElement() {
        Element newLast = first;
        while (newLast.hasNext()) newLast = newLast.next();
        last = newLast;
    }

    public void setElement(int index, Element newElm) {
        if (index == 0) {
            setFirstElement(newElm);
            return;
        }
        Element nodeParent = getElement(index - 1);
        newElm.setNext(nodeParent.next());
        nodeParent.setNext(newElm);
        if (index + 1 == size()) {
            refreshLastElement();
        }
    }

    public Element getLastElement() {
        return last;
    }

    @Override
    public Object remove(int index) {
        return removeElement(index).getElement();
    }

    public Element removeElement(int index) {

        if (index == 0) return removeFirstElement();
        if (index == size - 1) return removeLastElement();

        Element prev = getElement(index - 1);
        Element del = prev.next();
        prev.setNext(prev.next().next());
        size--;
        if (size == 0) {
            first = null;
            last = null;
        }
        return del;

    }

    public Object removeFirst() {

        return removeFirstElement().getElement();

    }

    public Element removeFirstElement() {

        if (size == 0) getElement(0);

        Element el = first;
        first = first.next();
        size--;
        if (size == 0) {
            first = null;
            last = null;
        }
        return el;

    }

    public Object removeLast() {

        return removeLastElement().getElement();

    }

    public Element removeLastElement() {

        if (size == 0) getElement(0);

        Element el = last;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            last = getElement(size - 2);
            last.setNext(null);
        }
        size--;
        return el;

    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * размер списка
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size()];
        Element prev = getFirstElement();
        for (int i = 0; i < size(); i++) {
            result[i] = prev.getElement();
            prev = prev.next();
        }
        return result;
    }

    /**
     * поиск индекса по значению
     */
    @Override
    public int indexOf(Object o) {

        if (size == 0) return -1;

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

    @Override
    public String toString() {

        Element printEl = getFirstElement();
        String result = "";
        while (printEl != null) {
            result = result.concat(((result.isEmpty()) ? "" : ", ").concat(printEl.getElement().toString()));
            printEl = printEl.next();
        }
        return "[" + result + "]";
    }

    @Override
    public void offer(Object e) {
        addElement(new Element(e, null));
    }

    @Override
    public Object peek() {
        return getFirstElement();
    }

    @Override
    public void push(Object e) {
        addElement(new Element(e, null));
    }

    @Override
    public Object pop() {
        return removeLastElement();
    }

    @Override
    public Object poll() {
        return removeFirstElement();
    }
}

class Element {
    private Object item;
    private Element next;

    public Element(Object element, Element next) {
        this.item = element;
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public Element next() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public void remove() {

    }

    public Object getElement() {
        return item;
    }

    public void setElement(Object item) {
        this.item = item;
    }
}
