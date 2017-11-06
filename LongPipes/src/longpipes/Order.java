/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpipes;

import java.util.*;
/**
 *
 * @author hearn
 */
public class Order {
    ArrayList<Pipe> orderedPipes = new ArrayList<Pipe>();
    
    public Order() {
        
    }
    
    public void addPipe(Pipe inputPipe) {
        int orderPosition = orderedPipes.size();
        orderedPipes.add(orderPosition, inputPipe);
    }
    
    public double totalCost() {
        double totalCost = 0;
        for (int pipe = 0; pipe < orderedPipes.size(); pipe ++) {
            totalCost += orderedPipes.get(pipe).calculateCost();
        }
        return totalCost;
    }
    
    public void printInvoice() {
        for (int pipe = 0; pipe < orderedPipes.size(); pipe ++) {
            Pipe currentPipe = orderedPipes.get(pipe);
            System.out.println("----------------------------------");         
            System.out.println("Pipe: " + pipe);
            System.out.println("Length: " + currentPipe.getLength());
            System.out.println("Diameter: " + currentPipe.getDiameter());
            System.out.println("----------------------------------"); 
        }
        System.out.println("Total Order Cost: " + totalCost());
    }
}
