/**
 * Created by Dmitry Chernykh on 06.04.2015.
 * Poject Labs for EPAM courses
 */
public class MyStackTest {
    public static void main(String[] args) {

        MyStack myStack = new MyStack();

        myStack.push(new Element(5, null));
        myStack.push(new Element(7, null));
        myStack.push(new Element(15, null));
        myStack.push(new Element(32, null));
        myStack.push(new Element(43, null));
        myStack.push(new Element(66, null));
        printListInfo(myStack, "[5, 7, 15, 32, 43, 66]", 6, "(!) Добавлено 6 элементов");
        printListInfo(myStack, "[5, 7, 15, 32, 43]", 5, "(!) Получить из стэка: Ожидается:" + 66 + " Резльтат: " + myStack.pop().getElement());
        myStack.push(new Element(11, null));
        printListInfo(myStack, "[5, 7, 15, 32, 43, 11]", 6, "(!) Добавлен элемент 11");
        printListInfo(myStack, "[5, 7, 15, 32, 43]", 5, "(!) Получить из стэка: Ожидается:" + 11 + " Резльтат: " + myStack.pop().getElement());
        printListInfo(myStack, "[5, 7, 15, 32]", 4, "(!) Получить из стэка: Ожидается:" + 43 + " Резльтат: " + myStack.pop().getElement());
        printListInfo(myStack, "[5, 7, 15]", 3, "(!) Получить из стэка: Ожидается:" + 32 + " Резльтат: " + myStack.pop().getElement());
        myStack.push(new Element(22, null));
        printListInfo(myStack, "[5, 7, 15, 22]", 4, "(!) Добавлен элемент 22");
        myStack.push(new Element(765, null));
        printListInfo(myStack, "[5, 7, 15, 22, 765]", 5, "(!) Добавлен элемент 765");
        printListInfo(myStack, "[5, 7, 15, 22]", 4, "(!) Получить из стэка: Ожидается:" + 765 + " Резльтат: " + myStack.pop().getElement());
        myStack.push(new Element(19, null));
        printListInfo(myStack, "[5, 7, 15, 22, 19]", 5, "(!) Добавлен элемент 19");
        printListInfo(myStack, "[5, 7, 15, 22]", 4, "(!) Получить из стэка: Ожидается:" + 19 + " Резльтат: " + myStack.pop().getElement());
        printListInfo(myStack, "[5, 7, 15]", 3, "(!) Получить из стэка: Ожидается:" + 22 + " Резльтат: " + myStack.pop().getElement());
        printListInfo(myStack, "[5, 7]", 2, "(!) Получить из стэка: Ожидается:" + 15 + " Резльтат: " + myStack.pop().getElement());

        System.out.println("(!) Очистка стэка " + myStack.toString() + ":");
        while (myStack.size() > 0) {
            System.out.println(" удаление [" + myStack.pop().getElement() + "]");
        }
        System.out.println("Результат (" + myStack.size() + "): " + myStack.toString());

        String getElement;
        try {
            getElement = myStack.pop().getElement().toString();
        } catch (IndexOutOfBoundsException e) {
            getElement = e.getMessage();
        }
        System.out.println("(!) Получить из стэка: Ожидается: Ошибка получения несуществующего элемента Резльтат: " + getElement);

    }

    public static void printListInfo(MyStack stack, String expectedPrint, int expectedSize, String msg) {
        if (!msg.isEmpty()) System.out.println(msg);
        System.out.println("Ожидается\t(" + expectedSize + "): " + expectedPrint);
        System.out.println("Список\t\t(" + stack.size() + "): " + stack.toString());
    }
}
