/**
 * Created by Dmitry Chernykh on 06.04.2015.
 * Poject Labs for EPAM courses
 */
public class MyQueueTest {
    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();

        myQueue.offer(new Element(5, null));
        myQueue.offer(new Element(7, null));
        myQueue.offer(new Element(15, null));
        myQueue.offer(new Element(32, null));
        myQueue.offer(new Element(43, null));
        myQueue.offer(new Element(66, null));
        printListInfo(myQueue, "[5, 7, 15, 32, 43, 66]", 6, "(!) Добавлено 6 элементов");
        System.out.println("(!) Получить из очереди: Ожидается:" + 5 + " Резльтат: " + myQueue.peek().getElement());
        myQueue.offer(new Element(11, null));
        printListInfo(myQueue, "[5, 7, 15, 32, 43, 66, 11]", 7, "(!) Добавлен элемент 11");
        System.out.println("(!) Получить из очереди: Ожидается:" + 5 + " Резльтат: " + myQueue.peek().getElement());
        System.out.println("(!) Получить из очереди и удалить: Ожидается:" + 5 + " Резльтат: " + myQueue.poll().getElement());
        printListInfo(myQueue, "[7, 15, 32, 43, 66, 11]", 6, "(!) Получить из очереди и удалить");
        System.out.println("(!) Получить из очереди и удалить: Ожидается:" + 7 + " Резльтат: " + myQueue.poll().getElement());
        printListInfo(myQueue, "[15, 32, 43, 66, 11]", 5, "(!) Получить из очереди и удалить");

        System.out.println("(!) Очистка очереди " + myQueue.toString() + ":");
        while (myQueue.size() > 0) {
            System.out.println(" удаление [" + myQueue.poll().getElement() + "]");
        }
        System.out.println("Результат (" + myQueue.size() + "): " + myQueue.toString());

        String getElement;
        try {
            getElement = myQueue.poll().getElement().toString();
        } catch (IndexOutOfBoundsException e) {
            getElement = e.getMessage();
        }
        System.out.println("(!) Получить из стэка: Ожидается: Ошибка получения несуществующего элемента Резльтат: " + getElement);

    }

    public static void printListInfo(MyQueue queue, String expectedPrint, int expectedSize, String msg) {
        if (!msg.isEmpty()) System.out.println(msg);
        System.out.println("Ожидается\t(" + expectedSize + "): " + expectedPrint);
        System.out.println("Список\t\t(" + queue.size() + "): " + queue.toString());
    }
}
