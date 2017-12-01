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
     * Gets the double representing the total cost of the order
     *
     * @return the total cost of the order
     * @author Dan 801685
     */
    public double getTotalOrderCost() {
        return order.totalCost();
    }

    /**
     * Gets the integer representing the total number of pipe orders within the
     * order
     *
     * @return the total cost of the order
     * @author Dan 801685
     */
    public int getTotalPipeOrders() {
        return order.getOrderedPipesLength();
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
     * @return string indicating whether the input pipe is valid or not
     * @author Dan 801685
     */
    public String validateTypePipe(double pipeLength, double pipeDiameter, int pipeGrade, int pipeColours, Boolean pipeInsulation, Boolean pipeReinforcement, Boolean pipeChemicalResistance, int pipeQuantity) {

        boolean isPipeTypeValid = false;
        String invalidText = "";
    
        if(pipeInsulation) {
            if(pipeGrade >= 2 && pipeGrade <= 5) {
                if(pipeColours == 2) {
                    if(pipeReinforcement) {
                        if(pipeGrade >= 3) {
                                Pipe newPipe = new TypeFivePipe(pipeLength, pipeDiameter, pipeGrade, pipeColours, pipeChemicalResistance, pipeQuantity);
                                order.addPipe(newPipe);
                                isPipeTypeValid = true;
                        } else {
                            invalidText = "Outer Reinforcement is not valid with a plastic grade of 1 or 2.";
                        }
                    } else {
                        Pipe newPipe = new TypeFourPipe(pipeLength, pipeDiameter, pipeGrade, pipeColours, pipeInsulation, pipeChemicalResistance, pipeQuantity);
                        order.addPipe(newPipe);
                        isPipeTypeValid = true;
                    }
                } else {
                    invalidText = "Pipe colours of 0 or 1 are not valid with inner insulation.";
                }
            } else {
                invalidText = "Pipe grade of 1 is not valid with inner insulation.";
            } 
        } else {
            if(pipeColours == 0) {
                if(pipeGrade >= 1 && pipeGrade <= 3) {
                    if(!pipeReinforcement) {
                        Pipe newPipe = new TypeOnePipe(pipeLength, pipeDiameter, pipeGrade, pipeChemicalResistance, pipeQuantity);
                        order.addPipe(newPipe);
                        isPipeTypeValid = true;
                    } else {
                        invalidText = "Pipe colour of 0 is not valid with outer reinforcement.";
                    }
                } else {
                    invalidText = "Pipe colour of 0 is not valid with a plastic grade of 4 or 5.";
                }
            } else {
                if(pipeColours == 1) {
                    if(pipeGrade >= 2 && pipeGrade <= 4) {
                        if(!pipeReinforcement) {
                            Pipe newPipe = new TypeTwoPipe(pipeLength, pipeDiameter, pipeGrade, pipeColours, pipeChemicalResistance, pipeQuantity);
                            order.addPipe(newPipe);
                            isPipeTypeValid = true;
                        } else {
                            invalidText = "Pipe colour of 0 is not valid with outer reinforcement.";
                        }
                    } else {
                        invalidText = "Pipe colour of 1 is not valid with a plastic grade of 1 or 5.";
                    }   
                } else {
                    if(pipeGrade >= 2) {
                        if(!pipeReinforcement) {
                            Pipe newPipe = new TypeThreePipe(pipeLength, pipeDiameter, pipeGrade, pipeColours, pipeChemicalResistance, pipeQuantity);
                            order.addPipe(newPipe);
                            isPipeTypeValid = true;
                        } else {
                            invalidText = "Outer reinforement is only valid with inner insulation. ";
                        }
                    } else {
                        invalidText = "Pipe colour of 2 is not valid with a plastic grade of 1.";
                    }   
                }
            }
        }
        
        if (invalidText.isEmpty()) {
            invalidText = "Input pipe specifications do meet any of our available pipe types.";
        }

        if(isPipeTypeValid) {
            return "Valid";
        } else {
            return invalidText;
        }
    }

    /**
     * Calls the order to remove the input pipe based on the arraylist index
     *
     * @param pipeIndex the pipe index 
     * @author Dan 801685
     */
    public void removePipe(int pipeIndex) {
        order.removePipe(pipeIndex);
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
    public int getOrderNumber() {
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
