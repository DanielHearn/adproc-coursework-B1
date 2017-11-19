/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpipes;

import java.util.*;
/**
 *
 * @author dan up801685
 */
public class Order {
    ArrayList<Pipe> orderedPipes = new ArrayList<>();
    
    public Order() {
        
    }
    
    /**
    * @param inputPipe The pipe being added to the order
    * @author Dan 801685
    */
    public void addPipe(Pipe inputPipe) {
        int orderPosition = orderedPipes.size();
        orderedPipes.add(orderPosition, inputPipe);
    }
    
    /**
    * @return The total cost of the order, generated from each pipes cost
    * @author Dan 801685
    */
    public double totalCost() {
        double totalCost = 0;
        for (int pipe = 0; pipe < orderedPipes.size(); pipe ++) {
            System.out.println("Calculating pipe: " + pipe);
            totalCost += orderedPipes.get(pipe).calculateCost();
        }
        return totalCost;
    }
        
    /** 
    * @return The number of individual orders within the order.
    * @author Dan 801685
    */ 
    public int getOrderedPipesLength() {
        return orderedPipes.size();
    }
    
    /**
    * Prints out each of the pipe details then the order total cost
    * @author Dan 801685
    * @return Return invoice details
    */
    public String getInvoice() {
        String totalCost = String.format("£%.2f", totalCost());
        return totalCost;
    }
    
    /**
    * 
    * @return The pipes within the ordered pipes arraylist
    */
    public ArrayList<Pipe> getOrderedPipes() {
        return orderedPipes;
    }
}
