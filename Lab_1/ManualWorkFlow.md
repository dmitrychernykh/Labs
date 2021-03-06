##   Лабораторная работа No1 (Команды)
## Цель. Познакомиться с командами javac, javap, java, javadoc
###I.
#### 1. Найти где установлена Java
Java установлена C:\Program Files\Java\jdk1.8.0_31\bin
#### 2. Узнать версию Java:
```cmd
>java -version
java version "1.8.0_40"
Java(TM) SE Runtime Environment (build 1.8.0_40-b26)
Java HotSpot(TM) Client VM (build 25.40-b25, mixed mode, sharing)
```
#### 3. Узнать значение переменной окружения JAVA_HOME
```cmd
>echo %JAVA_HOME%
C:\Program Files\Java\jdk1.8.0_31
```
###II.
#### 1. Попытаться откомпилировать примеры из src.zip
```cmd
>cd C:\Users\Alice\JavaProjCL
>mkdir bin
>javac -d bin src/Test1.java
>java -classpath ./bin Test1
>javac -d bin src/Test2.java
>java -classpath ./bin Test2
>javac -d bin src/Test3.java
>java -classpath ./bin Test3
>javac -d bin src/Test4.java
>java -classpath ./bin Test4
```
#### 2. Сказать, что в них неправильно и добиться их работоспособности
* Тест1 - нельзя распологать 2 публичных класса в одном файле. Исправляется, например удалением класса TestAnother1 из файла
* Тест2 - Имя класса должно совпадать с именем файла. Исправляем имя класса.
* Тест3 - неверная сигнатура метода main. Исправляем аргумент метода на 'String[] args'
* Тест4 - метод main объявлен как метод объекта а не класса. Должен быть статическим.

###### Создать следующую иерархию папок:
* src/ - исходный код
 * classes/ - откомпилированные классы
* docs/ - JavaDoc'
```cmd
>cd C:\Users\Alice\IdeaProjects\Labs
>mkdir Lab_1
>cd Lab_1
>mkdir src
>mkdir build
>mkdir docs
>cd build
>mkdir classes
>cd ..
```
###III.
#### 1. Написать класс Person, в котором хранилась бы имя, фамилия и дата рождения человека (в виде строки). Поместить файл с классом в папку src.
```Java
public class Person { 
	private String name;
	private String surname;
	private int age;
	
	Person(String name, String surname, int age){
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	public String getName(){
		return name;
	}
	public String getSurName(){
		return surname;
	}
	public int getAge(){
		return age;
	}
}
```
#### 2. Написать класс PersonRunner в котором задавались бы атрибуты для человека, а затем выводились 
```Java
public class PersonRunner { 

	public static void main(String[] args) { 
    	
    	Person newPerson = new Person("Ross", "Geller", 28);

    	System.out.println("Name:\t\t"+newPerson.getName());
		  System.out.println("Surname:\t"+newPerson.getSurName());
		  System.out.println("Age:\t\t"+newPerson.getAge());
  	}
}
```
#### 3. Откомпилировать PersonRunner из командной строки так, чтобы файлы *.class писались в папку 
```cmd
>javac -d build/classes src/Person.java
>javac -sourcepath src -d build/classes src/PersonRunner.java
```
#### 4. Запустить программу.
```cmd
>java -classpath ./build/classes PersonRunner
Name:           Ross
Surname:        Geller
Age:            28
```
#### 5. Откомпилировать еще раз с выводом информации о компиляции, посмотреть полученный байт-код
```cmd
>javap -c -classpath ./build/classes PersonRunner
Compiled from "PersonRunner.java"
public class PersonRunner {
  public PersonRunner();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #2                  // class Person
       3: dup
       4: ldc           #3                  // String Ross
       6: ldc           #4                  // String Geller
       8: bipush        28
      10: invokespecial #5                  // Method Person."<init>":(Ljava/lang/String;Ljava/lang/String;I)V
      13: astore_1
      14: getstatic     #6                  // Field java/lang/System.out:Ljava/io/PrintStream;
      17: new           #7                  // class java/lang/StringBuilder
      20: dup
      21: invokespecial #8                  // Method java/lang/StringBuilder."<init>":()V
      24: ldc           #9                  // String Name:\t\t
      26: invokevirtual #10                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      29: aload_1
      30: invokevirtual #11                 // Method Person.getName:()Ljava/lang/String;
      33: invokevirtual #10                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      36: invokevirtual #12                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      39: invokevirtual #13                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      42: getstatic     #6                  // Field java/lang/System.out:Ljava/io/PrintStream;
      45: new           #7                  // class java/lang/StringBuilder
      48: dup
      49: invokespecial #8                  // Method java/lang/StringBuilder."<init>":()V
      52: ldc           #14                 // String Surname:\t
      54: invokevirtual #10                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      57: aload_1
      58: invokevirtual #15                 // Method Person.getSurName:()Ljava/lang/String;
      61: invokevirtual #10                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      64: invokevirtual #12                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      67: invokevirtual #13                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      70: getstatic     #6                  // Field java/lang/System.out:Ljava/io/PrintStream;
      73: new           #7                  // class java/lang/StringBuilder
      76: dup
      77: invokespecial #8                  // Method java/lang/StringBuilder."<init>":()V
      80: ldc           #16                 // String Age:\t\t
      82: invokevirtual #10                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      85: aload_1
      86: invokevirtual #17                 // Method Person.getAge:()I
      89: invokevirtual #18                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      92: invokevirtual #12                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      95: invokevirtual #13                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      98: return
}
```
#### 6. Запустить программу с информацией о том, какие грузятся классы
```cmd
>java -verbose -classpath ./build/classes PersonRunner>D:\log.txt
```
[log.txt](https://github.com/dmitrychernykh/Labs/blob/master/Lab_1/log.txt) прилагается
```cmd
>javap -sysinfo -classpath ./build/classes PersonRunner
Classfile /C:/Users/Alice/IdeaProjects/Labs/Lab_1/build/classes/PersonRunner.class
  Last modified 05.04.2015; size 895 bytes
  MD5 checksum 4c0441fdfdb9f921dfa784ab398d3064
  Compiled from "PersonRunner.java"
public class PersonRunner {
  public PersonRunner();
  public static void main(java.lang.String[]);
}
```
#### 7. Сгенерировать JavaDoc в папку docs

подготовка: добавим каталоги пакетов и заголовок в файлы классов.

```cmd
>cd src
src>mkdir dmn\chernykh
src>move Person.java dmn\chernykh
Перемещено файлов:         1.
src>move PersonRunner.java dmn\chernykh
Перемещено файлов:         1.
src>cd ..

>javadoc -d docs -charset utf-8 -sourcepath src -subpackages dmn.chernykh
Loading source files for package dmn.chernykh...
Constructing Javadoc information...
Standard Doclet version 1.8.0_31
Building tree for all the packages and classes...
Generating docs\dmn\chernykh\Person.html...
src\dmn\chernykh\Person.java:26: warning: no @return
        public String getName(){
                      ^
src\dmn\chernykh\Person.java:32: warning: no @return
        public String getSurName(){
                      ^
src\dmn\chernykh\Person.java:38: warning: no @return
        public int getAge(){
                   ^
Generating docs\dmn\chernykh\PersonRunner.html...
Generating docs\dmn\chernykh\package-frame.html...
Generating docs\dmn\chernykh\package-summary.html...
Generating docs\dmn\chernykh\package-tree.html...
Generating docs\constant-values.html...
Building index for all the packages and classes...
Generating docs\overview-tree.html...
Generating docs\index-all.html...
Generating docs\deprecated-list.html...
Building index for all classes...
Generating docs\allclasses-frame.html...
Generating docs\allclasses-noframe.html...
Generating docs\index.html...
Generating docs\help-doc.html...
3 warnings
```
[Result JavaDocs](https://github.com/dmitrychernykh/Labs/tree/master/Lab_1/docs) прилагается
