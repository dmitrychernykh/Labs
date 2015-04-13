/**
 * Created by Dmitry Chernykh on 05.04.2015.
 * Poject Labs for EPAM courses
 */
public class MyQueue {

    private MyLinkedList list;

    public MyQueue() {
        list = new MyLinkedList();
    }

    /**
     * добавить в конец очереди
     */
    public void offer(Element e) {
        list.addElement(e);
    }

    /**
     * взять без удаления, элемент из очереди
     */
    public Element peek() {
        return list.getFirstElement();
    }

    /**
     * взять и удалить элемент из очереди
     */
    public Element poll() {
        return list.removeFirstElement();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public int size() {
        return list.size();
    }
}
