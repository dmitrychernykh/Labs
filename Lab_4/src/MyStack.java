/**
 * Created by Dmitry Chernykh on 05.04.2015.
 * Poject Labs for EPAM courses
 */
public class MyStack {

    MyLinkedList list;

    MyStack() {
        list = new MyLinkedList();
    }

    /**
     * поместить элемент в стек
     */
    public void push(Element e) {
        list.addElement(e);
    }

    /**
     * взять элемент из стека
     */
    Element pop() {
        return list.removeLastElement();
    }

}
