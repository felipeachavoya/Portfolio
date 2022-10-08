import java.util.*;

public class linearRegression {
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String...args) {
        System.out.println("Linear Regression Model -- Felipe A. Chavoya");
        Menu();
    }

    private static void Menu() {
        System.out.println("Please make a selection from the following:");
        System.out.println("1.) Manually Input Data");
        System.out.println("2.) Load Data from File");
        int selection = keyboard.nextInt();

        switch (selection) {
            case 1:
                System.out.println("How many points?");
                System.out.println(processData(manualCollection()));
            case 2:
                loadFromFile();
        }
    }
    
    public static String processData(LinkedList<Points> data) {

        double sx = 0;
        double sy = 0;
        Iterator<Points> it = data.iterator();
        while (it.hasNext()) {
           Points point = it.next();
           sx += point.getX();
           sy += point.getY();
        }

        double sx2 = sx * sx;
        double syAvg = sy/data.size();
        double sxAvg = sx/data.size();
        double sx2Avg = sx2/data.size();
        double sxAvg2 = sxAvg * sxAvg;
        double sxyAvg = (sx * sy)/data.size();

        double det = sx2Avg - sxAvg2;
        double alpha = (sxyAvg - sxAvg * syAvg) / det;
        double beta = ((sx2Avg * syAvg) - (sxAvg * sxyAvg)) / det;


        return "y = " + alpha + "x + " + beta;
    }

    public static void manualInput() {


    }

    //This method handles the verification and collection of data provided by the user
    public static LinkedList<Points> manualCollection() {
        LinkedList<Points> data = new LinkedList<Points>();
        int limit = 0;
        boolean inputSuccessful = false;
        boolean notString = true;

        //This do-while is the main engine behind data collection
        do {

            //This initial part handles HOW MUCH data the program will collect.
            //The try-catch section checks to see if the user DIDN'T pass a double, string, or char.
            //If the user passes an invalid input, the notString boolean changes to true and rejects the input.

            try {
                String str = keyboard.next();
                limit = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                notString = false;
            }

            if (notString != true) {
                System.out.println("Not a valid input, please try again...");
                //Reset the notString boolean
                notString = false;
            } else if (limit < 2) {
                //Data with less than 3 points will be rejected.
                System.out.println("Not enough data, you will need more data...");
            } 
            
            //If the user passed a valid integer, the program begins the collection and delegation of data in a (x,y) point format.

            else {

                //This inital for loop builds and verifies each data point.
                for (int i = 1; i <= limit; i++) {
                    double x;
                    double y;

                    System.out.println("Point " + i);
                    System.out.println();
                    System.out.print("Enter a decimal value for X: ");
                    x = checkInput();
                    System.out.println();
                    System.out.print("Enter a decimal value for Y: ");
                    y = checkInput();
                    System.out.println();

                    //If the user provided decimal or integer numbers, the program makes a new Poin object and assigns its x and y value.
                    Points point = new Points(x, y);
                    data.add(point);
                }
                inputSuccessful = true;
            }
        } while (inputSuccessful != true);
        return data;
    }

    public static void loadFromFile() {

    }

    public static Double checkInput() {
        boolean inputSuccessful = false;
        boolean notString = true;
        double d1 = 0;

        do {
            try {
                String str = keyboard.next();
                d1 = Double.parseDouble(str);
            } catch (NumberFormatException e) {
                notString = false;
            }

            if (notString != true) {
                notString = true;
                System.out.println("Not a valid input, try again...");
                
            } else {
                inputSuccessful = true;
            }
        } while (inputSuccessful != true);
        return d1;
    }

    public enum Error {
        INVALID_INPUT(0, "Unexpected input.");

        private final int code;
        private final String description;
        
        private Error(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public int getCode() {
            return code;
        }

        @Override
        public String toString() {
            return code + ": " + description;
        }
    }
}
