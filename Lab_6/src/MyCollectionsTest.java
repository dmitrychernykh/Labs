/**
 * Created by Dmitry Chernykh on 06.04.2015.
 * Poject Labs for EPAM courses
 */
public class MyCollectionsTest {
    public static void main(String[] args) {
        boolean result;

        result = simpleMyCollectionsTestLL();
        result = simpleMyCollectionsTestAL();

    }

    public static boolean simpleMyCollectionsTestAL() {

        MyArrayList myList = new MyArrayList(5, 12, 5, 3, 11, 10, 9, 29, 35);

        printListInfo(myList, "[5, 12, 5, 3, 11, 10, 9, 29, 35]", 9, "(!) Инициализация списка");

        MyCollections.reverse(myList);
        printListInfo(myList, "[35, 29, 9, 10, 11, 3, 5, 12, 5]", 9, "(!) reverse списка");
        MyCollections.sort(myList);
        printListInfo(myList, "[3, 5, 5, 9, 10, 11, 12, 29, 35]", 9, "(!) sort списка");
        MyCollections.swap(myList, 2, 5);
        MyCollections.swap(myList, 6, 8);
        printListInfo(myList, "[3, 5, 11, 9, 10, 5, 35, 29, 12]", 9, "(!) swap 3-6, 7-9");
        MyCollections.sort(myList);
        printListInfo(myList, "[3, 5, 5, 9, 10, 11, 12, 29, 35]", 9, "(!) sort списка");

        MyArrayList newList = new MyArrayList();
        MyCollections.copy(newList, myList);
        printListInfo(newList, "[3, 5, 5, 9, 10, 11, 12, 29, 35]", 9, "(!) copy");

        return true;
    }

    public static boolean simpleMyCollectionsTestLL() {

        MyLinkedList myList = new MyLinkedList(1, 5, 12, 5, 3, 11, 10, 9, 29, 35, 99, 100);

        printListInfo(myList, "[1, 5, 12, 5, 3, 11, 10, 9, 29, 35, 99, 100]", 12, "(!) Инициализация списка");

        MyCollections.reverse(myList);
        printListInfo(myList, "[100, 99, 35, 29, 9, 10, 11, 3, 5, 12, 5, 1]", 12, "(!) reverse списка");
        MyCollections.sort(myList);
        printListInfo(myList, "[1, 3, 5, 5, 9, 10, 11, 12, 29, 35, 99, 100]", 12, "(!) sort списка");
        MyCollections.swap(myList, 2, 5);
        MyCollections.swap(myList, 6, 11);
        printListInfo(myList, "[1, 3, 10, 5, 9, 5, 100, 12, 29, 35, 99, 11]", 12, "(!) swap 3-6, 7-12");
        MyCollections.sort(myList);
        printListInfo(myList, "[1, 3, 5, 5, 9, 10, 11, 12, 29, 35, 99, 100]", 12, "(!) sort списка");

        MyLinkedList newList = new MyLinkedList();
        MyCollections.copy(newList, myList);
        printListInfo(newList, "[1, 3, 5, 5, 9, 10, 11, 12, 29, 35, 99, 100]", 12, "(!) copy");

        return true;
    }


    public static void printListInfo(MyList list, String expectedPrint, int expectedSize, String msg) {
        if (!msg.isEmpty()) System.out.println(msg);
        System.out.println("Ожидается\t(" + expectedSize + "): " + expectedPrint);
        System.out.println("Список\t\t(" + list.size() + "): " + list.toString());
    }
}
