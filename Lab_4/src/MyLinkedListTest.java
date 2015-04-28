/**
 * Created by Dmitry Chernykh on 06.04.2015.
 * Poject Labs for EPAM courses
 */
public class MyLinkedListTest {
    public static void main(String[] args) {

        MyLinkedList myList = new MyLinkedList(new Integer[]{5, 5, 3});
        myList.add(11);
        myList.add(9);
        myList.add(29);
        myList.add(35);
        printListInfo(myList, "[5, 5, 3, 11, 9, 29, 35]", 7, "(!) Добавлено 7 элементов");
        myList.add(1, 12);
        myList.add(5, 10);
        printListInfo(myList, "[5, 12, 5, 3, 11, 10, 9, 29, 35]", 9, "(!) Вставлено по индексу 2 элемента");
        myList.addLast(99);
        myList.addLast(100);
        printListInfo(myList, "[5, 12, 5, 3, 11, 10, 9, 29, 35, 99, 100]", 11, "(!) Добавлено2 элемента в конец списка");
        myList.addFirst(1);
        printListInfo(myList, "[1, 5, 12, 5, 3, 11, 10, 9, 29, 35, 99, 100]", 12, "(!) Добавлен1 1 элемент в начало списка");
        myList.removeFirstElement();
        printListInfo(myList, "[5, 12, 5, 3, 11, 10, 9, 29, 35, 99, 100]", 11, "(!) Удаление первого элемента");
        myList.removeLastElement();
        printListInfo(myList, "[5, 12, 5, 3, 11, 10, 9, 29, 35, 99]", 10, "(!) Удаление 1 последнего элемента");
        printListInfo(myList, "[5, 12, 5, 11, 10, 9, 29, 99]", 8, "(!) Удаление элемента [" + myList.remove(3) + "] по индексу 3 и [" + myList.remove(7) + "] по индексу 7");
        printListInfo(myList, "[5, 12, 5, 11, 10, 9, 29]", 7, "(!) Удаление последнего элемента [" + myList.removeLast() + "]");
        myList.set(2, 33);
        printListInfo(myList, "[5, 12, 33, 11, 10, 9, 29]", 7, "(!) Изменение 3-го элемента");
        try {
            myList.set(8, 15);
        } catch (IndexOutOfBoundsException e) {
            printListInfo(myList, "[5, 12, 33, 11, 10, 9, 29]", 7, "(!) Изменение несуществующего элемента (" + e.getMessage() + ")");
        }

        System.out.println("(!) Узнать индекс значения 33: Ожидается: " + 2 + " Результат: " + myList.indexOf(33));
        System.out.println("(!) Узнать индекс значения 29: Ожидается: " + 6 + " Результат: " + myList.indexOf(29));
        System.out.println("(!) Узнать индекс значения 5: Ожидается: " + 0 + " Результат: " + myList.indexOf(5));
        System.out.println("(!) Узнать индекс значения 123: Ожидается: " + (-1) + " Результат: " + myList.indexOf(123));
        System.out.println("(!) Получить по индексу (1) значение: Ожидается: " + (12) + " Результат: " + myList.get(1));
        System.out.println("(!) Получить по индексу (6) значение: Ожидается: " + (29) + " Результат: " + myList.get(6));
        System.out.println("(!) Получить по индексу (0) значение: Ожидается: " + (5) + " Результат: " + myList.get(0));
        String get12;
        try {
            get12 = myList.get(12).toString();
        } catch (IndexOutOfBoundsException e) {
            get12 = e.getMessage();
        }
        System.out.println("(!) Получить по индексу (12) значение: Ожидается: Ошибка обращения к несуществующему элементу; Результат: " + get12);
        System.out.println("(!) Получить значение первого: Ожидается: " + (5) + " Результат: " + myList.getFirst());
        System.out.println("(!) Получить значение последнего: Ожидается: " + (29) + " Результат: " + myList.getLast());

        System.out.println("(!) Очистка списка " + myList.toString() + ":");
        while (myList.size() > 0) {
            System.out.println(" удаление [" + myList.removeLast() + "]");
        }
        System.out.println("Результат (" + myList.size() + "): " + myList.toString());

    }

    public static void printListInfo(MyLinkedList list, String expectedPrint, int expectedSize, String msg) {
        if (!msg.isEmpty()) System.out.println(msg);
        System.out.println("Ожидается\t(" + expectedSize + "): " + expectedPrint);
        System.out.println("Список\t\t(" + list.size() + "): " + list.toString());
    }
}
