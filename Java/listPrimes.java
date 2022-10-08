import java.util.Stack;
import java.util.Scanner;

public class listPrimes {
    public static void main(String...args) {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Prime Number List -- Felipe A. Chavoya");
        System.out.print("Please enter the range here: ");
        int input = scan.nextInt();
        System.out.println();
        generateList(input);
        scan.close();
    }

    //This method will list all numbers less than the given input that are NOT prime numbers.
    public static void generateList(int input) {
        Stack<Integer> nonPrimes = new Stack<Integer>();
        //Stack<Integer> primeStack = new Stack<Integer>();

        //This for loop only pushes products of two into the nonPrimes stack.
        //for (int i = 2; i <= Math.floor(input/2); i++) {
        //    nonPrimes.push(2*i);
        //}

        //int roof = (int) Math.floor(Math.sqrt(input));

        //This for loop will push the rest of all non prime numbers into the stack without generating repeats
        for (int i = 2; i <= 1 + Math.floor(Math.sqrt(input)); i++) {
            //This if statement checks if the number we are using to find non primes IS NOT on the nonPrime stack.
            if (nonPrimes.contains(i) == false || nonPrimes.isEmpty() == true) {
                for (int j = 2; j <= Math.floor(input/i); j++) {

                    //This if statement is what filters out all the repeat non prime numbers
                    if (nonPrimes.contains(i * j) == false) {
                        nonPrimes.push(i * j);
                    } else continue;
                }
            } else continue;
        }

        for (int i = 2; i <= input; i++) {
            if (nonPrimes.contains(i) == false) {
                System.out.print(" " + i);
            } else continue;
        }
        System.out.println();
        System.out.println();
    }
}
