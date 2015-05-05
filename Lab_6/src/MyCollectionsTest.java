import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Dmitry Chernykh on 06.04.2015.
 * Poject Labs for EPAM courses
 */
public class MyCollectionsTest {

    public static MyList myList;
    public static ArrayList compare;

    public static boolean simpleMyCollectionsTest() {

        printListInfo(myList, compare.toString(), compare.size(), "(!) Инициализация списка");
        System.out.println((assertEquals(myList, compare)) ? "\tOK" : "\tError");
        MyCollections.reverse(myList);
        Collections.reverse(compare);
        printListInfo(myList, compare.toString(), compare.size(), "(!) reverse списка");
        System.out.println((assertEquals(myList, compare)) ? "\tOK" : "\tError");
        MyCollections.sort(myList);
        Collections.sort(compare);
        printListInfo(myList, compare.toString(), compare.size(), "(!) sort списка");
        System.out.println((assertEquals(myList, compare)) ? "\tOK" : "\tError");
        MyCollections.swap(myList, 2, 5);
        Collections.swap(compare, 2, 5);
        MyCollections.swap(myList, 6, 11);
        Collections.swap(compare, 6, 11);
        printListInfo(myList, compare.toString(), compare.size(), "(!) swap 3-6, 7-12");
        System.out.println((assertEquals(myList, compare)) ? "\tOK" : "\tError");
        MyCollections.sort(myList);
        Collections.sort(compare);
        printListInfo(myList, compare.toString(), compare.size(), "(!) sort списка");
        System.out.println((assertEquals(myList, compare)) ? "\tOK" : "\tError");

        MyList newList;
        if (myList instanceof MyLinkedList)
            newList = new MyLinkedList();
        else
            newList = new MyArrayList();

        MyCollections.copy(newList, myList);
        printListInfo(myList, compare.toString(), compare.size(), "(!) copy");
        System.out.println((assertEquals(newList, myList)) ? "\tOK" : "\tError");

        int result = MyCollections.binarySearch(myList, 33);
        int compareResult = Collections.binarySearch(compare, 33);
        System.out.print("(!) binarySearch 33 result " + result + " = " + compareResult);
        System.out.println((assertEquals(result, compareResult)) ? "\tOK" : "\tError");
        result = MyCollections.binarySearch(myList, 3);
        compareResult = Collections.binarySearch(compare, 3);
        System.out.print("(!) binarySearch 0 result " + result + " = " + compareResult);
        System.out.println((assertEquals(result, compareResult)) ? "\tOK" : "\tError");
        result = MyCollections.binarySearch(myList, 105);
        compareResult = Collections.binarySearch(compare, 105);
        System.out.print("(!) binarySearch 105 result " + result + " = " + compareResult);
        System.out.println((assertEquals(result, compareResult)) ? "\tOK" : "\tError");
        result = MyCollections.binarySearch(myList, 11);
        compareResult = Collections.binarySearch(compare, 11);
        System.out.print("(!) binarySearch 11 result " + result + " = " + compareResult);
        System.out.println((assertEquals(result, compareResult)) ? "\tOK" : "\tError");

        return true;
    }

    public static void main(String[] args) {
        boolean result;

        System.out.println("****** Тест коллекции MyLinkedList ******");
        Object[] myArray = MyCollectionsTest.getNewArrayOfInteger(15);
        myList = new MyLinkedList(myArray);
        compare = new ArrayList(Arrays.asList(myArray));

        result = simpleMyCollectionsTest();

        System.out.println("****** Тест коллекции MyArrayList ******");
        myArray = MyCollectionsTest.getNewArrayOfInteger(15);
        myList = new MyArrayList(myArray);
        compare = new ArrayList(Arrays.asList(myArray));

        result = simpleMyCollectionsTest();
    }

    public static boolean assertEquals(int a, int b) {
        return a == b;
    }

    public static boolean assertEquals(MyList a, ArrayList b) {
        if (a.size() != b.size()) return false;
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) return false;
        }
        return true;
    }

    public static boolean assertEquals(MyList a, MyList b) {
        if (a.size() != b.size()) return false;
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) return false;
        }
        return true;
    }

    public static Object[] getNewArrayOfInteger(int length) {
        Integer[] newArr = new Integer[length];
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            newArr[i] = rand.nextInt(100);
        }
        return newArr;
    }

    public static void printListInfo(MyList list, String expectedPrint, int expectedSize, String msg) {
        if (!msg.isEmpty()) System.out.println(msg);
        System.out.println("Ожидается\t(" + expectedSize + "): " + expectedPrint);
        System.out.println("Список\t\t(" + list.size() + "): " + list.toString());
    }
}
