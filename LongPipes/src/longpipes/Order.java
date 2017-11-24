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
        Random rand = new Random();
        orderNumber = rand.nextInt(9999) + 1;
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
     * @param orderNo
     * @return Return invoice details
     */
    public String getInvoice(int orderNo) {
        String invoice = "";
        if (orderedPipes.size() > 0) {
            ArrayList<String> invoiceStrings = new ArrayList<>();

            /*

            String innerInsulation = formatInvoice("Inner Insulation:", 40) + "£34.56";
            String outerReinforcement = formatInvoice("Outter Reinforcement:", 40) + "£23.34";
            String chemicalResistance = formatInvoice("Chemical Resistance:", 40) + "£11:33";
            String totalCostAdditionalFeatures = formatInvoice("Additional Features:", 40) + "£23.45";

            */

            String LINEBREAK = "";

            for (int i = 0; i < orderedPipes.size(); i++) {
                Pipe currentPipe = orderedPipes.get(i);

                String pipeStartString = "Pipe " + i + " cost: ";
                String pipeCost = String.format("£%.2f", currentPipe.calculateCost());
                String pipeInvoiceString = formatInvoice(pipeStartString, 40) + pipeCost;
                invoiceStrings.add(pipeInvoiceString);

                //NEED TO GET REST OF PIPE INFO, e.g breakdown of costs
            }

            invoiceStrings.add(LINEBREAK);

            String orderTotal = String.format("£%.2f", totalCost());
            orderTotal = formatInvoice("Total Cost:", 40) + orderTotal;

            String orderRef = formatInvoice("Order Ref No:", 40) + Integer.toString(orderNo);
            String[] dateTime = LongPipesSystem.getDateTime();
            String date = formatInvoice("Date:", 40) + dateTime[0];
            String time = formatInvoice("Time:", 40) + dateTime[1];
            String thankyou = "             Thanks for shopping with LongPipes";

            invoiceStrings.add(orderRef);
            invoiceStrings.add(date);
            invoiceStrings.add(time);
            invoiceStrings.add(LINEBREAK);
            invoiceStrings.add(thankyou);

            for (int i = 0; i < invoiceStrings.size(); i++) {
                invoice +=  invoiceStrings.get(i) + "\n";
            }

        } else {
            invoice = "Enter your order before attempting to complete your order.";
        }

        return invoice;
    }
    
    public int getOrderNumber() {
        return orderNumber;
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
