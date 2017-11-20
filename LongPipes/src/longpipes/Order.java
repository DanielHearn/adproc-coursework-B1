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
        for (int pipe = 0; pipe < orderedPipes.size(); pipe++) {
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
     * @author Lee 750834
     * @return Return invoice details
     */
    public String getInvoice(int orderNo) {
        String invoice = "";
        
        String _innerInsulation = formatInvoice("Inner Insulation:", 40) + "£34.56";
        String _outerReinforcement = formatInvoice("Outter Reinforcement:", 40) + "£23.34";
        String _chemicalResistance = formatInvoice("Chemical Resistance:", 40) + "£11:33";
        
        String _totalCostOfPipe = formatInvoice("Total Cost of Pipe:", 40) + "£12.34";
        String _additionalFeatures = formatInvoice("Additional Features:", 40) + "£23.45";
        String _orderTotal = String.format("£%.2f", totalCost());
        _orderTotal = formatInvoice("Total Cost:", 40) + _orderTotal;
        
        String _LINEBREAK = "";
        String _orderRef = formatInvoice("Order Ref No:", 40) + "00" + Integer.toString(orderNo);
        String[] _dateTime = LongPipesSystem.getDateTime();
        String _date = formatInvoice("Date:", 40) + _dateTime[0];
        String _time = formatInvoice("Time:", 40) + _dateTime[1];
        String _thankyou = "             Thanks for shopping with LongPipes";
        
        String[] lines = {_totalCostOfPipe, _additionalFeatures, _orderTotal, _LINEBREAK, _orderRef, _date, _time, _thankyou};
        for (int i = 0; i < lines.length; i++) {
            invoice +=  lines[i] + "\n";
        }
        return invoice;
    }

    /**
     * @author Lee 750834
     * @return Returns a formated string
     */
    public static String formatInvoice(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    /**
     * @return The pipes within the ordered pipes arraylist
     */
    public ArrayList<Pipe> getOrderedPipes() {
        return orderedPipes;
    }
}
