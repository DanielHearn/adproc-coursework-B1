package longpipes;

import java.util.ArrayList;

/**
 * Class representing the link between the GUI class and order class Acting as
 * the program's main class
 *
 * @author Dan 801685
 * @author Lee 750834
 */
public class LongPipesSystem {

    public Order order = new Order();

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        LongPipesSystemGUI gui = new LongPipesSystemGUI();
        String[] argsGui = {};
        gui.main(argsGui); //Load the GUI
    }
    
    /**
     * Validates the input pipe and if valid add its to the order
     *
     * @param pipeLength the double representing the length of this pipe
     * @param pipeDiameter the double representing the outer diameter of this
     * pipe
     * @param pipeGrade the integer representing the plastic grade of this pipe
     * @param pipeColours the integer representing the number of colours being
     * used in this pipe
     * @param pipeInsulation the boolean representing if this pipe has inner
     * insulation
     * @param pipeReinforcement the boolean representing if this pipe has outer
     * reinforcement
     * @param pipeChemicalResistance the boolean representing if this pipe has
     * chemical resistance properties
     * @param pipeQuantity the integer representing the quantity of this pipe
     * being ordered
     * @return String indicating whether the input pipe is valid or not
     * @author Dan 801685
     */
    public boolean validateTypePipe(double pipeLength, double pipeDiameter, int pipeGrade, int pipeColours, Boolean pipeInsulation, Boolean pipeReinforcement, Boolean pipeChemicalResistance, int pipeQuantity) {

        boolean isPipeTypeValid = true;

        if ((pipeGrade >= 1 && pipeGrade <= 3) && (pipeColours == 0) && (pipeInsulation == false) && (pipeReinforcement == false)) {
            Pipe newPipe = new TypeOnePipe(pipeLength, pipeDiameter, pipeGrade, pipeChemicalResistance, pipeQuantity);
            order.addPipe(newPipe);
        } else if ((pipeGrade >= 2 && pipeGrade <= 4) && (pipeColours == 1) && (pipeInsulation == false) && (pipeReinforcement == false)) {
            Pipe newPipe = new TypeTwoPipe(pipeLength, pipeDiameter, pipeGrade, pipeColours, pipeChemicalResistance, pipeQuantity);
            order.addPipe(newPipe);
        } else if ((pipeGrade >= 2 && pipeGrade <= 5) && (pipeColours == 2) && (pipeInsulation == false) && (pipeReinforcement == false)) {
            Pipe newPipe = new TypeThreePipe(pipeLength, pipeDiameter, pipeGrade, pipeColours, pipeChemicalResistance, pipeQuantity);
            order.addPipe(newPipe);
        } else if ((pipeGrade >= 2 && pipeGrade <= 5) && (pipeColours == 2) && (pipeInsulation == true) && (pipeReinforcement == false)) {
            Pipe newPipe = new TypeFourPipe(pipeLength, pipeDiameter, pipeGrade, pipeColours, pipeInsulation, pipeChemicalResistance, pipeQuantity);
            order.addPipe(newPipe);
        } else if ((pipeGrade >= 3 && pipeGrade <= 5) && (pipeColours == 2) && (pipeInsulation == true) && (pipeReinforcement == true)) {
            Pipe newPipe = new TypeFivePipe(pipeLength, pipeDiameter, pipeGrade, pipeColours, pipeChemicalResistance, pipeQuantity);
            order.addPipe(newPipe);
        } else {
            isPipeTypeValid = false;
        }

        return isPipeTypeValid;
    }

    /**
     * Gets the validity of the pipe length
     *
     * @param pipeLength the pipe length
     * @return the validity of the pipe length
     * @author Dan 801685
     */
    public Boolean validatePipeLength(double pipeLength) {
        return !(pipeLength >= 0.5 && pipeLength <= 6);
    }

    /**
     * Gets the validity of the pipe diameter
     *
     * @param pipeDiameter the pipe diameter
     * @return the validity of the pipe diameter
     * @author Dan 801685
     */
    public Boolean validatePipeDiameter(double pipeDiameter) {
        return !(pipeDiameter >= 1 && pipeDiameter <= 6);
    }

    /**
     * Gets the validity of the pipe quantity
     *
     * @param pipeQuantity the pipe quantity
     * @return the validity of the pipe quantity
     * @author Dan 801685
     */
    public Boolean validatePipeQuantity(double pipeQuantity) {
        return !(pipeQuantity >= 1 && pipeQuantity <= 100);
    }

    /**
     * Gets the double representing the total cost of the order
     *
     * @return the total cost of the order
     * @author Dan 801685
     */
    public double orderTotalCost() {
        return order.totalCost();
    }

    /**
     * Gets the integer representing the total number of pipe orders within the
     * order
     *
     * @return the total cost of the order
     * @author Dan 801685
     */
    public int orderTotalOrders() {
        return order.getOrderedPipesLength();
    }

    /**
     * Gets the string representing the invoice text of the order
     *
     * @return the invoice text
     * @author Lee 750834
     */
    public String generateOrderInvoice() {
        return order.getInvoice(order.getOrderNumber());
    }

    /**
     * Gets the integer representing the order number
     *
     * @return the order number
     * @author Dan 801685
     */
    public int retrieveOrderNumber() {
        return order.getOrderNumber();
    }

    /**
     * Gets the ordered pipes arraylist from the order
     *
     * @return the ordered pipes arraylist
     * @author Dan 801685
     */
    public ArrayList<Pipe> getOrderedPipes() {
        return order.orderedPipes;
    }
    
    /**
     * Gets number of pipe orders from the ordered pipes arraylist in the order
     *
     * @return the length of ordered pipes
     * @author Dan 801685
     */
    public int getOrderedPipesSize() {
        return order.orderedPipes.size();
    }
}
