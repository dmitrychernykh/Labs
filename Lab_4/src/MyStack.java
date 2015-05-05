/**
 * Created by Dmitry Chernykh on 05.04.2015.
 * Poject Labs for EPAM courses
 */
public class MyStack {

    private MyLinkedList list;

    MyStack() {
        list = new MyLinkedList();
    }

    public MyStack(MyLinkedList newList) {
        this.list = newList;
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
    public Element pop() {
        return list.removeLastElement();
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
