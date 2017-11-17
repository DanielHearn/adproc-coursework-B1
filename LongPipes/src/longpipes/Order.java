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
    ArrayList<Pipe> orderedPipes = new ArrayList<Pipe>();
    
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
    public int totalOrders() {
        return orderedPipes.size();
    }
    
    /**
    * Prints out each of the pipe's details then the order's total cost
    * @author Dan 801685
    */
    public void printInvoice() {
        for (int pipe = 0; pipe < orderedPipes.size(); pipe ++) {
            Pipe currentPipe = orderedPipes.get(pipe);
            currentPipe.printDetails();
        }
        System.out.println("Total Order Cost: " + totalCost());
    }
}
