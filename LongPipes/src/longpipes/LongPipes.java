package longpipes;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author up750834
 * @author up801685
 */
public class LongPipes {

    static Scanner console = new Scanner(System.in);
    static Order order = new Order();

    // Program entry point
    public static void main(String[] args) {
        // Main interface and handling of inputs

        System.out.println("Welcome to the LongPipes ordering system");

        getOrder();
        order.printInvoice();
        System.out.println("Thank you for using the LongPipes system.");
    }

    // Gets a new order from the user
    public static void getOrder() {
        boolean answer;
        String again;
        do {
            Pipe pipe = getPipeInputs();
            order.addPipe(pipe);
            System.out.println("\n Do you want to order another pipe (y/n)?");
            again = console.nextLine();
            answer = false; // Boolean variable for the interactive input
            if (again.charAt(0) == 'y') {
                answer = true; // if data for another student is going to be entered
            }
        } while (answer);
    }

    // Returns the pipe inputs and returns pipe
    // Refactored: Lee 750834
    // Refactored: 06/11/2017
    public static Pipe getPipeInputs() {
        double pipeLength = getLengthInput();                              // gets pipe length in meters
        double pipeDiameter = getOuterDiameterInput();                     // gets diameter in inches
        String[] pipeColors = getPipeColors();                             // gets pipe colors
        // Boolean pipeInsulation = getInsulation();                       // gets pipe insulation
        // Boolean pipeReinforcement = getReinforcement();                 // gets pipe reinforcement
        // Boolean pipeChemicalResistance = getChemicalResistance()        // gets pipe reinforcement
        Boolean pipeInsulation = getBoolConditional("[TRUE/FALSE] Would you like insulation on your pipes");
        Boolean pipeReinforcement = getBoolConditional("[TRUE/FALSE] would you like reinforced pipes?");
        Boolean pipeChemicalResistance = getBoolConditional("[TRUE/FALSE] would you like chemical resitance pipes?");

        //get grade of plastic
        //get quantity of pipes
        // DEBUG OUTPUT --
        System.out.println("Length: " + pipeLength);
        System.out.println("Diameter: " + pipeDiameter);
        for (String s : pipeColors) {
            System.out.println("Color: " + s);
        }
        System.out.println("pipe insulation:  " + pipeInsulation);
        System.out.println("pipe reinforcement: " + pipeReinforcement);
        System.out.println("pipe chemical resistance: " + pipeChemicalResistance);

        //check if pipe can be supplied by longPipes, e.g invalid selections
        //if pipe can't be supplied reject order, and allow user to exit program or start again
        //if pipe10 valid continue 
        //evaluate pipe type
        //create pipe with corresponding type
        //   Pipe pipe = new Pipe(pipeLength, pipeDiameter, );
        Pipe pipe = new Pipe();

        return pipe;
    }

    // Returns the lenght of the pipe
    public static double getLengthInput() {
        boolean invalid = true;
        do {
            System.out.println("Length of the pipe in meters (0.1cm to 100m valid) ?");
            String lengthTemp = console.nextLine();
            double length = Double.parseDouble(lengthTemp);
            if (length >= 0.1 && length <= 6) {
                return length;
            }
        } while (invalid);
        return 0;
    }

    // Returns outer diameter of pipe
    public static double getOuterDiameterInput() {
        boolean invalid = true;
        do {
            System.out.println("Outer Diameter of the pipe in inches (1 to 5)?");
            String diameterTemp = console.nextLine();
            double diameter = Double.parseDouble(diameterTemp);
            if (diameter >= 1 && diameter <= 5) {
                return diameter;
            }
        } while (invalid);
        return 0;
    }

    // Returns an array of colors for the pipes
    // Created by: Lee 750834
    // Date: 06/11/2017
    public static String[] getPipeColors() {
        boolean invalid = true;
        do {
            List<String> colors = Arrays.asList("red", "orange", "yellow", "green", "blue", "violet", "pink", "cyan");
            System.out.println("How many colors of pipe? (0..2)");
            String _tmpAmount = console.nextLine();
            int amount = Integer.parseInt(_tmpAmount);

            switch (amount) {
                case 0: {
                    return new String[]{"null"};
                }
                case 1: {
                    System.out.println("Enter a color");
                    String color1 = console.nextLine();
                    boolean contains = colors.contains(color1);
                    if (contains) {
                        return new String[]{color1};
                    } else {
                        return new String[]{"red"};
                    }
                }
                case 2: {
                    System.out.println("Enter color [1]");
                    String color1 = console.nextLine();

                    System.out.println("Enter color [2]");
                    String color2 = console.nextLine();

                    boolean contains = colors.contains(color1) && colors.contains(color2);
                    if (contains) {
                        return new String[]{color1, color2};
                    } else {
                        return new String[]{"red", "blue"};
                    }
                }
            }
        } while (invalid);
        return new String[]{};
    }

    // Returns: a bool condition for insulation
    // Created by: Lee 750834
    // Date: 06/11/2017
    public static Boolean getInsulation() {
        boolean invalid = true;
        do {
            System.out.println("[TRUE/FALSE] Would you like insulation on your pipes");
            String _tmpBool = console.nextLine();
            boolean result = Boolean.parseBoolean(_tmpBool);
            return result;
        } while (invalid);
    }

    // Returns: a bool condition for reinforcement
    // Created by: Lee 750834
    // Date: 06/11/2017
    public static Boolean getReinforcement() {
        boolean invalid = true;
        do {
            System.out.println("[TRUE/FALSE] would you like reinforced pipes?");
            String _tmpBool = console.nextLine();
            boolean result = Boolean.parseBoolean(_tmpBool);
            return result;
        } while (invalid);
    }

    // Returns: a bool condition for chemical resistance
    // Created by: Lee 750834
    // Date: 06/11/2017
    public static Boolean getChemicalResistance() {
        boolean invalid = true;
        do {
            System.out.println("[TRUE/FALSE] would you like chemical resitance pipes?");
            String _tmpBool = console.nextLine();
            boolean result = Boolean.parseBoolean(_tmpBool);
            return result;
        } while (invalid);
    }

    // Returns: a bool condition
    // Parameters: string output for console
    // Notes: this just replaces the 3x bool functions above into one that can be re-used.
    // Created by: Lee 750834
    // Date: 06/11/2017
    public static Boolean getBoolConditional(String consoleOutput) {
        boolean invalid = true;
        do {
            System.out.println(consoleOutput);
            String _tmpBool = console.nextLine();
            boolean result = Boolean.parseBoolean(_tmpBool);
            return result;
        } while (invalid);
    }
}
