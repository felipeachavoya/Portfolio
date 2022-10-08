import java.util.Scanner;

public class calculator{
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please Enter a Value: ");
        double input = scan.nextInt();
        evenorodd(input);
        perfectSquare(input);
        checkIfPrime(input);
        scan.close();
    }

    public static void evenorodd(double input) {
        if (input == 1 || input % 2 == 1) {
            System.out.println(input + " is odd.");
        } else {
            System.out.println(input + " is even");
        }
    }

    public static void perfectSquare(double input) {
        double root = Math.sqrt(input);
        if (root - Math.floor(root) == 0) {
            System.out.println(input + " is a perfect square.");
        } else {
            System.out.println(input + " is not a perfect square.");
        }
    }

    public static void checkIfPrime(double input) {

    }
}