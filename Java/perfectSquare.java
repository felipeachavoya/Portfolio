import java.util.Scanner;

public class perfectSquare {
    public static void main(String...args) {
        System.out.println();
        System.out.println("Perfect Square Algorithm -- Felipe A. Chavoya");
        System.out.println("This is a program designed to take a natural number and return its perfect square.");
        System.out.println("The elements of the array also take into account the pattern observed when continously adding odd numbers");
        System.out.print("To start, please enter a natural number (WARNING: Try entering a number less than 6!): ");
        System.out.println();
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        System.out.println();
        generatePerfectSquare(input);
        scan.close();
    }

    public static void generatePerfectSquare(int input) {
        //Declare and generate the array
        int[][] squareArray = new int[input][input];
        //Populate array
        for (int i = 0; i < squareArray.length; i++) {
            for (int j = 0; j < squareArray[i].length; j++) {
                squareArray[i][j] = numberAssignment(i, j);
                System.out.print(" "+ squareArray[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        
    }

    //This function returns the integer which will be stored on the array generated based off its position.
    public static int numberAssignment(int i, int j) {
        int alpha = 2*i + 1;
        int beta = 2*j + 1;

        //This determines which value should be stored on any given coordinate based off of i and j. The greater value 
        //is always chosen, or if the values given are the same, alpha automatically is always given priority.
        if (alpha >= beta) {
            return alpha;
        } else {
            return beta;
        }
    }
}
