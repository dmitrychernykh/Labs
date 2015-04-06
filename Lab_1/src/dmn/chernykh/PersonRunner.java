package dmn.chernykh;

/**
 * class PersonRunner gets information of person by @author DmitryChernykh
 */
public class PersonRunner {

    public static void main(String[] args) {

        Person newPerson = new Person("Ross", "Geller", 28);

        System.out.println("Name:\t\t" + newPerson.getName());
        System.out.println("Surname:\t" + newPerson.getSurName());
        System.out.println("Age:\t\t" + newPerson.getAge());

    }

}
