import java.util.Scanner;

/**
 * Created by Dmitry Chernykh on 04.04.2015.
 */
public class CommonUseLibrary {
    public static final int readUserInput(String message) {
        Scanner scan = new Scanner(System.in);
        System.out.print(message);
        return scan.nextInt();
    }
}
