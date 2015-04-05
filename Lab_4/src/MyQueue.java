/**
 * Created by Dmitry Chernykh on 05.04.2015.
 * Poject Labs for EPAM courses
 */
public class MyQueue {

    MyLinkedList list;

    MyQueue() {
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
    Element peek() {
        return list.getFirstElement();
    }

    /**
     * взять и удалить элемент из очереди
     */
    Element poll() {
        return list.removeFirstElement();
    }

}
