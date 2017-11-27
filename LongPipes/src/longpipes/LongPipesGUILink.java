package longpipes;

import java.util.ArrayList;

/**
 * @author Dan 801685
 * @author Lee 750834
 */
public class LongPipesGUILink {
    
    public Order order = new Order();
    
    public LongPipesGUILink() {}
    
    /*
     * Validates the input pipe and if valid add its to the order
     * @return String indicating whether the input pipe is valid or not
     * @author Dan 801685
     */
    public boolean validateTypePipe(double pipeLength, double pipeDiameter, int pipeGrade, int pipeColours, Boolean pipeInsulation, Boolean pipeReinforcement, Boolean pipeChemicalResistance, int pipeQuantity) {

        boolean isPipeTypeValid = true;

        if((pipeGrade >= 1 && pipeGrade <= 3) && (pipeColours == 0) && (pipeInsulation == false) && (pipeReinforcement == false)) {
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

        if (isPipeTypeValid) {
            return true; 
        } else {
            return false; 
        }

    }
    
    /** 
     * @return The total cost of the order
     * @author Dan 801685
     */ 
    public double orderTotalCost() {
        return order.totalCost();
    }
    
    /** 
     * @return The number of individual orders within the order.
     * @author Dan 801685
     */ 
    public int orderTotalOrders() {
        return order.getOrderedPipesLength();
    }
    
    /**
     * @return The invoice text
     * @author Lee 750834
     */
    public String generateOrderInvoice() {
        return order.getInvoice(order.getOrderNumber());
    }
    
    /**
     * @return The order number
     * @author Dan 801685
     */
    public Integer retrieveOrderNumber() {
        return order.getOrderNumber();
    }
    
    /**
     * @return The pipes within the ordered pipes arraylist
     * @author Dan 801685
     */
    public ArrayList<Pipe> getOrderedPipes() {
        return order.orderedPipes;
    }
    
}
    
