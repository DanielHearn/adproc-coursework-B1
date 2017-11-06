/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpipes;

import java.util.Scanner;

/**
 *
 * @author up801685
 */
public class LongPipes {
    static Scanner console = new Scanner(System.in);  
    static Order order = new Order();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Main interface and handling of inputs
        
        System.out.println("Welcome to the LongPipes ordering system");
        
        retrieveOrder();
        order.printInvoice();
        System.out.println("Thank you for using the LongPipes system.");
    }
    
    /**
     * Retrieves order from user
     */
    public static void retrieveOrder() {
        boolean answer;
        String again; 
        do {
            Pipe pipe = retrievePipeInputs();
            order.addPipe(pipe);
            System.out.println("\n Do you want to order another pipe (y/n)?");
            again = console.nextLine();      
            answer = false;    	// Boolean variable for the interactive input
            if (again.charAt(0) ==  'y') {
                answer = true; 	 // if data for another student is going to be entered
}
        }
        while (answer); 
    }
    
    /**
     * Retrieves pipe inputs and returns pipe
     */
    public static Pipe retrievePipeInputs() {
        
        //get pipe length in meters
        double pipeLength = retrieveLengthInput();
        
        //get diameter in inches
        double pipeDiameter = retrieveDiameterInput();
        
        //get grade of plastic
        
        //get colour (no colour, 1, or 2 colour plastic
        //get inner insulation
        //get outer reinforcement
        //get chemical resistance
        //get quantity of pipes
        
        System.out.println("Length: " + pipeLength);
        System.out.println("Diameter: " + pipeDiameter);
        
        //check if pipe can be supplied by longPipes, e.g invalid selections
            //if pipe can't be supplied reject order, and allow user to exit program or start again
           
        //if pipe valid continue 
        //evaluate pipe type
        //create pipe with corresponding type
        Pipe pipe = new Pipe(pipeLength, pipeDiameter);    
        
        return pipe;
    }
    
    /**
     * Retrieves input pipe length and return
     */
    public static double retrieveLengthInput() {
        boolean invalid = true;
        do {
            System.out.println("Length of the pipe in meters (0.1cm to 100m valid) ?");
            String lengthTemp = console.nextLine();    
            double length = Double.parseDouble(lengthTemp);
            if (length >= 0.1 && length <= 6) {
                return length;
            }
        }
        while (invalid);
        return 0;
    }
    
    public static double retrieveDiameterInput() {
        boolean invalid = true;
        do {
            System.out.println("Outer Diameter of the pipe in inches (1 to 5)?");
            String diameterTemp = console.nextLine();    
            double diameter = Double.parseDouble(diameterTemp);
            if (diameter >= 1 && diameter <= 5) {
                return diameter;
            }
        }
        while (invalid);
        return 0;
    }
    
}
