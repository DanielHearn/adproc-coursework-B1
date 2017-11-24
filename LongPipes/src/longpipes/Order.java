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
    private int orderNumber;

    public Order() {
        orderNumber = 1;
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
            totalCost += orderedPipes.get(pipe).calculateTotalCost();
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
     * @param currentPipe The current pipe
     * @param currentPipeType The current pipe type
     * @param inputString The main string content
     * @param inputDouble The double value to be placed at the end of the string
     * @return The string formatted for use in the invoice based on pipe details
     * @author Dan 801685
     */
    public String generateInvoicePipeString(Pipe currentPipe, String currentPipeType, String inputString, double inputDouble) {
        String startString = currentPipeType + ": " + inputString + ": ";
        String formattedNumber = String.format("£%.2f", inputDouble);
        String invoiceString = formatInvoice(startString) + formattedNumber;
        return invoiceString;
    }
    
    
    public String generateInvoicePipeString(Pipe currentPipe, String currentPipeType, String inputString, int inputInt) {
        String startString = currentPipeType + ": " + inputString + ": ";
        String formattedNumber = Integer.toString(inputInt);
        String invoiceString = formatInvoice(startString) + formattedNumber;
        return invoiceString;
    }
    
    /**
     * Prints out each of the pipe details then the order total cost
     * @author Lee 750834
     * @param orderNo The number of the order
     * @return Return invoice details
     */
    public String getInvoice(int orderNo) {
        String invoice = "";
        if (orderedPipes.size() > 0) {
            orderNumber ++;
            ArrayList<String> invoiceStrings = new ArrayList<>();

            String LINEBREAK = "";

            for (int i = 0; i < orderedPipes.size(); i++) {
                Pipe currentPipe = orderedPipes.get(i);
                String currentPipeType = "Pipe Order " + i;
                double individualPipeCost = currentPipe.calculateIndividualCost();
                double pipeMaterialCost = currentPipe.calculateMaterialCost(currentPipe.calculatePipeVolume(), currentPipe.getGrade());
                double pipeExtraCost = currentPipe.calculateExtraFeatureCost(pipeMaterialCost, currentPipe.calculatePercentageExtra());
                int pipeQuantity = currentPipe.getPipeQuantity();
                double totalCost = currentPipe.calculateTotalCost();
                
                invoiceStrings.add(generateInvoicePipeString(currentPipe, currentPipeType, "Individual Pipe Cost", individualPipeCost));
                invoiceStrings.add(generateInvoicePipeString(currentPipe, currentPipeType, "Pipe Material Cost", pipeMaterialCost));
                invoiceStrings.add(generateInvoicePipeString(currentPipe, currentPipeType, "Pipe Additional Feature Cost", pipeExtraCost));
                invoiceStrings.add(generateInvoicePipeString(currentPipe, currentPipeType, "Quantity of Pipes in Order", pipeQuantity));
                invoiceStrings.add(generateInvoicePipeString(currentPipe, currentPipeType, "Total Pipe Order Cost", totalCost));
            }

            invoiceStrings.add(LINEBREAK);

            String orderTotal = String.format("£%.2f", totalCost());
            orderTotal = formatInvoice("Total Cost:") + orderTotal;

            String orderRef = formatInvoice("Order Ref No:") + Integer.toString(orderNo);
            String[] dateTime = LongPipesSystem.getDateTime();
            String date = formatInvoice("Date:") + dateTime[0];
            String time = formatInvoice("Time:") + dateTime[1];
            String thankyouText = formatInvoice("Thanks for shopping with LongPipes"); 

            invoiceStrings.add(orderRef);
            invoiceStrings.add(orderTotal); 
            invoiceStrings.add(date);
            invoiceStrings.add(time);
            invoiceStrings.add(LINEBREAK);
            invoiceStrings.add(thankyouText);

            for (int i = 0; i < invoiceStrings.size(); i++) {
                invoice +=  invoiceStrings.get(i) + "\n";
            }

        } else {
            invoice = "Enter your order before attempting to complete your order.";
        }

        return invoice;
    }
    
    /**
     * @author Dan 801685
     * @return The order number
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * @author Lee 750834
     * @param inputString The string to be formatted
     * @return Return a formated string for the invoice
     */
    public static String formatInvoice(String inputString) {
        return String.format("%1$-" + 45 + "s", inputString);
    }

    /**
     * @author Dan 801685
     * @return The pipes within the orderedPipes arraylist
     */
    public ArrayList<Pipe> getOrderedPipes() {
        return orderedPipes;
    }
}
