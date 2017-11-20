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
    
    public double PipeLength;
    public double PipeDiameter;
    public int PipeGrade;
    public int PipeColor;
    public int PipeQuantity;
    public Boolean PipeInsulation;
    public Boolean PipeRefinforcement;
    public Boolean PipeChemicalResistance;
   
    
    public LongPipesGUILink() {
        
    }
    
    /*
    * Validates the input pipe and if valid add its to the order
    * @return String indicating whether the input pipe is valid or not
    * @author Dan 801685
    */
    public String ValidatePipe(double pipeLength, double pipeDiameter, int pipeGrade, int pipeColors, Boolean pipeInsulation, Boolean pipeReinforcement, Boolean pipeChemicalResistance, int pipeQuantity) {
       
        boolean areInputsValid = true;
        String invalidText = "Pipe input is not valid due to: ";
        
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
        
        // DEBUG OUTPUT --
        System.out.println("--------------------------------------");
        System.out.println("Length: " + pipeLength);
        System.out.println("Diameter: " + pipeDiameter);
        System.out.println("Grade: " + pipeGrade);
        System.out.println("Color: " + pipeColors);
        System.out.println("Pipe insulation:  " + pipeInsulation);
        System.out.println("Pipe reinforcement: " + pipeReinforcement);
        System.out.println("Pipe chemical resistance: " + pipeChemicalResistance);
        System.out.println("Pipe quantity: " + pipeQuantity);

        Pipe pipe = new Pipe(pipeLength, pipeDiameter, pipeGrade, pipeColors, pipeInsulation, pipeReinforcement, pipeChemicalResistance, pipeQuantity);

        if(areInputsValid) {
            boolean isPipeTypeValid = true;
            
            
            if((pipeGrade >= 1 && pipeGrade <= 3) && (pipeColors == 0) && (pipeInsulation == false) && (pipeReinforcement == false)) {
                pipe = new TypeOnePipe(pipeLength, pipeDiameter, pipeGrade, pipeChemicalResistance, pipeQuantity);
            } else if ((pipeGrade >= 2 && pipeGrade <= 4) && (pipeColors == 1) && (pipeInsulation == false) && (pipeReinforcement == false)) {
                pipe = new TypeTwoPipe(pipeLength, pipeDiameter, pipeGrade, pipeColors, pipeChemicalResistance, pipeQuantity);  
            } else if ((pipeGrade >= 2 && pipeGrade <= 5) && (pipeColors == 2) && (pipeInsulation == false) && (pipeReinforcement == false)) {
                pipe = new TypeThreePipe(pipeLength, pipeDiameter, pipeGrade, pipeColors, pipeChemicalResistance, pipeQuantity);  
            } else if ((pipeGrade >= 2 && pipeGrade <= 5) && (pipeColors == 2) && (pipeInsulation == true) && (pipeReinforcement == false)) {
                pipe = new TypeFourPipe(pipeLength, pipeDiameter, pipeGrade, pipeColors, pipeChemicalResistance, pipeQuantity);  
            } else if ((pipeGrade >= 3 && pipeGrade <= 5) && (pipeColors == 2) && (pipeInsulation == true) && (pipeReinforcement == true)) {
                pipe = new TypeFivePipe(pipeLength, pipeDiameter, pipeGrade, pipeColors, pipeChemicalResistance, pipeQuantity);  
            } else {
                isPipeTypeValid = false;
            }
            
            if (isPipeTypeValid) {
                order.addPipe(pipe);  
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
    * 
    * @return The invoice
    */
    public String generateOrderInvoice(int orderNo) {
        return order.getInvoice(orderNo);
    }
    
    /**
    * 
    * @return The pipes within the ordered pipes arraylist
    */
    public ArrayList<Pipe> getOrderedPipes() {
        return order.orderedPipes;
    }
}
    
