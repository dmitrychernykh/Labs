##Generics
 1.Написать функцию для копирования из массива в коллекцию того же типа, что и массив
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