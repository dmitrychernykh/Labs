/**
 * Created by Dmitry Chernykh on 06.04.2015.
 * Poject Labs for EPAM courses
 */
public class MyArrayListTest {
    public static void main(String[] args) {

        MyArrayList myList = new MyArrayList();

        myList.add(5);
        myList.add(5);
        myList.add(3);
        myList.add(3, 11);
        myList.add(9);
        myList.add(29);
        myList.add(35);
        printListInfo(myList, "[5, 5, 3, 11, 9, 29, 35]", 7, "(!) Добавлено 7 элементов");
        myList.add(1, 12);
        myList.add(5, 10);
        printListInfo(myList, "[5, 12, 5, 3, 11, 10, 9, 29, 35]", 9, "(!) Вставлено по индексу 2 элемента");
        printListInfo(myList, "[12, 5, 3, 11, 10, 9, 29, 35]", 8, "(!) Удаление первого элемента " + myList.remove(0).toString());
        printListInfo(myList, "[12, 5, 3, 11, 10, 9, 29]", 7, "(!) Удаление последнего элемента " + myList.remove(myList.size() - 1).toString());
        printListInfo(myList, "[12, 5, 3, 10, 29]", 5, "(!) Удаление элемента [" + myList.remove(3).toString() + "] по индексу 3 и [" + myList.remove(4).toString() + "] по индексу 4");
        myList.set(2, 33);
        printListInfo(myList, "[12, 5, 33, 10, 29]", 5, "(!) Изменение 3-го элемента");
        myList.set(4, 99);
        printListInfo(myList, "[12, 5, 33, 10, 99]", 5, "(!) Изменение 5-го элемента");
        myList.set(0, 21);
        printListInfo(myList, "[21, 5, 33, 10, 99]", 5, "(!) Изменение 1-го элемента");
        try {
            myList.set(5, 15);
        } catch (IndexOutOfBoundsException e) {
            printListInfo(myList, "[21, 5, 33, 10, 99]", 5, "(!) Изменение несуществующего элемента (" + e.getMessage() + ")");
        }
        System.out.println("Как работает изменение массива:");
        System.out.println("Текущий объем базового массива: " + myList.getLengthOfArray() + "\tТекущий объем списка: " + myList.size());
        myList.trimArray();
        System.out.println("Применение метода trimArray()");
        System.out.println("Текущий объем базового массива: " + myList.getLengthOfArray() + "\tТекущий объем списка: " + myList.size());
        printListInfo(myList, "[21, 5, 33, 10, 99]", 5, "(!) Вид массива");
        myList.add(81);
        printListInfo(myList, "[21, 5, 33, 10, 99, 81]", 6, "(!) Добавлен элемент 81");
        System.out.println("Текущий объем базового массива: " + myList.getLengthOfArray() + "\tТекущий объем списка: " + myList.size());
        myList.add(4, 52);
        myList.add(4, 51);
        printListInfo(myList, "[21, 5, 33, 10, 51, 52, 99, 81]", 8, "(!) Вставлены элементы 51 и 52 по индексу 4");
        System.out.println("Текущий объем базового массива: " + myList.getLengthOfArray() + "\tТекущий объем списка: " + myList.size());
        myList.trimArray();
        System.out.println("Применение метода trimArray()");
        System.out.println("Текущий объем базового массива: " + myList.getLengthOfArray() + "\tТекущий объем списка: " + myList.size());

        System.out.println("Вставка массива из 12 элементов в массив:");
        myList.addAll(getNewArray(12));
        printListInfo(myList, "[21, 5, 33, 10, 51, 52, 99, 81, 0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33]", 20, "(!) Вставка массива из 12 элементов в массив:");
        System.out.println("Текущий объем базового массива: " + myList.getLengthOfArray() + "\tТекущий объем списка: " + myList.size());

        myList.addAll(1, getNewArray(5));
        printListInfo(myList, "[21, 0, 3, 6, 9, 12, 5, 33, 10, 51, 52, 99, 81, 0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33]", 25, "(!) Вставка массива из 5 элементов в массив по индексу 1:");
        System.out.println("Текущий объем базового массива: " + myList.getLengthOfArray() + "\tТекущий объем списка: " + myList.size());

        myList.addAll(25, getNewArray(2));
        printListInfo(myList, "[21, 0, 3, 6, 9, 12, 5, 33, 10, 51, 52, 99, 81, 0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 0, 3]", 25, "(!) Вставка массива из 2 элементов в массив по индексу 25:");
        System.out.println("Текущий объем базового массива: " + myList.getLengthOfArray() + "\tТекущий объем списка: " + myList.size());

        System.out.println("(!) Получить по индексу (5) значение: Ожидается: " + (12) + " Результат: " + myList.get(5));
        System.out.println("(!) Получить по индексу (26) значение: Ожидается: " + (3) + " Результат: " + myList.get(26));
        System.out.println("(!) Получить по индексу (0) значение: Ожидается: " + (21) + " Результат: " + myList.get(0));
        String get27;
        try {
            get27 = myList.get(27).toString();
        } catch (IndexOutOfBoundsException e) {
            get27 = e.getMessage();
        }
        System.out.println("(!) Получить по индексу (27) значение: Ожидается: Ошибка обращения к несуществующему элементу; Результат: " + get27);

        System.out.println("(!) Очистка списка " + myList.toString() + ":");
        int lastLengthOfArray = myList.getLengthOfArray();
        while (myList.size() > 0) {
            System.out.println(" удаление [" + myList.remove(myList.size() - 1) + "]");
            if (myList.getLengthOfArray() != lastLengthOfArray) {
                System.out.println("Выполнен trim()\tТекущий объем базового массива: " + myList.getLengthOfArray() + "\tТекущий объем списка: " + myList.size());
                lastLengthOfArray = myList.getLengthOfArray();
            }
        }
        System.out.println("Результат (" + myList.size() + "): " + myList.toString() + "\nТекущий объем базового массива: " + myList.getLengthOfArray());

    }

    public static Object[] getNewArray(int length) {
        Integer[] newArr = new Integer[length];
        for (int i = 0; i < length; i++) {
            newArr[i] = i * 3;
        }
        return newArr;
    }

    public static void printListInfo(MyArrayList list, String expectedPrint, int expectedSize, String msg) {
        if (!msg.isEmpty()) System.out.println(msg);
        System.out.println("Ожидается\t(" + expectedSize + "): " + expectedPrint);
        System.out.println("Список\t\t(" + list.size() + "): " + list.toString());
    }
}
