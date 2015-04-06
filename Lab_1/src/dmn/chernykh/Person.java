package dmn.chernykh;

/**
 * class Person by @author DmitryChernykh
 */
public class Person {
    private String name;
    private String surname;
    private int age;

    /**
     * make a new Person with data information
     *
     * @param name    person's name
     * @param surname person's surname
     * @param age     person's age
     */
    Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    /**
     * getting Person's name
     */
    public String getName() {
        return name;
    }

    /**
     * getting Person's surname
     */
    public String getSurName() {
        return surname;
    }

    /**
     * getting Person's age
     */
    public int getAge() {
        return age;
    }

}
