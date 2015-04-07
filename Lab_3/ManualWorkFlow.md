##   Лабораторная работа №3 (Пакеты)
## Цель. Работа с пакетами
###I.
#### 1. Создать из командной строки иерархию директорий для проекта из задания — по аналогии с примером:
+ **ShippingPrj/** - название проекта 
 + src/ - исходный код
 + build/classes
 + lib - библиотеки
 + docs - сгенерированная документация

**src/**
+ shipping/ - пакет
 + domain/ - пакет
 + gui/ - пакет
 + reports/ - пакет

**build/classes/** - откомпилированные классы
+ shipping/ - пакет
 + domain/ - пакет
 + gui/ - пакет
 + reports/ - пакет
   
чтобы сделать это в одно нажатие установим Ant и создадим в папке где будет лежать JavaProjects файл [build.xml](https://github.com/dmitrychernykh/Labs/blob/master/Lab_3/build.xml)

выполним команду 
```cmd
>ant 
```
и структура каталогов готова
####2. Написать класс ua.kpi.pti.HelloWorld
```cmd
\src>mkdir ua\kpi\pti
```
```java
 package ua.kpi.pti;

 public class HelloWorld{
 	public static void main(String[] args){
 		System.out.println("Hell in a world!!!");
 	}
 }
```
[HelloWorld.java](https://github.com/dmitrychernykh/Labs/blob/master/Lab_3/HelloWorld.java)
####3. Откомпилировать из командной строки и поместить в нужную папку build/classes
```cmd
C:\Lab_3\JavaProjects\ShippingPrj>javac -d build/classes src/ua/kpi/pti/HelloWorld.java
```
####4. Запустить программу
```cmd
C:\Lab_3\JavaProjects\ShippingPrj>java -classpath ./build/classes ua.kpi.pti.HelloWorld
Hell in a world!!!
```
####5. Откомпилировать с выводом информации о компиляции, посмотреть байт-код
```cmd
C:\Lab_3\JavaProjects\ShippingPrj>javap -c -classpath ./build/classes ua.kpi.pti.HelloWorld
Compiled from "HelloWorld.java"
public class ua.kpi.pti.HelloWorld {
  public ua.kpi.pti.HelloWorld();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #3                  // String Hell in a world!!!
       5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return
}
```
####6. Запустить программу с информацией о том, какие грузятся классы
```cmd
C:\Users\Alice\IdeaProjects\Labs\Lab_3\JavaProjects\ShippingPrj>java -verbose -classpath ./build/classes ua.kpi.pti.HelloWorld >D:\log.txt
```
грузится много класов JVM и в конце уже подгружается наш класс, выполняется, затем подгружаются классы завершающие JVM.
[log.txt](https://github.com/dmitrychernykh/Labs/blob/master/Lab_3/log.txt) - лог загрузки классов
### II.
####1. Написать класс ua.kpi.pti.PrintHello
 ```java
 package ua.kpi.pti;

 public class PrintHello{
 	public void printHello(){
 		System.out.println("Hell in a world!!!");
 	}
 }
```
[PrintHello.java](https://github.com/dmitrychernykh/Labs/blob/master/Lab_3/JavaProjects/ShippingPrj/PrintHello11.java)
####2. Модифицировать ua.kpi.pti.HelloWorld так, что бы он вызывал соответствующий. метод из ua.kpi.pti.PrintHello
 ```java
 package ua.kpi.pti;

 public class HelloWorld{
 	public static void main(String[] args){
 		PrintHello PH = new PrintHello();
 		PH.printHello();
 	}
 }
```
[HelloWorld.java](https://github.com/dmitrychernykh/Labs/blob/master/Lab_3/JavaProjects/ShippingPrj/HelloWorld1.java)
####3. Откомпилировать и запустить
```cmd
\ShippingPrj>javac -sourcepath src -d build/classes src/ua/kpi/pti/HelloWorld.java
\ShippingPrj>java -classpath ./build/classes ua.kpi.pti.HelloWorld
Hell in a world!!!
```
### III.
####1. Переместить класс PrintHello в ua.kpi.pti.pkg.PrintHello
Для этого помещаем его в отдельную папку pkg и меняем package
[pkg.PrintHello.java](https://github.com/dmitrychernykh/Labs/blob/master/Lab_3/JavaProjects/ShippingPrj/src/ua/kpi/pti/pkg/PrintHello.java)
####2. Модифицировать ua.kpi.pti.HelloWorld так, что бы он вызывал соответствующий метод из ua.kpi.pti.pkg.PrintHello
 ```java
 package ua.kpi.pti;

 import ua.kpi.pti.pkg.PrintHello;

 public class HelloWorld{
 	public static void main(String[] args){
 		PrintHello PH = new PrintHello();
 		PH.printHello();
 	}
 }
```
[HelloWorld.java](https://github.com/dmitrychernykh/Labs/blob/master/Lab_3/JavaProjects/ShippingPrj/src/ua/kpi/pti/HelloWorld.java)
####3. Откомпилировать и запустить
```cmd
>javac -sourcepath ./src -d build/classes src/ua/kpi/pti/HelloWorld.java
>java -classpath ./build/classes ua.kpi.pti.HelloWorld
Hell in a world!!!
```
### IV.
####1. Создать jar-файл с ua.kpi.pti.pkg.PrintHello и поместить его в lib
```cmd
>jar cvf .\lib\PrintHello.jar -C build\classes ua\kpi\pti\pkg\
added manifest
adding: ua/kpi/pti/pkg/(in = 0) (out= 0)(stored 0%)
adding: ua/kpi/pti/pkg/PrintHello.class(in = 428) (out= 297)(deflated 30%)
```
####2. Добиться работоспособности
```cmd
>javac -classpath lib/PrintHello.jar -d build/classes src/ua/kpi/pti/HelloWorld.java
>java -cp ./build/classes;./lib/PrintHello.jar ua.kpi.pti.HelloWorld
Hell in a world!!!
```
```cmd
>javap -verbose -cp ./build/classes;./lib/PrintHello.jar ua.kpi.pti.HelloWorld
Classfile /C:/Users/Alice/IdeaProjects/Labs/Lab_3/JavaProjects/ShippingPrj/build/classes/ua/kpi/pti/HelloWorld.class
  Last modified 07.04.2015; size 355 bytes
  MD5 checksum 923a9984f9f0d18d82803283392d151c
  Compiled from "HelloWorld.java"
public class ua.kpi.pti.HelloWorld
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #6.#15         // java/lang/Object."<init>":()V
   #2 = Class              #16            // ua/kpi/pti/pkg/PrintHello
   #3 = Methodref          #2.#15         // ua/kpi/pti/pkg/PrintHello."<init>":()V
   #4 = Methodref          #2.#17         // ua/kpi/pti/pkg/PrintHello.printHello:()V
   #5 = Class              #18            // ua/kpi/pti/HelloWorld
   #6 = Class              #19            // java/lang/Object
   #7 = Utf8               <init>
   #8 = Utf8               ()V
   #9 = Utf8               Code
  #10 = Utf8               LineNumberTable
  #11 = Utf8               main
  #12 = Utf8               ([Ljava/lang/String;)V
  #13 = Utf8               SourceFile
  #14 = Utf8               HelloWorld.java
  #15 = NameAndType        #7:#8          // "<init>":()V
  #16 = Utf8               ua/kpi/pti/pkg/PrintHello
  #17 = NameAndType        #20:#8         // printHello:()V
  #18 = Utf8               ua/kpi/pti/HelloWorld
  #19 = Utf8               java/lang/Object
  #20 = Utf8               printHello
{
  public ua.kpi.pti.HelloWorld();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 10: 0

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=1
         0: new           #2                  // class ua/kpi/pti/pkg/PrintHello
         3: dup
         4: invokespecial #3                  // Method ua/kpi/pti/pkg/PrintHello."<init>":()V
         7: astore_1
         8: aload_1
         9: invokevirtual #4                  // Method ua/kpi/pti/pkg/PrintHello.printHello:()V
        12: return
      LineNumberTable:
        line 18: 0
        line 19: 8
        line 20: 12
}
SourceFile: "HelloWorld.java"
```
####3. Показать, что ua.kpi.pti.pkg.PrintHello действительно грузиться из библиотеки
```cmd
>java -verbose -cp ./build/classes;./lib/PrintHello.jar ua.kpi.pti.HelloWorld
[много классов....]
[Loaded ua.kpi.pti.pkg.PrintHello from file:/C:/Users/Alice/IdeaProjects/Labs/La
b_3/JavaProjects/ShippingPrj/lib/PrintHello.jar]
Hell in a world!!!
```
видим __from file:/C:/.../lib/PrintHello.jar__
### V.
####Сгенерировать JavaDoc
```cmd
>javadoc -d docs -charset utf-8  -sourcepath src;lib/PrintHello.jar -author -subpackages ua.kpi.pti
Loading source files for package ua.kpi.pti...
Loading source files for package ua.kpi.pti.pkg...
Constructing Javadoc information...
Standard Doclet version 1.8.0_31
Building tree for all the packages and classes...
Generating docs\ua\kpi\pti\HelloWorld.html...
src\ua\kpi\pti\HelloWorld.java:17: warning: no @param for args
        public static void main(String[] args){
                           ^
Generating docs\ua\kpi\pti\pkg\PrintHello.html...
Generating docs\overview-frame.html...
Generating docs\ua\kpi\pti\package-frame.html...
Generating docs\ua\kpi\pti\package-summary.html...
Generating docs\ua\kpi\pti\package-tree.html...
Generating docs\ua\kpi\pti\pkg\package-frame.html...
Generating docs\ua\kpi\pti\pkg\package-summary.html...
Generating docs\ua\kpi\pti\pkg\package-tree.html...
Generating docs\constant-values.html...
Building index for all the packages and classes...
Generating docs\overview-tree.html...
Generating docs\index-all.html...
Generating docs\deprecated-list.html...
Building index for all classes...
Generating docs\allclasses-frame.html...
Generating docs\allclasses-noframe.html...
Generating docs\index.html...
Generating docs\overview-summary.html...
Generating docs\help-doc.html...
1 warning
```
[Result JavaDocs](https://github.com/dmitrychernykh/Labs/tree/master/Lab_3/JavaProjects/ShippingPrj/docs) прилагается
