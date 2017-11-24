/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpipes;

import java.util.ArrayList;

/**
 *
 * @author up750834
 */
public class LongPipesGUILink {
    
    public Order order = new Order();
    
    public LongPipesGUILink() {
        
    }
    
    /*
    * Validates the input pipe and if valid add its to the order
    * @return String indicating whether the input pipe is valid or not
    * @author Dan 801685
    */
    public String ValidatePipe(double pipeLength, double pipeDiameter, int pipeGrade, int pipeColours, Boolean pipeInsulation, Boolean pipeReinforcement, Boolean pipeChemicalResistance, int pipeQuantity) {
       
        boolean areInputsValid = true;
        String invalidText = "Pipe input is not valid due to the following inputs: ";
        
        if (!(pipeLength >= 0.5 && pipeLength <= 6)) {
            areInputsValid = false;
            invalidText += "pipe length, ";
        }
        
        if (!(pipeDiameter >= 1 && pipeDiameter <= 5)) {
            areInputsValid = false;
            invalidText += "pipe diameter, ";
        }
        
        if (!(pipeQuantity >= 1 && pipeQuantity <= 100)) {
            areInputsValid = false;
            invalidText += "pipe quantity, ";
        }

        if(areInputsValid) {
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
                Pipe newPipe = new TypeFourPipe(pipeLength, pipeDiameter, pipeGrade, pipeColours, pipeChemicalResistance, pipeQuantity);  
                order.addPipe(newPipe);  
            } else if ((pipeGrade >= 3 && pipeGrade <= 5) && (pipeColours == 2) && (pipeInsulation == true) && (pipeReinforcement == true)) {
                Pipe newPipe = new TypeFivePipe(pipeLength, pipeDiameter, pipeGrade, pipeColours, pipeChemicalResistance, pipeQuantity);  
                order.addPipe(newPipe);  
            } else {
                isPipeTypeValid = false;
            }
            
            if (isPipeTypeValid) {
                return "Pipe added to basket"; 
            } else {
                return "Pipe specifications do meet any of our available pipe types"; 
            }

        } else {
            return invalidText;
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
    */
    public String generateOrderInvoice() {
        return order.getInvoice(order.getOrderNumber());
    }
    
    /**
    * @return The order number
    */
    public Integer retrieveOrderNumber() {
        return order.getOrderNumber();
    }
    
    /**
    * 
    * @return The pipes within the ordered pipes arraylist
    */
    public ArrayList<Pipe> getOrderedPipes() {
        return order.orderedPipes;
    }
}
    
