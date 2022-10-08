import java.util.*;

public class example {
    public static void main(String...args) {
        getInput();
    }

    private static void getInput() {
        Scanner keyboard = new Scanner(System.in);
        do {
            String input = keyboard.nextLine();
            if (input.length() == 0) {
                System.out.println("Input is empty");
                break;
            } else {
                System.out.println("Input is not empty");;
            }
        } while (true);
    }
}
