# Labs
##Оглавление
###Лабораторная работа №1 (Команды)
###Лабораторная работа №2 (Синтаксис)
###Лабораторная работа №3 (Пакеты)
###Лабораторная работа №4 (Связанный список)
###Лабораторная работа №5 (Динамический массив)
###Лабораторная работа №6 (Коллекции)
###Лабораторная работа №7 (Интерфейсы)
###Лабораторная работа №8
###Лабораторная работа №9 (Map)
###Лабораторная работа №10 (Generics)
###Лабораторная работа №11 (Многопоточность)
###Лабораторная работа №12 (Кольцевой буфер)
##Задачи лабораторных
###Лабораторная работа №1 (Команды)
Цель. Познакомиться с командами javac, javap, java, javadoc
I.
1. Найти где установлена Java
2. Узнать версию Java
3. Узнать значение переменной окружения JAVA_HOME
II.
1. Попытаться откомпилировать примеры из src.zip
2. Сказать, что в них неправильно и добиться их работоспособности
III.
Создать следующую иерархию папок:
Lab_1/
+ src/ - исходный код
+ build/
+ classes/ - откомпилированные классы
+ docs/ - JavaDoc
1. Написать класс Person, в котором хранилась бы имя, фамилия и дата рождения человека (в виде
строки). Поместить файл с классом в папку src.
2. Написать класс PersonRunner в котором задавались бы атрибуты для человека, а затем выводились
на экран
3. Откомпилировать PersonRunner из командной строки так, чтобы файлы *.class писались в папку
build/classes
4. Запустить программу.
5. Откомпилировать еще раз с выводом информации о компиляции, посмотреть полученный байт-код
6. Запустить программу с информацией о том, какие грузятся классы
7. Сгенерировать JavaDoc в папку docs
http://www.mcs.csueastbay.edu/~billard/se/cs3340/ex7/javadoctutorial.html
###Лабораторная работа №2 (Синтаксис)
Цель. Знакомство с синтаксисом языка
Требования:
1. Все задания реализуются без использования массивов, списков, строк. Необходимо использовать
for, while, if
2. Для каждого из классов написать тестовый класс <имя>Test(Runner).java (пример ReverseTest.java
или ReverseRunner.java)
Задания:
1. Написать метод, который подсчитывает количество цифр в числе
2. Написать метод, который возвращает число, записанное наоборот (без использования строк и
массивов) (пример: на входе 123, на выходе 321)
3. Написать метод, который возводит число x в степень n через рекурсию
4. Написать вычисление факториала числа n через рекурсию
5. Написать вычисление n-того по счету числа Фибоначчи через рекурсию
f0 = f1 = 1, f (n) = f(n–1) + f(n–2).
6. Используя стандартную библиотеку java.lang.Math (), написать метод для вычисление функции
y=log2(x-4)+exp(2a-x), с проверками на область определения, а так же создать к нему JavaDoc
7. Написать программу, которая выводит все комбинации перестановок чисел от 1 до заданного n.
Например, для n=3 это будет:
(1, 2, 3)
(1, 3, 2)
(2, 1, 3)
(2, 3, 1)
(3, 1, 2)
(3, 2, 1)
http://docs.oracle.com/javase/6/docs/api/java/lang/Math.html
###Лабораторная работа №3 (Пакеты)
Цель. Работа с пакетами
I.
1. Создать из командной строки иерархию директорий для проекта из задания — по аналогии с
примером:
http://www.developer.com/java/other/article.php/994991/Building-with-Ant-Directory-Structure.htm
JavaProjects/ - проекты
+ ShippingPrj/ - название проекта
+ src/ - исходный код
+ shipping/ - пакет
-domain/ - пакет
-gui/ - пакет
-reports/ - пакет
+ build
+classes/ - откомпилированные классы
+ shipping/ - пакет
-domain/ - пакет
-gui/ - пакет
-reports/ - пакет
+ lib - библиотеки
+ docs/ - сгенерированная документация
2. Написать класс ua.kpi.pti.HelloWorld
3. Откомпилировать из командной строки и поместить в нужную папку build/classes
4. Запустить программу
5. Откомпилировать с выводом информации о компиляции, посмотреть байт-код
6. Запустить программу с информацией о том, какие грузятся классы
II.
1. Написать класс ua.kpi.pti.PrintHello
2. Модифицировать ua.kpi.pti.HelloWorld так, что бы он вызывал соответствующий. метод из
ua.kpi.pti.PrintHello
3. Откомпилировать и запустить
III.
1. Переместить класс PrintHello в ua.kpi.pti.pkg.PrintHello
2. Модифицировать ua.kpi.pti.HelloWorld так, что бы он вызывал соответствующий метод из
ua.kpi.pti.pkg.PrintHello
3. Откомпилировать и запустить
IV.
1. Создать jar-файл с ua.kpi.pti.pkg.PrintHello и поместить его в lib
2. Добиться работоспособности
3. Показать, что ua.kpi.pti.pkg.PrintHello действительно грузиться из библиотеки
V.
Сгенерировать JavaDoc
http://mindprod.com/jgloss/classpath.html
http://www.herongyang.com/JVM/ClassLoader-Class-Load-Problem-JAR-Hell.html
###Лабораторная работа №4 (Связанный список)
Цель. Работа с объектами, связанный список
Хранятся целые числа типа Integer
1. Реализовать связанный список, который поддерживал бы следующие методы:
Методы класса MyLinkedList:
add(Integer e) - вставляет элемент в конец списка
add(int index, Integer element) - вставляет элемент на указанную позицию, сдвигая остальные элементы
addFirst(Integer e)
addLast(Integer e)
Integer get(int index)
Integer getFirst()
Integer getLast()
Integer remove(int index)
Integer removeFirst()
Integer removeLast()
set(int index, Integer element) - изменяет значение элемента
int size() - размер списка
int indexOf(Integer o) - поиск индекса по значению
Методы класса Element:
boolean hasNext() - есть ли следующий
Element next() - вернуть следующий
void remove() - удалить элемент
get/setElement()
2. На основе связанного списка используя композицию реализовать класс MyQueue - очередь с
набором следующих методов
offer(Element e) - добавить в конец очереди
Element peek() - взять без удаления, элемент из очереди
Element poll() - взять и удалить элемент из очереди
3. На основе связанного списка используя композицию реализовать класс MyStack - стек с набором
следующих методов
push(Element e) - поместить элемент в стек
Element pop() - взять элемент из стека
###Лабораторная работа №5 (Динамический массив)
Цель. Работа с массивами
Хранятся объекты типа Object.
Реализовать MyArrayList, который поддерживал бы следующие методы:
Конструкторы класса MyArrayList:
MyArrayList() - Constructs an empty list with an initial capacity of ten (10)
MyArrayList(int initialCapacity) - Constructs an empty list with the specified initial capacity
Методы класса MyArrayList:
void add(Object e) - вставляет элемент в конец списка
В случае если начального размера массива становится недостаточно, то массив автоматически должен
вырасти, что бы вместить все данные.
void add(int index, Object element) - вставляет элемент на указанную позицию, сдвигая остальные
элементы
void addAll(Object[] c) - Appends all of the elements to the end of this list
void addAll(int index, Object[] c) - Inserts all of the elements into this list, starting at the specified position
void ensureCapacity(int minCapacity) - Increases the capacity of this ArrayList instance, if necessary, to
ensure that it can hold at least the number of elements specified by the minimum capacity argument.
Object get(int index)
Object remove(int index) - при удалении размер массива должен уменьшаться
void set(int index, Object element) - изменяет значение элемента
int size() - размер списка
###Лабораторная работа №6 (Коллекции)
Цель. Передача параметров в методы
1. Реализуйте класс MyCollections со следующими статическими методами:
- public static void sort(MyLinkedList list)
- public static void swap(MyLinkedList list, int i, int j) - Swaps the elements at the specified positions in the
specified list
- public static void copy(MyLinkedList dest, MyLinkedList src) - Copies all of the elements from one list into
another
- public static void reverse(MyLinkedList list) - Reverses the order of the elements in the specified list
2. Дополнить класс MyCollections аналогичными методами для работы с MyArrayList.
В качестве алгоритма сортировки реализовать quicksort, в предположении, что в MyArrayList у нас
хранятся Integer
3. Добавьте в класс MyCollections метод
public static int binarySearch(MyArrayList list, Integer key),
который реализует рекурсивный поиск в отсортированном массиве методом бисекции.
Если элемент найден, то возвращается его индекс. Если не найден, то возвращается отрицательное
значение, вычисляемое по следующей формуле: (-(insertion point) - 1), где insertion point - индекс того
места в массиве, где должен был бы быть указанный элемент.
###Лабораторная работа №7 (Интерфейсы)
Цель. Работа с интерфейсами
1. Реализовать interface MyList
void add(Object e)
void add(int index, Object element)
void addAll(Object[] c)
void addAll(int index, Object[] c)
Object get(int index)
Object remove(int index)
void set(int index, Object element)
int indexOf(Object o) - поиск индекса по значению
int size() - размер списка
Object[] toArray() - преобразует список в массив объектов
2. Переписать MyLinkedList так, чтобы он реализовывал интерфейс MyList.
Кроме этого сделать так, чтобы он реализовывал интерфейсы Stack и Queue, с соответствующими
методами:
interface Queue
offer(Object e) - добавить в конец очереди
Object peek() - взять без удаления, элемент из очереди
Object poll() - взять и удалить элемент из очереди
interface Stack
push(Object e) - поместить элемент в стек
Object pop() - взять элемент из стека
3. Переписать MyArrayList так, чтобы он реализовывал интерфейс MyList, а также маркерный
интерфейс RandomAccess
4. Модифицировать класс MyCollections, так чтобы он принимал объекты типа MyList
4.1. public static void sort(MyList list)
В случае RandomAccess вызывать быструю сортировку, иначе - сортировку пузырьком.
Порядок элементов определяется результатом работы метода compareTo, если объект
массива реализует интерфейс Comparable
4.2. public static void sort(MyList list, Comparator c)
Если объект массива не реализует интерфейс Comparable, то должен передаваться объект,
реализующий интерфейс Comparator
4.3. public static void swap(MyList list, int i, int j)
Меняет местами элементы на указанных позициях заданного списка
4.4. public static void copy(MyList dest, MyList src)
Копирует все элементы из одного списка в другой
4.5. public static void reverse(MyList list)
Обращает порядок расположения элементов в заданном списке
Полезные ссылки:
1. Интерфейс Comparable: http://docs.oracle.com/javase/6/docs/api/java/lang/Comparable.html
2. Интерфейс Comparator: http://docs.oracle.com/javase/6/docs/api/java/util/Comparator.html
###Лабораторная работа №8
Цель. Закрепление методов объектно-ориентированного программирования на языке Java
Требования к выполнению задания:
1. Не нужно работать с БД.
2. Применить принципы объектно-ориентированного программирования.
3. Для каждого из классов описать коротко в комментариях его предназначение.
Задание: реализовать программу в соответствии с выбранным вариантом.
Вариант 1. Система ski-pass
Написать программу, которая моделирует работу системы ski-pass (выпуск ski-pass, турникет
лыжного подъемника по проверке доступа по ski-pass, статистика поездок).
Ski-pass бывают следующих видов:
1. На рабочие дни:
a) Без учета количества подъемов:
на полдня (с 9 до 13 или с 13 до 17), день, 2 дня, 5 дней.
b) По количеству подъемов:
на 10 подъемов, на 20 подъемов, на 50 подъемов, на 100 подъемов.
2. На выходные дни:
a) Без учета количества поездок:
на полдня (с 9 до 13 или с 13 до 17), на день, 2 дня.
b) По количеству подъемов:
на 10 подъемов, на 20 подъемов, на 50 подъемов, на 100 подъемов.
3. Абонемент на сезон.
Данные по карточки хранятся на самой карте, а именно: уникальный идентификатор, тип карты, срок
действия, количество поездок и т.д.
Турникет должен быть связан с системой, в которой ведется реестр выданных карточек ski-pass.
В этой системе возможно: а) выпустить ski-pass; б) заблокировать ski-pass из-за нарушения правил
подъема.
Турникет контролирует вход лыжников на подъемник по ski-pass. Турникет считывает данные с
карты и выполняет ее проверку. Если данные не удалось считать, или карточка просрочена, или
заблокирована, или на ней не осталось кредитов для поездок, то проход запрещен. Иначе с карточки
снимается одна поездка (если для карты предполагается учет подъемов) и проход разрешается.
Система также осуществляет учет разрешений и отказов прохода. И умеет выдавать по запросу:
1) суммарные данные и 2) данные, разбитые по типам ski-pass.
Вариант 2. Система турникета метро
Написать программу, которая моделирует работу системы турникета метро.
Турникет контролирует вход пассажиров на перрон. Для прохода на перрон могут использоваться
проездные карточки, которые подразделяются на:
1. Ученические, Студенческие, Обычные.
2. По сроку действия: на месяц, на 10 дней.
3. По количеству поездок: на 5, на 10.
4. Накопительные карточки (могут быть только «обычного» типа - не могут быть ученические и
студенческие) - могут пополняться на определенную сумму, с которой при каждой поездке
снимается стоимость проезда. Такие карты не имеют ограничений по сроку действия.
Турникет должен быть связан с системой, в которой ведется реестр выданных карточек. В этой
системе возможно: 1. выпустить карточку.
Данные по карточки хранятся на самой карте, а именно: уникальный идентификатор, тип карты, срок
действия, количество поездок и т.д.
Турникет считывает данные с карты и выполняет ее проверку. Если данные не удалось считать, или
карточка просрочена, или на ней не осталось кредитов для поездок, то проход запрещен. Иначе с карты
снимается одна и проход разрешается.
Система осуществляет учет разрешений и отказов прохода. И умеет выдавать по запросу:
1) суммарные данные и 2) данные разбиты по типам карточек.
###Лабораторная работа №9 (Map)
1. Создать интерфейс MyMap.
public interface MyMap
void clear() - removes all of the mappings from this map.
boolean containsKey(Object key) - returns true if this map contains a mapping for the specified key.
boolean containsValue(Object value) - returns true if this map maps one or more keys to the specified value.
Object get(Object key) - returns the value to which the specified key is mapped, or null if this map contains no
mapping for the key.
boolean isEmpty() - returns true if this map contains no key-value mappings.
Object put(Object key, Object value) - associates the specified value with the specified key in this map.
Object remove(Object key) - removes the mapping for the specified key from this map if present.
int size() - returns the number of key-value mappings in this map.
Iterator entryIterator() - returns an iterator over the elements (MyMap.Entry) in proper sequence
Вложенный интерфейс: MyMap.Entry
boolean equals(Object o) - сompares the specified object with this entry for equality.
Object getKey() - returns the key corresponding to this entry.
Object getValue() - returns the value corresponding to this entry.
int hashCode() - returns the hash code value for this map entry.
Object setValue(Object value) - replaces the value corresponding to this entry with the specified value.
2. Реализовать класс MyHashMap.
public class MyHashMap implements MyMap
Конструкторы класса:
public MyHashMap() - constructs an empty HashMap with the default initial capacity (16) and the default load
factor (0.75).
public MyHashMap(int initialCapacity) - constructs an empty HashMap with the specified initial capacity and
the default load factor (0.75). Throws: IllegalArgumentException - if the initial capacity is negative.
public MyHashMap(int initialCapacity, float loadFactor) - constructs an empty HashMap with the specified
initial capacity and load factor. Throws: IllegalArgumentException - if the initial capacity is negative or the
load factor is nonpositive.
Вложенный класс: MyMap.SimpleEntry implements MyMap.Entry
3. Реализовать MyTreeMap.
public class MyTreeMap implements MyMap
Конструкторы класса:
MyTreeMap() - constructs a new, empty tree map, using the natural ordering of its keys.
MyTreeMap(Comparator comparator) - constructs a new, empty tree map, ordered according to the given
comparator.
Вложенный класс: MyMap.SimpleEntry
4. В качестве литературы использовать главы 8, 9 из книги «Структуры данных и алгоритмы в Java»
###Лабораторная работа №10 (Generics)
1. Написать функцию для копирования из массива в коллекцию того же типа, что и массив
void fromArrayToCollection(Object[] a, Collection c)
2. Написать функцию для копирования одной коллекции в другую
void copyAll(Collection collection, Collection out)
Так, что бы можно было выполнять следующие операции
List<Fruit> fr = null;
List<Apple> app = null;
List<Orange> or = null;
List<RedApple> rapp = null;
List<Melon> mel = null;
copyAll(or, fr);
copyAll(rapp, fr);
copyAll(rapp, app);
copyAll(rapp, rapp);
//copyAll(fr, or);
3. Написать функцию, которая возвращает новую коллекцию, в которой находятся лишь те элементы
из входной коллекции, которые больше заданного (так же подается как параметр в функцию)
###Лабораторная работа №11 (Многопоточность)
Для данных заданий не использовать блоки синхронизации, использовать join и volatile
1. Написать программу для поиска простых чисел в n-потоках. Найденные простые числа просто
выводятся на экран.
2. Написать программу, суммирующую в n потоках ряд sin(k), где k пробегает целые числа от -N до N
3. Реализовать параллельную версию алгоритма сортировки слиянием (mergesort)
###Лабораторная работа №12 (Кольцевой буфер)
При реализации не использовать библиотеку java.util.concurrent
На основании шаблона Producer-Consumer 1 реализовать блокирующий кольцевой буфер на N
элементов 2 . Если буфер пуст, то читающие потоки должны ждать появления в нем элементов.
Если буфер заполнен, то пишущие потоки должны ждать удаление элементов.
Полезные ссылки:
1. Шаблон Producer-Consumer:
http://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html
2. Кольцевой буфер: http://en.wikipedia.org/wiki/Circular_buffer
